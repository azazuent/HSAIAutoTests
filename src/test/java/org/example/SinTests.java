package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SinTests extends CalculatorTests {
    @ParameterizedTest
    @CsvSource({"0, 0", "0.5, 0.52", "0.7, 0.79", "0.87, 1.05", "1, 1.57", "0, 3.14", "-1, 4.71"})
    void testTableValues(double expected, double input) {
        assertEquals(expected, calculator.sin(input), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"0", "0.79", "1.57"})
    void testPlus2Pi(double input) {
        assertEquals(calculator.sin(input + 2 * Math.PI), calculator.sin(input), DELTA);
    }
}
