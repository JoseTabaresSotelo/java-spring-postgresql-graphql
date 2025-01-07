package com.ti.blog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.ti.blog.entity.SimpleCalculator;

public class SimpleCalculatorTest {

    @Test
    void twoPlusTwoShouldEqualFour() {
        SimpleCalculator calculator = new SimpleCalculator();

        assertEquals(4, calculator.add(2, 2));
        assertNotEquals(5, calculator.add(2, 2));
        assertTrue(calculator.add(2, 2) == 4);
        assertFalse(calculator.add(2, 2) != 4);
    }

    @Test
    void otherAddition() {
        // Auto inferring the type from new object
        var calculator = new SimpleCalculator();

        assertEquals(13, calculator.add(3, 10));
    }

}
