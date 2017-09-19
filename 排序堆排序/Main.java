package leetcode;


public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 2, 5, 1, 0, 3, 6, 8, 10};
        heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void heapSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    public static void heapInsert(int[] nums, int i) {
        //首先构造大根堆
        int parent;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (nums[parent] < nums[i]) {
                swap(nums, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(int[] chas, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            //可能左节点大
            if (chas[left] > chas[i]) {
                largest = left;
            }
            //可能右节点大
            if (right < size && chas[right] > chas[largest]) {
                largest = right;
            }
            //如果出现i节点不是最大的节点，做出调整
            if (largest != i) {
                swap(chas, largest, i);
            } else {
                break;
            }
            //继续查看最大下标处是否需要调整
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
