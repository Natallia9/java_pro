package HW_18_12_2023;

public class Ex_1 {
    public static void main (String[] args){
        String str = "Natalia";
        stringLength(str, String::length);
    }
    public static void stringLength(String string, StringLength length) {
        int quantity = length.getLength(string);
        System.out.println("Длина строки: " + quantity);
    }
    @FunctionalInterface
    interface StringLength {
        int getLength(String str);
    }
}
