// File: 01_CoreJava/16_JUnit_Mockito_Testing/01_JUnit_Basics/Calculator.java
package com.javahub.corejava.testing;

/**
 * A simple utility class to perform basic arithmetic operations.
 * This class will be tested using JUnit.
 */
public class Calculator {

    /**
     * Adds two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of a and b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     * @param a The first integer.
     * @param b The second integer.
     * @return The result of a minus b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The product of a and b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second.
     * @param a The first integer (dividend).
     * @param b The second integer (divisor).
     * @return The result of a divided by b.
     * @throws IllegalArgumentException if the divisor is zero.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        return (double) a / b;
    }
}
