Unide Grinding Machine
======================

This programme simulates the constrained device of the Unide grinding machine scenario. It reads data
from the grinding machine, generates a PPMP message with help of the library ``unide-python``,
and sends it to the gateway.


How to install
--------------

The easiest way is via direct git checkout and `conda environments
<https://conda.io>`_ (in case you are not familiar with this, just install
`miniconda <https://conda.io/miniconda.html>`_ and you are good to go). To do
so, follow these steps:

- ``git clone <repo-url>``
- ``cd eclipseiot-testbed-productionperformancemanagement/grinding-machine/unide-grinding-machine``
- ``conda env create --prefix=env``

Once installed, the conda environment has to be activated. Depending on your
platform, this may be ``activate env`` or ``source activate env``. Then the
command ``unide-grinding-machine`` should be accessible::

Once installed, the command ``unide-grinding-machine`` should be accessible::

    > unide-grinding-machine -h
    Usage: unide-grinding-machine [OPTIONS] COMMAND [ARGS]...

    Options:
      -h, --help  Show this message and exit.

    Commands:
      from_file  Parses a raw data set, generates a PPMP...
      send       Creates and sends a standard PPMP message.


CLI Documentation
-----------------

Every command and subcommand is provided with documentation. For instance, if
you want to know how ``send`` works, just call it passing ``-h`` or
``--help``::

  > unide-grinding-machine send -h
  Usage: unide-grinding-machine send [OPTIONS] RESULT

    Creates and sends a standard PPMP message. RESULT must be one of: good,
    medium, bad. A data set will be randomly chosen within the result type.

  Options:
    --endpoint TEXT   URL of HTTP endpoint to POST the PPMP message to. If not
                      provided, it will be sent to stdout
    --device-id TEXT  ID of device to be sent  [default: device-001]
    -h, --help        Show this message and exit.


Basic test
----------
Run the command ``unide-grinding-machine send good`` (``pwd`` must be the repository root).
This will load a data set classified as ``good`` and output the results to stdout.
