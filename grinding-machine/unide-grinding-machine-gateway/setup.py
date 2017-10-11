#!/usr/bin/env python
# coding: utf-8

from setuptools import setup, find_packages

with open('README.rst') as readme_file:
    readme = readme_file.read()

setup(
    name='unide-grinding-machine-gateway',
    version='0.1.0',
    description="Part of Unide testbeds. Usage example of unide-python with some ML",
    long_description=readme,
    author="Bor Gonzalez-Usach",
    author_email='bgu@contact.de',
    packages=find_packages('src'),
    license="Eclipse Public License",
    package_dir={'': 'src'},
    entry_points={
        'console_scripts': [
            'unide-grinding-machine-gateway=unide_grinding_machine_gateway.__main__:main'
        ]
    },
    include_package_data=True,
    install_requires=[
        'scikit-learn',
        'scipy',
        'morepath',
        'click',
        'requests',
        'unide-python',
    ],
)
