#!/usr/bin/env python
# coding: utf-8
#
# Copyright (c) 2017 Contact Software.
#
# All rights reserved. This program and the accompanying materials are
# made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution.
#
# The Eclipse Public License is available at
#     http://www.eclipse.org/legal/epl-v10.html

from __future__ import unicode_literals, absolute_import, division

import os
import glob
import scipy as sp
from sklearn.naive_bayes import GaussianNB
from sklearn.externals import joblib

from . import stats


here = os.path.abspath(os.path.dirname(__file__))

STD_TRAINING_DATA = os.path.join(here, 'training-data')
STD_CLASSIFIER_PATH = os.path.join(here, 'trained-classifier.pkl')


class Classifier(object):

    def __init__(self, clf=None):
        if not clf:
            clf = GaussianNB()

        self._clf = clf

    def train(self, training_data=STD_TRAINING_DATA):

        data = []
        target = []

        for result_type in os.listdir(training_data):
            full_path = os.path.join(training_data, result_type)

            if not os.path.isdir(full_path):
                continue

            for data_set_file in glob.glob(os.path.join(full_path, '*')):
                characteristics = stats.load_from_file(data_set_file)

                data.append(characteristics)
                target.append(result_type)

        self._clf.fit(sp.array(data), sp.array(target))

    def store_classifier(self, path=STD_CLASSIFIER_PATH):
        joblib.dump(value=self._clf, filename=path)

    @classmethod
    def from_file(cls, path=STD_CLASSIFIER_PATH):
        return cls(joblib.load(path))

    def predict(self, data):
        return self._clf.predict(data)


if __name__ == '__main__':
    # NOTE [bgu 11-10-2017]: This is rather an internal API for testing, but
    # does not hurt to document it properly!
    import click as c
    c.disable_unicode_literals_warning = True


    @c.command(context_settings={'help_option_names': ['-h', '--help']})
    @c.argument('input-data', type=c.Path(exists=True, dir_okay=False))
    @c.option(
        '--classifier-path',
        default=STD_CLASSIFIER_PATH,
        show_default=True,
        type=c.Path(dir_okay=False),
        help='Path of stored classifier'
    )
    def predict(input_data, classifier_path):
        """
        Predicts/classifies the raw data set of the passed text file

        """
        clf = Classifier.from_file(classifier_path)
        characteristics = stats.load_from_file(input_data)
        result = clf.predict([characteristics])[0]

        characteristics_report = '\n'.join([
            '%s: %s' % pair
            for pair in zip(stats.CHARACTERISTICS, characteristics)]
        )

        report = 'result: %s\n\n%s' % (result, characteristics_report)
        c.echo(report)

    predict()
