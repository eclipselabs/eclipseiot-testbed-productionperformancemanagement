#!/usr/bin/env python
# coding: utf-8
#
# Copyright (C) 1990 - 2017 CONTACT Software GmbH
# All rights reserved.
# http://www.contact.de/
#

from __future__ import unicode_literals, absolute_import, division

import morepath

from . import core
from . import io


class App(morepath.App):

    def __init__(self, classifier, endpoint):
        self.unide_clf = classifier
        self.unide_endpoint = endpoint


@App.path(path='')
class Root(object):
    pass


@App.view(model=Root, request_method='POST')
def parse_message(self, request):
    io.stderr('Message received: %s...\n' % request.body[:70])

    core.process_inbound_message(
        msg=request.body,
        classifier=request.app.unide_clf,
        endpoint=request.app.unide_endpoint,
    )


def start_server(classifier, endpoint):
    morepath.run(App(classifier, endpoint), ignore_cli=True)


