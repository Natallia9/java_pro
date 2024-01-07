package HW_18_12_2023;

public class Ex_2 {
    public static void main (String[] args){

        int x = 24;
        int y = 12;

        NumberOperation sum = Integer::sum;
        NumberOperation subtraction = (num1, num2) -> num1 - num2;
        NumberOperation multiplication = (num1, num2) -> num1 * num2;
        NumberOperation division = (num1, num2) -> num1 / num2;

        System.out.println(operate(x, y, sum));
        System.out.println(operate(x, y, subtraction));
        System.out.println(operate(x, y, multiplication));
        System.out.println(operate(x, y, division));
    }
    public static int operate(int num1, int num2, NumberOperation operation){
       return operation.numbers(num1, num2);
    }
    @FunctionalInterface
    interface NumberOperation{
        int numbers (int num1, int num2);
    }
}
