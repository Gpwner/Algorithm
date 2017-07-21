/**
 * @version 2017/7/21.21:33
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        new NextPermutation().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int decreasingElementIndex = getDecreasingElement(nums);
        if (decreasingElementIndex == -1) {
            reverse(nums, 0);
            return;
        }
        swap(nums, decreasingElementIndex, getLastLargeElement(nums, decreasingElementIndex));
        reverse(nums, decreasingElementIndex + 1);
    }

    //获取比第一个数组中从后向前递减的数大的数
    public int getLastLargeElement(int[] nums, int start) {
        int num = nums[start];
        int index = start + 1;
        while (index < nums.length) {
            if (nums[index] > num) {
                start++;
            }
            index++;
        }
        return start;
    }

    //从数组的 某一位置开始反转数组
    public void reverse(int[] nums, int starIndex) {
        int endIndex = nums.length - 1;
        while (starIndex < endIndex) {
            swap(nums, starIndex, endIndex);
            starIndex++;
            endIndex--;
        }
    }

    //从数组的后向前获取第一个递减的数字的下标，比如{1,4，3,2}，此时要求的 结果就是0
    public int getDecreasingElement(int[] nums) {
        int lenght = nums.length - 1;
        while (lenght >= 1) {
            if (nums[lenght] > nums[lenght - 1]) {
                return lenght - 1;
            }
            lenght--;
        }
        return -1;
    }

    //交换两个数
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
