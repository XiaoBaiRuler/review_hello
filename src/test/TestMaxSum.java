package test;

/**
 * @Author xiaobai
 * @Date 2021/1/2 8:57
 * @Version 1.0
 */
public class TestMaxSum {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, -2, -4, -5, -6};
        System.out.println(maxSubSum3(a));
    }

    public static int maxSubSum3(int[] a){
        return maxSumRec(a, 0, a.length - 1);
    }

    private static int maxSumRec(int[] a, int left, int right){
        if (left == right){
            if (a[left] > 0){
                return a[left];
            }
            else{
                return 0;
            }
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >=left ; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right ; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum,maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        int max = Math.max(maxLeftSum, maxRightSum);
        if (max == maxLeftSum){
            return Math.max(maxLeftSum, i);
        }
        else{
            return Math.max(maxRightSum, i);
        }
    }
}
