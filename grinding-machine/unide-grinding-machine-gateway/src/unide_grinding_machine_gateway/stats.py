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

import scipy as sp
import scipy.stats


def rms(data):
    return sp.sqrt(sp.mean(sp.square(data)))


def skewness(data):
    return sp.stats.skew(data)


def deviation(data):
    return sp.stats.tstd(data)


def load_from_file(path):
    data = sp.loadtxt(path, delimiter=b',')
    x = data[:, 0]
    y = data[:, 1]
    z = data[:, 2]

    return get_series_characteristics(x, y, z)


def load_from_ppmp_msg(msg):
    # FIXME [bgu 04-10-2017]: handle multiple measurements...
    series = msg.measurements[0].series
    return get_series_characteristics(series.x, series.y, series.z)


# TODO [bgu 04-10-2017]: better name
def get_series_characteristics(x, y, z):
    return sp.array(
        [fn(axis) for fn in [rms, skewness, deviation] for axis in [x, y, z]]
    )


# NOTE [bgu 10-10-2017]: characteristic names as they are returned by get_series_characteristics
CHARACTERISTICS = [
    '%s.%s' % (char, axis)
    for char in ['rms', 'skewness', 'deviation']
    for axis in ['x', 'y', 'z']
]
