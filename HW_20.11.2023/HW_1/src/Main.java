import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        String arr[] = {" I'm", " a", " Tel-Ran", " student"};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        // Задание 2

        int numbers[] = {23, 40, 67, 12, 8, 52};
        for (int i = 0; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }

        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > first) {
                second = first;
                first = numbers[i];
            } else if (numbers[i] > second) {
                third = second;
                second = numbers[i];
            } else if (numbers[i] > third) {
                third = numbers[i];
            }
        }
        System.out.println();
        System.out.print("Третье по величине число: " + third);


        }
    }


