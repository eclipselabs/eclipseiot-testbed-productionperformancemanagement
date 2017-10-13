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

import sys
import os
import click as c

from . import ml
from . import server
from . import io
from . import core


CONTEXT_SETTINGS = {'help_option_names': ['-h', '--help']}


@c.group(context_settings=CONTEXT_SETTINGS)
def main():
    pass


clf_path = c.option(
    '--classifier-path',
    default=ml.STD_CLASSIFIER_PATH,
    show_default=True,
    type=c.Path(dir_okay=False),
    help='Path of stored classifier'
)

http_endpoint = c.option(
    '--endpoint',
    help='HTTP endpoint to POST the results. If not provided, stdout will be used',
)


@main.command()
@c.option('--training-data', default=ml.STD_TRAINING_DATA, show_default=True, type=c.Path(exists=True, file_okay=False))
@clf_path
def train(training_data, classifier_path):
    """
    Trains the classifier

    """
    clf = ml.Classifier()
    clf.train(training_data)
    clf.store_classifier(path=classifier_path)
    c.echo('Classifier successfully trained', err=True)


@main.command()
@clf_path
@http_endpoint
def start_server(classifier_path, endpoint):
    """
    Starts demo server that listens to PPMP messages

    """
    server.start_server(ml.Classifier.from_file(classifier_path), endpoint)


@main.command()
@c.argument('ppmp-msg-path')
@http_endpoint
@clf_path
def receive_message(ppmp_msg_path, endpoint, classifier_path):
    """
    Processes an PPMP message coming from the Grinding Machine.

    PPMP_MSG_PATH: path of file with PPMP message. If '-', file will be read from stdin

    """
    if ppmp_msg_path == '-':
        input_file = sys.stdin

    elif not os.path.isfile(ppmp_msg_path):
        io.stderr('File does not exist: %s' % ppmp_msg_path)
        return 1

    else:
        input_file = open(ppmp_msg_path)

    with input_file:
        raw_msg = input_file.read()

    core.process_inbound_message(
        raw_msg,
        classifier=ml.Classifier.from_file(classifier_path),
        endpoint=endpoint,
    )


if __name__ == '__main__':
    main()
