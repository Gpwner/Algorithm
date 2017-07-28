/**
 * @version 2017/7/28.22:14
 */
public class BitOperation {
    public static void main(String[] args) {
        BitOperation operation = new BitOperation();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        operation.swap(nums, 0, 1);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }

    public void swap(int[] num, int i, int j) {
        if (i != j) {
            num[i] = num[i] ^ num[j];
            num[j] = num[i] ^ num[j];
            num[i] = num[i] ^ num[j];
        }
    }
}
