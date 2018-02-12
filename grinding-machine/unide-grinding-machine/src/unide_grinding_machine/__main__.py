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

from __future__ import absolute_import, division, print_function

import sys
import click as c
import time

from . import unide_grinding_machine as ugm

CONTEXT_SETTINGS = {'help_option_names': ['-h', '--help']}


@c.group(context_settings=CONTEXT_SETTINGS)
def main():
    pass


endpoint_opt = c.option(
    '--endpoint', '-e',
    help='URL of HTTP endpoint to POST the PPMP message to. If not provided, it will be sent to stdout'
)


device_opt = c.option(
    '--device-id', '-d',
    help='ID of device to be sent',
    default='device-001',
    show_default=True,
)


@main.command()
@c.argument('result')
@endpoint_opt
@device_opt
@c.option(
    '--period', '-p',
    type=c.FLOAT,
    help='Optionally run in loop waiting the passed amount of seconds between measurements')
def send(result, device_id, endpoint, period):
    """
    Creates and sends a standard PPMP message. RESULT must be one of: 'good', 'medium', 'bad' or 'random'
    A data set will be randomly chosen within the result type.

    """
    if result not in ugm.result_types + ['random']:
        c.echo('Not a valid result: %s' % result, err=True)
        return 1

    def run():
        msg = ugm.make_message_from_result_type(result, device_id)
        ugm.send(msg, endpoint)

    if period is None:
        run()
        return

    while True:
        run()
        time.sleep(period)


@main.command()
@c.argument('path', type=c.Path(exists=True, dir_okay=False))
@endpoint_opt
@device_opt
def from_file(path, device_id, endpoint):
    """
    Parses a raw data set, generates a PPMP message and and sends it.

    """
    msg = ugm.make_message_from_file_path(path, device_id)
    ugm.send(msg, endpoint)


if __name__ == '__main__':
    sys.exit(main())
