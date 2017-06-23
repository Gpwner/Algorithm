import java.util.HashMap;

/**
 * @author O(n)求两个数的和
 * @version 2017/6/22.9:17
 * @project Java8Test
 */


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = target - nums[i];
                result[1] = nums[i];
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arra = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new TwoSum().twoSum(arra, 15);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
