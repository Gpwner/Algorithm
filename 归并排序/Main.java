import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 6, 7, 8, 11, 23, 6, 78, 83, 2, 4, 68, 99, 123};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        int[] temp = new int[nums.length];
        System.out.println("");
        main.mergeSort(nums, 0, nums.length - 1, temp);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            mergeArray(nums, left, mid, right, temp);
        }
    }


    void mergeArray(int nums[], int left, int mid, int right, int temp[]) {
        int startL = left, startR = mid + 1;
        int index = 0;

        while (startL <= mid && startR <= right) {
            if (nums[startL] <= nums[startR])
                temp[index++] = nums[startL++];
            else
                temp[index++] = nums[startR++];
        }

        while (startL <= mid)
            temp[index++] = nums[startL++];

        while (startR <= right)
            temp[index++] = nums[startR++];


        for (startL = 0; startL < index; startL++)
            nums[left + startL] = temp[startL];
    }
}