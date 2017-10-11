#!/usr/bin/env python
# coding: utf-8
#
# Copyright (C) 1990 - 2017 CONTACT Software GmbH
# All rights reserved.
# http://www.contact.de/
#

from __future__ import absolute_import, division, print_function

import sys
import click as c

from . import unide_grinding_machine as ugm

CONTEXT_SETTINGS = {'help_option_names': ['-h', '--help']}


@c.group(context_settings=CONTEXT_SETTINGS)
def main():
    pass


endpoint_opt = c.option(
    '--endpoint',
    help='URL of HTTP endpoint to POST the PPMP message to. If not provided, it will be sent to stdout'
)


device_opt = c.option(
    '--device-id',
    help='ID of device to be sent',
    default='device-001',
    show_default=True,
)


@main.command()
@c.argument('result')
@endpoint_opt
@device_opt
def send(result, device_id, endpoint):
    """
    Creates and sends a standard PPMP message. RESULT must be one of: good, medium, bad.
    A data set will be randomly chosen within the result type.

    """
    if result not in ['good', 'medium', 'bad']:
        c.echo('Not a valid result: %s' % result, err=True)
        return 1

    msg = ugm.make_message_from_result_type(result, device_id)
    ugm.send(msg, endpoint)


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
