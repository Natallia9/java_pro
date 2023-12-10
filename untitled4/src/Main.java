public class Main {
    public static void main(String[] args) {

        int[] array = {5, 7, 10, 12, 6};
        int sum = arraySum(array, 0);
        System.out.println("Сумма " + sum);
    }
    public static int arraySum(int[] arr, int n) {
        if (n == arr.length) {
            return 0;
        } else {
            return arr[n] + arraySum(arr, n);
        }
    }

}

