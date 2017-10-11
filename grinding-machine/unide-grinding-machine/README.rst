Unide Grinding Machine
======================

This programme simulates the constrained device of the Unide grinding machine scenario. It reads data
from the grinding machine, generates a PPMP message with help of the library ``unide-python``,
and sends it to the gateway.


How to install
--------------
The easiest way is via direct git checkout and conda environments. To do so, follow these steps:

- ``git clone <repo-url> && cd unide-grinding-machine``
- ``conda env create --file=environment.yml --prefix=env``
- activate the conda environment. Depending on your platform, this may be
  ``activate env`` or ``source activate env``
- ``pip install .`` or, if you wish to tinker with the source code: ``pip install --editable=.``


Once installed, the command ``unide-grinding-machine`` should be accessible::

    > unide-grinding-machine -h
    Usage: unide-grinding-machine [OPTIONS] COMMAND [ARGS]...

    Options:
      -h, --help  Show this message and exit.

    Commands:
      from_file  Parses a raw data set, generates a PPMP...
      send       Creates and sends a standard PPMP message.


Basic test
----------
Run the command ``unide-grinding-machine send good`` (``pwd`` must be the repository root).
This will load a data set classified as ``good`` and output the results to stdout.
