package leetcode;

/**
 * 删除一个数组中的等于0的元素，并将删除之后数组长度以外的元素重置为0
 * 非0元素的相对位置保持不变
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Main main = new Main();
        main.moveZeroes(nums);
    }


    public void moveZeroes(int[] nums) {
        //left指针永远指向当前为0的元素
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            //为0的和非0的交换
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}