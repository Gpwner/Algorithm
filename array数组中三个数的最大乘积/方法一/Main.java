package leetcode;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        Main main = new Main();
        System.out.println(main.maximumProduct(nums));
    }

    public int maximumProduct(int[] nums) {
        //声明为最小值，max1>max2>max3
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        //声明为最大值，因为可能两个负数相乘再与一个整数相乘的结果大于三个整数相乘的结果
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            //此处不能用else-if连接，不然会出错，min1<min2
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}