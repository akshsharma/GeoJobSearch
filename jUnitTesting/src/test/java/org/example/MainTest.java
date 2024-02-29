package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testAddNumbers() {
        // Testing the addNumbers method
        assertEquals(5, Main.addNumbers(2, 3), "2 + 3 should equal 5");
        assertEquals(10, Main.addNumbers(7, 3), "7 + 3 should equal 10");
    }
}

