package array;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2020/12/18 9:50
 * @Version 1.0
 */
public class Learn_10 {
    public static void main(String[] args) {
        /**
         *  (0,0) - (0,2)
         *  /(0,1) - (1,2)/
         *  (0,2) - (2,2)
         *
         *  (1,0) - (0,1)/
         *  (1,1) - (1,1)
         *  /(1,2) - (2,1)/
         *
         *
         */
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix2 = {
                {7, 8, 9},
                {12, 13, 14},
                {17, 18, 19}
        };
        int[][] matrix3 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
        int[][] matrix4 = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40, 41, 42},
                {43, 44, 45, 46, 47, 48, 49}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int all = matrix.length;
        int stop = all / 2;
        for (int i = 0; i < stop; i++) {
            circleChange(i, i, all, all - i, matrix);
        }
    }

    public static void circleChange(int si, int sj, int ei, int ej, int[][] matrix){
        int item = 0;
        for (int i = si; i < ej - 1; i++) {
            item = matrix[si][i];
            matrix[si][i] = matrix[ei - i - 1][sj];
            matrix[ei - i - 1][sj] = matrix[ej - 1][ei - i - 1];
            matrix[ej - 1][ei - i - 1] = matrix[i][ej - 1];
            matrix[i][ej - 1] = item;
        }
    }
}
