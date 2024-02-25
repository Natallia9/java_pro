package org.example;

public class Calc {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деленеие на ноль невозможно");
        }
        return a / b;
    }

    public static double power(double a, double b) {
        double result = 1;
        for (double i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static double factorial(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Факториал не определен для отрицательных чисел");
        }
        if (a == 0)
            return 1;
        else
            return a * factorial(a - 1);
//        if (a == 0) {
//            return 1;
//        }
//        double result = 1;
//        for (double i = 1; i <= a; i++) {
//            result *= i;
//        }
//        return result;
    }

    public static double absolute(double a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    public static double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Корень из отрицательного числа не определен");
        }
        double result = a / 2;
        double temp;
        do {
            temp = result;
            result = (temp + a / temp) / 2;
        } while ((temp - result) != 0);

        return result;
    }

    public static double logarithm(double b, double a) {
        double result = 0;
        while (b >= a) {
            b /= a;
            result++;
        }
        return result;
    }

    public static double sin(double a) {
        double sinValue = 0;
        for (int i = 0; i < 10; i++) { // Вычисляем первые 10 членов ряда Маклорена
            sinValue += power(-1, i) * power(a, 2 * i + 1) / factorial(2 * i + 1);
        }
        return sinValue;
    }
    public static double radians(double a){
        double pi = 3.14159265358979323846;
        return a * (pi / 180);
    }

}
