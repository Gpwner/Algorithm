package leetcode;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {0, 0, 2, 3};
        Main main = new Main();
        System.out.println(main.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j])
                nums[++j] = nums[i];
        }
        return j + 1;
    }
}