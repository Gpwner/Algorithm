package leetcode;

import java.util.Arrays;

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
        Arrays.sort(nums);
        //One of the Three Numbers is the maximum value in the array.

        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int b = nums[0] * nums[1] * nums[nums.length - 1];
        return a > b ? a : b;
    }
}