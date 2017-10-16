Unide Grinding Machine Gateway
==============================

This programme simulates the gateway of the Unide grinding machine scenario. It receives PPMP messages
from the grinding machine, applies some machine learning processes, creates a meaningful result out
of the raw data, and sends it somewhere else.


How to install
--------------

The easiest way is via direct git checkout and conda environments. To do so, follow these steps:

- ``git clone <repo-url> && cd unide-grinding-machine-gateway``
- ``conda env create --file=environment.yml --prefix=env``
- activate the conda environment. Depending on your platform, this may be
  ``activate env`` or ``source activate env``
- ``pip install .`` or, if you wish to tinker with the source code: ``pip install --editable=.``


Once installed, the command ``unide-grinding-machine-gateway`` should be accessible::

    > unide-grinding-machine-gateway -h
    Usage: unide-grinding-machine-gateway [OPTIONS] COMMAND [ARGS]...

    Options:
      -h, --help  Show this message and exit.

    Commands:
      receive_message  Processes an PPMP message coming from the...
      server           Starts demo server that listens to PPMP...
      train            Trains the classifier

CLI Documentation
-----------------

Every command and subcommand is provided with documentation. For instance, if
you want to know how ``receive_message`` works, just call it passing ``-h`` or
``--help``::

  > unide-grinding-machine-gateway receive_message -h
  Usage: unide-grinding-machine-gateway receive_message [OPTIONS] PPMP_MSG_PATH

    Processes an PPMP message coming from the Grinding Machine.

    PPMP_MSG_PATH: path of file with PPMP message. If '-', file will be read
    from stdin

  Options:
    --endpoint TEXT         HTTP endpoint to POST the results. If not provided,
                            stdout will be used
    --classifier-path PATH  Path of stored classifier  [default: c:\dev\repos
                            \unide-testbed\grinding-machine\unide-grinding-
                            machine-gateway\src\unide_grinding_machine_gateway
                            \trained-classifier.pkl]
    -h, --help              Show this message and exit.




Examples
--------

Basic local
'''''''''''

Run the command ``unide-grinding-machine-gateway receive_message
samples/sample-ppmp.json`` (``pwd`` must be the repository root). This will
load a sample message and output the results to stdout.


Basic with remote backend
'''''''''''''''''''''''''

This example is almost the same as the previous one, with the only difference that
the results will be sent via PPMP over HTTP to a given backend. Given the imaginary
backend endpoint ``http://some-random-backend.com/ppmp-msg``::

  unide-grinding-machine-gateway receive_message samples/sample-ppmp.json --endpoint=http://some-random-backend.com/ppmp-msg


Local server connected to backend
'''''''''''''''''''''''''''''''''

This is a more realistic scenario, in which ``unide-grinding-machine-gateway``
acts as a HTTP server waiting on incoming messages, processing any inbound
message and transferring the results via PPMP/HTTP to another backend.

For instance, given the endpoint ``http://some-random-backend.com/ppmp-msg``,
the CLI call would look like this::

  > unide-grinding-machine-gateway start_server --endpoint=http://some-random-backend.com/ppmp-msg
  Running <unide_grinding_machine_gateway.server.App object at 0x0792EED0>
  Listening on http://127.0.0.1:5000
  Press Ctrl-C to stop...
 
(So far, this will only listen on ``localhost:5000``)

This service can be easily addressed by `unide-grinding-machine <../unide-grinding-machine>`_.

