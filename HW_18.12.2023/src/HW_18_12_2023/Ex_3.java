package HW_18_12_2023;

import java.util.Optional;

public class Ex_3 {
    public static void main (String[] args){

        int x = 12;
        int y = 2;

        SafeDivision safeDivision = (num1, num2) -> (num2 != 0) ? Optional.of((double) num1 / num2) : Optional.empty();

        System.out.println(divide(x, y, safeDivision));
    }
    public static Optional<Double> divide(int num1, int num2, SafeDivision safeDivision) {
        return safeDivision.numbers(num1, num2);
    }
    @FunctionalInterface
    interface SafeDivision<Double>{
        Optional<Double> numbers (int first, int last);
    }
}
