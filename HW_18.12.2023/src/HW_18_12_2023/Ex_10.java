package HW_18_12_2023;

import java.util.Arrays;

public class Ex_10 {
    public static void main (String[] args){
        int[] array = {1, 3, 5, 9, 7};

        ArrayRotator arrayNew = (arr, shift) -> {
            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int num = (i + shift) % arr.length;
                if (num < 0) {
                    num += arr.length;
                }
                result[num] = arr[i];
            }
            return result;
        };
        int[] rotatedArray = rotate(array, 1, arrayNew);
        System.out.println(Arrays.toString(rotatedArray));
    }
    public static int[] rotate(int[] arr, int shift, ArrayRotator arrayRotator){
        return arrayRotator.rotator(arr, shift);
    }
    @FunctionalInterface
    interface ArrayRotator{
        int[] rotator (int[] array, int shift);
    }
}
