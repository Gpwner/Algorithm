package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        Main main = new Main();
        System.out.println(main.searchInsert(nums, 2));
    }


    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //注意只能返回low,返回high是错的（如果想返回high的话就返回high+1）
        return low;
    }


    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int slow = 0;
        int fast = 1;
        int res = 0;
        while (slow < fast && fast < nums.length) {
            if (nums[fast] - nums[slow] == k) {
                res++;
                fast++;
                slow++;
                while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                    fast++;
                }
                while (slow < fast && nums[slow] == nums[slow - 1]) {
                    slow++;
                }
            } else if (nums[fast] - nums[slow] > k) {
                slow++;
            } else {
                fast++;
            }
            if (slow == fast) {
                fast++;
            }
        }
        return res;
    }
}