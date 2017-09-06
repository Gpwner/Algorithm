package leetcode;

import java.util.*;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Main main = new Main();
        main.findDisappearedNumbers(nums);
    }

    //将出现过的元素的对应的位置置为负数，比如如果出现2的话（前提是nums[2-1]>0,否则什么都不做），则nums[2-1]=-nums[2-1]
    //最后检查元素的大于0的位置就是缺少的元素
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int j = 1; j <= nums.length; j++) {
            if (nums[j - 1] > 0) {
                result.add(j);
            }
        }
        return result;
    }
}