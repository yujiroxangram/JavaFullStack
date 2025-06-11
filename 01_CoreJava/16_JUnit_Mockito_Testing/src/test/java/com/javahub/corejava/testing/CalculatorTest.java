// File: 01_CoreJava/16_JUnit_Mockito_Testing/01_JUnit_Basics/CalculatorTest.java
package com.javahub.corejava.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for the Calculator utility.
 * Demonstrates basic test annotations and assertions.
 */
@DisplayName("Calculator Operations Test")
public class CalculatorTest {

    private Calculator calculator;

    /**
     * This method runs before each test method.
     * It's used to set up the test environment (e.g., initialize objects).
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    /**
     * Test case for the add method.
     */
    @Test
    @DisplayName("Should correctly add two positive numbers")
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        assertEquals(5, calculator.add(2, 3));
    }

    /**
     * Test case for adding zero.
     */
    @Test
    @DisplayName("Should correctly add a positive number and zero")
    void add_PositiveNumberAndZero_ReturnsPositiveNumber() {
        assertEquals(10, calculator.add(10, 0));
    }

    /**
     * Test case for subtracting numbers.
     */
    @Test
    @DisplayName("Should correctly subtract two numbers")
    void subtract_TwoNumbers_ReturnsCorrectDifference() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-5, calculator.subtract(5, 10));
    }

    /**
     * Test case for multiplication.
     */
    @Test
    @DisplayName("Should correctly multiply two numbers")
    void multiply_TwoNumbers_ReturnsCorrectProduct() {
        assertEquals(12, calculator.multiply(3, 4));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(3, -5));
    }

    /**
     * Test case for division.
     */
    @Test
    @DisplayName("Should correctly divide two numbers")
    void divide_TwoNumbers_ReturnsCorrectQuotient() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001); // Delta for double comparison
        assertEquals(2.0, calculator.divide(4, 2));
    }

    /**
     * Test case to verify that division by zero throws an exception.
     */
    @Test
    @DisplayName("Should throw IllegalArgumentException when dividing by zero")
    void divide_ByZero_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Divisor cannot be zero.", exception.getMessage());
    }
}
