#!/usr/bin/env python
# coding: utf-8
#
# Copyright (C) 1990 - 2017 CONTACT Software GmbH
# All rights reserved.
# http://www.contact.de/
#


from __future__ import unicode_literals, absolute_import, division


from unide import util
from unide.measurement import MeasurementPayload
from unide.measurement import Measurement

from . import stats
from . import io


def process_inbound_message(msg, classifier, endpoint=None):
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

    serialized_out = util.dumps(outbound_msg, indent=2)

    if not endpoint:
        io.stdout(serialized_out)
        return

    io.post(endpoint, serialized_out)
    io.stderr('Message succesfully sent to: %s\n%s' % (endpoint, serialized_out))

