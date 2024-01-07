package HW_18_12_2023;

import java.util.Arrays;

public class Ex_6 {
    public static void main (String[] args){
        int[] array = {2, 5, 12, 4, 6};

        ArrayTransformer arrayTransformer = array1 -> Arrays.stream(array1).map(num -> num * num).toArray();
        System.out.println((Arrays.toString(transform(array, arrayTransformer))));
    }
    public static int[] transform(int[] numbers, ArrayTransformer transformer){
        return transformer.arr(numbers);
    }
    @FunctionalInterface
    interface ArrayTransformer{
        int[] arr (int[] array);
    }
}
