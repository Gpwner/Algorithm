package leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 可以多次买卖股票，但是只能先卖再买
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {1, 6, 2, 8, 5, 9, 10};
        Main main = new Main();
        System.out.println("main = " + main.maxProfit(nums));
    }

    public int maxProfit(int[] nums) {
        int maxProfit = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                maxProfit += nums[i + 1] - nums[i];
            }
        }
        return maxProfit;
    }

    public int[] plusOne(int[] digits) {
        if (digits.length < 1)
            return digits;
        int index = digits.length - 1;
        if ((digits[index] + 1) / 10 >= 1) {
            digits[index - 1] += (digits[index] + 1) / 10;
            digits[index] = (digits[index] + 1) % 10;
        } else {
            digits[index] += 1;
        }
        return digits;
    }
}