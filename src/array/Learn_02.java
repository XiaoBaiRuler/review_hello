package array;

import java.util.Stack;

/**
 * @Author xiaobai
 * @Date 2020/12/16 15:51
 * @Version 1.0
 */
public class Learn_02 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(getBestChance(prices));
    }

    /**
     * 买股票的最佳时机
     *
     * @param prices int[]
     * @return 最佳长度
     */
    public static int getBestChance(int [] prices){
        int total = 0;
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();
        int input = 0;
        int output = 0;
        int j = 0;
        while(j < prices.length){
            while (j < prices.length){
                if (in.isEmpty()){
                    in.push(prices[j]);
                    j++;
                }
                else{
                    if (prices[j] <= in.peek()){
                        in.push(prices[j]);
                        j ++;
                    }
                    else{
                        out.push(prices[j]);
                        j ++;
                        break;
                    }
                }
            }
            //买入出现中断信号
            input = in.peek();
            in.clear();
            while (j < prices.length){
                if (prices[j] > out.peek()){
                    out.push(prices[j]);
                    j ++;
                }
                else{
                    j --;
                    break;
                }
            }
            //卖出出现中断信号
            if (!out.isEmpty()){
                output = out.peek();
                out.clear();
                //结算
                total += (output - input);
            }
            j ++;
        }
        return total;
    }
}
