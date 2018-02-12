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

"""
Main module

"""

from __future__ import unicode_literals, absolute_import, division, print_function

import os
import sys
import random
import requests

from unide.measurement import MeasurementPayload
from unide.measurement import Device
from unide.measurement import Measurement
from unide import util


here = os.path.dirname(__file__)
raw_data = os.path.join(here, 'raw-data')


def print_out(msg):
    print(msg, file=sys.stdout)


def print_err(msg):
    print('unide-grinding-machine:', msg, file=sys.stderr)


def make_message_from_result_type(result, dev_id):
    result = result.lower()

    if result == 'random':
        result = random.choice(result_types)

    if result not in result_types:
        raise ValueError('Not valid result: %s' % result)

    dir_path = os.path.join(raw_data, result)

    if not os.path.isdir(dir_path):
        raise Exception(dir_path)

    path = os.path.join(dir_path, random.choice(os.listdir(dir_path)))

    return make_message_from_file_path(path, dev_id)


result_types = ['good', 'medium', 'bad']


PERIOD_IN_MS = 20


def make_message_from_file_path(path, dev_id):
    with open(path) as f:
        lines = filter(None, [l.strip() for l in f])

        data_points = [
            tuple(map(float, line.strip().split(',')))
            for line in lines
        ]

    meas = Measurement()

    dimensions = ['x', 'y', 'z']

    for dim in dimensions:
        meas.series.add_dimension(dim)

    for idx, point in enumerate(data_points):
        meas.series.offsets.append(idx * PERIOD_IN_MS)

        for dim, val in zip(dimensions, point):
            meas.series[dim].append(val)

    return MeasurementPayload(
        device=Device(deviceID=dev_id),
        measurements=[meas],
    )


def send(payload, endpoint=None):
    """
    Converts the payload to json and sends it to the endpoint. If no endpoint given, it will be printed
    to stdout.

    """
    plain_payload = util.dumps(payload, indent=2)

    if not endpoint:
        print_out(plain_payload)
        return

    try:
        r = requests.post(endpoint, data=plain_payload)
        r.raise_for_status()

    except requests.exceptions.ConnectionError as exc:
        print_err('Failed to connect')

    except requests.exceptions.HTTPError as exc:
        print_err('Error, server returned: %s' % exc.response.status_code)

    else:
        print_err('Successfully sent to endpoint:\n%s' % plain_payload)

