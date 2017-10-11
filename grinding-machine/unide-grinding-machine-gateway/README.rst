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


Basic test
----------
Run the command ``unide-grinding-machine-gateway receive_message samples/sample-ppmp.json``
(``pwd`` must be the repository root). This will load a sample message and output the results to stdout.
