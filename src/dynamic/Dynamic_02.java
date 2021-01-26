package dynamic;

import stack.MinStack;

/**
 * @Author xiaobai
 * @Date 2021/1/26 23:31
 * @Version 1.0
 */
public class Dynamic_02 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 排查，但是超时了
     * @param prices prices
     * @return int
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        int input = 0;
        int output = 0;
        int j = 0;
        for (int i = 0, all = prices.length - 1; i < all; i++) {
            input = prices[i];
            output = input;
            j = i + 1;
            while (j < prices.length){
                if (output < prices[j]){
                    output = prices[j];
                }
                j ++;
            }
            int result = output - input;
            if (result > max){
                max = result;
            }
        }
        return max;
    }


    /**
     * 记录历史最高点和最低点来购买
     * @param prices prices
     * @return int
     */
    public static int maxProfitChange(int[] prices){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            else if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
