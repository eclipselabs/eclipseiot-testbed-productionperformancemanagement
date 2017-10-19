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

from unide import util
from unide.measurement import MeasurementPayload
from unide.measurement import Measurement

from . import stats


def process_inbound_message(msg, classifier):
    inbound_msg = util.loads(msg, validate=True)

    data = stats.load_from_ppmp_msg(inbound_msg)

    result = classifier.predict([data])[0]

    meas = Measurement(
        ts=inbound_msg.measurements[0].ts,
        result='NOK' if result == 'bad' else 'OK'
    )

    meas.series.offsets.append(0)

    for dim, val in zip(stats.CHARACTERISTICS, data):
        meas.series.add_dimension(dim)
        meas.series[dim].append(val)

    outbound_msg = MeasurementPayload(
        device=inbound_msg.device,
        measurements=[meas]
    )

    return util.dumps(outbound_msg, indent=2)
