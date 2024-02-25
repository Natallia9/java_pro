package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    @Test
    void addTest() {
        int a = 5;
        int b = 10;
        int expected = 15;
        Assertions.assertEquals(expected, Calc.add(a, b));
    }

    @Test
    void subtractTest() {
        int a = 10;
        int b = 5;
        int expected = 5;
        Assertions.assertEquals(expected, Calc.subtract(a, b));
    }


    @Test
    void multiplyTest() {
        int a = 10;
        int b = 5;
        int expected = 50;
        Assertions.assertEquals(expected, Calc.multiply(a, b));
    }

    @Test
    void divideTest() {
        int a = 10;
        int b = 5;
        int expected = 2;
        Assertions.assertEquals(expected, Calc.divide(a, b));
    }
    @Test
    void divideWithIllegalArgumentExceptionTest() {
        int a = 10;
        int b = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calc.divide(a, b));
    }

    @Test
    void powerTest() {
        double a = 2;
        double b = 3;
        double expected = 8;
        Assertions.assertEquals(expected, Calc.power(a, b));
    }

    @Test
    void factorialTest() {
        double a = 5;
        double expected = 120;
        Assertions.assertEquals(expected, Calc.factorial(a));
    }
    @Test
    void factorialWithIllegalArgumentExceptionTest() {
        double a = -5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calc.factorial(a));
    }

    @Test
    void absoluteTest() {
        double a = -5.0;
        double expected = 5.0;
        Assertions.assertEquals(expected, Calc.absolute(a));
    }

    @Test
    void sqrtTest() {
        double a = 4;
        double expected = 2;
        Assertions.assertEquals(expected, Calc.sqrt(a));
    }
    @Test

    void sqrtWithIllegalArgumentExceptionTest() {
        double a = -4;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calc.sqrt(a));
    }

    @Test
    void logarithmTest() {
        double a = 16;
        double b = 2;
        double expected = 4;
        Assertions.assertEquals(expected, Calc.logarithm(a, b));
    }

    @Test
    void sinTest() {
        double a = 30;
        double radians = Calc.radians(a);
        double expected = 0.5;
        double result = Calc.sin(radians);
        Assertions.assertEquals(expected, result, 1e-6);
    }

}