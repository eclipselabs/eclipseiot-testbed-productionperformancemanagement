#!/usr/bin/env python
# coding: utf-8
#
# Copyright (C) 1990 - 2017 CONTACT Software GmbH
# All rights reserved.
# http://www.contact.de/
#

from __future__ import unicode_literals, absolute_import, division, print_function

import sys
import requests


def stderr(msg):
    print('unide_grinding_machine_gateway: %s' % msg, file=sys.stderr)


def stdout(msg):
    print(msg)


def post(url, payload):
    r = requests.post(url, payload)
    r.raise_for_status()
