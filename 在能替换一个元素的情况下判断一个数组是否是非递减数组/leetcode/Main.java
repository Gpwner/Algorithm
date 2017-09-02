package leetcode;

/**
 */
class Main {
    public static void main(String[] args) {
        int[] nums={4,3,2};
        Main main = new Main();
        System.out.println(main.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; ++i) {
            if (nums[i] < nums[i - 1]) {
                //出现递减情况的时候什么情况计数器要加一？
                //第一种情况i表示数组中的第二个元素的时候,i=1的时候;
                //第二种情况i表示最后数组中的最后一个元素的时候,i=nums.length-1;
                //第三种情况i表示的元素比第i-2个元素大的时候nums[i] >= nums[i - 2];
                //第四种情况i表示的元素比第i+1个元素小的时候nums[i - 1] <= nums[i + 1]；
                //如果都不满足这个条件的话，就不能再这个题目给的条件下构成非递减数组
                if (i == 1 || i + 1 == nums.length || nums[i] >= nums[i - 2] || nums[i - 1] <= nums[i + 1]) {
                    ++count;
                } else {
                    return false;
                }
            }
        }
        return count <= 1;
    }
}