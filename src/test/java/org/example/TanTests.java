package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TanTests extends CalculatorTests {
    @ParameterizedTest
    @CsvSource({"0, 0", "0.57, 0.52", "1, 0.79", "1.73, 1.05"})
    void testTableValues(double expected, double input) {
        assertEquals(expected, calculator.tg(input), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.57, 4.71})
    void testInfinity(double input) {
        assertEquals(Double.POSITIVE_INFINITY, calculator.tg(input), DELTA);
    }
}
