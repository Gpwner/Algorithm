package leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {7, 1, -5, 3, 6, 4};
        Main main = new Main();
    }

    public int maxProduct(int[] nums) {
        if (nums.length < 1)
            return 0;
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * preMax));
            result = Math.max(max, result);
        }
        return result;
    }
}