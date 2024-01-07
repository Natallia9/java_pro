package HW_18_12_2023;

import java.util.Arrays;

public class Ex_9 {
    public static void main (String[] args){
        int[] array = {2, 4, 6, 8, 10};

        NumberProcessor processor = arr -> Arrays.stream(arr).map(num -> num * -1).toArray();
        System.out.println(Arrays.toString(process(array, processor)));
    }
    public static int[] process (int[] array, NumberProcessor numberProcessor){
        return numberProcessor.multiplication(array);
    }
    @FunctionalInterface
    interface NumberProcessor{
        int[] multiplication(int[] arr);
    }
}
