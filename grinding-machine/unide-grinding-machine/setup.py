#!/usr/bin/env python
# coding: utf-8

from setuptools import setup, find_packages

with open('README.rst') as readme_file:
    readme = readme_file.read()

setup(
    name='unide-grinding-machine',
    version='0.1.0',
    description="Part of Unide testbeds. Usage example of unide-python",
    long_description=readme,
    author="Bor Gonzalez-Usach",
    author_email='bgu@contact.de',
    license="Eclipse Public License",
    packages=find_packages('src'),
    package_dir={'': 'src'},
    entry_points={
        'console_scripts': [
            'unide-grinding-machine=unide_grinding_machine.__main__:main'
        ]
    },
    include_package_data=True,
    install_requires=[
        'click',
        'unide-python',
        'requests',
    ],
)
