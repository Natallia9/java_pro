package HW_18_12_2023;

import java.util.Arrays;

public class Ex_8 {
    public static void main (String[] args){
        int[][] matrixArray = {{1, 2, 3},
                               {4, 5, 6},
                               {7, 8, 9}};

        MatrixProcessor matrixProcessor = matrixNew -> {
            int[][] transposed = new int[matrixNew[0].length][matrixNew.length];
            for (int i = 0; i < matrixNew.length; i++) {
                for (int j = 0; j < matrixNew[0].length; j++) {
                    transposed[j][i] = matrixNew[i][j];
                }
            }
            return transposed;
        };
        System.out.println(Arrays.deepToString(process(matrixArray, matrixProcessor)));
    }
    public static int[][] process(int[][] array, MatrixProcessor matrixProcessor){
        return matrixProcessor.matrix(array);
    }

    @FunctionalInterface
    interface MatrixProcessor{
        int[][] matrix(int[][] matrix);
    }
}
