package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorAAATest {

    private Calculator calculator;

    // Setup: runs before EACH test method
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created.");
    }

    // Teardown: runs after EACH test method
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance cleared.");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 4;
        int b = 3;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 20;
        int b = 4;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(5, result);
        assertTrue(result > 0);
    }
}
