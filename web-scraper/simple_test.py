# I'm trying to figure out pytest - Tyler

import json
import os
import pytest

def test_one_plus_one():
    assert 1 + 1 == 2 # this should succeed

def test_coverage():
    x = 0
    if x == 1:
        x = 2 # this line will be skipped -
        # I'm just trying this out to make sure I understand how coverage works. 
        # It won't count this line, becasue it isn't executed.
    else:
        x = 3
    assert x == 3 