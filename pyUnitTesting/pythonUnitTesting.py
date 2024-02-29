import unittest
from test import add

class TestAddFunction(unittest.TestCase):
    def test_add_positive_numbers(self):
        self.assertEqual(add(2, 3), 5, "Should be 7")

    def test_add_negative_numbers(self):
        self.assertEqual(add(-1, -1), -2, "Should be -2")

    def test_add_positive_and_negative_number(self):
        self.assertEqual(add(-5, 5), 0, "Should be 0")

if __name__ == '__main__':
    unittest.main()