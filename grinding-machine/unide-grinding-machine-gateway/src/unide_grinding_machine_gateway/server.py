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

import morepath

from . import core
from . import io


class App(morepath.App):

    def __init__(self, classifier, forward):
        """
        :param classifier: instance of ML classifier
        :param forward: callback to call with results to forward data to the desired place

        """
        self.unide_clf = classifier
        self.unide_forward = forward


@App.path(path='')
class Root(object):
    pass


@App.view(model=Root, request_method='POST')
def parse_message(self, request):
    io.stderr('Message received: %s...\n' % request.body[:70])

    result = core.process_inbound_message(
        msg=request.body,
        classifier=request.app.unide_clf,
    )

    request.app.unide_forward(result)


def start_server(classifier, endpoint, auth):
    if endpoint:
        post = io.create_poster(endpoint, auth)

        def forward(payload):
            post(payload)
            io.stderr('Message succesfully sent to: %s\n%s' % (endpoint, payload))

    else:
        forward = io.stdout

    morepath.run(App(classifier, forward), ignore_cli=True)


