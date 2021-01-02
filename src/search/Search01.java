package search;

/**
 * @Author xiaobai
 * @Date 2021/1/2 10:12
 * @Version 1.0
 */
public class Search01 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(a, 4));
        System.out.println(exp(2, 3));
        System.out.println(probRelPrim(100));
    }

    /**
     * 折半查找算法
     * 时间复杂度:O(logN)
     * 空间复杂度:O(N)
     * @param a int[]
     * @param x x
     * @return index int
     */
    public static int binarySearch(int[] a, int x){
        int high = a.length - 1;
        int low = 0;
        while (low <= high){
            int stop = (low + high) / 2;
            if (a[stop] < x){
                low = stop + 1;
            }
            else if(a[stop] > x){
                high = stop - 1;
            }
            else{
                return stop;
            }
        }
        return -1;
    }

    /**
     * 欧几里得算法：求最大公因数
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     * @param m 最大数
     * @param n 最小数
     * @return 最大公因数
     */
    public static long gcd(long m, long n){
        if (m < n){
            return gcd(n, m);
        }
        while (n != 0){
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     * 幂运算
     * 时间复杂度: O(log(N))
     * 空间复杂度: O(1)
     * @param x x
     * @param y y
     * @return double
     */
    public static double exp(double x, double y){
        if (x == 0){
            return -1;
        }
        if (y == 0){
            return 1;
        }
        double a;
        double e;
        if (y % 2 != 0){
             a = (y - 1) / 2;
             e = exp(x, a);
            return e * e * x;
        }
        else{
            a = y / 2;
            e = exp(x, a);
            return e * e;
        }
    }

    /**
     * 随机选取两个小于或等于n的互异正整数为互素的概率
     * @param n number
     * @return probability
     */
    public static double probRelPrim(int n){
        int result = 0, total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                total ++;
                if (gcd(i, j) == 1 ){
                    result ++;
                }
            }
        }
        return (double) result / total;
    }

}
