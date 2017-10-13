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
