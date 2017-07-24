/**
 * 三路划分的快速排序
 */

public class QuickSort_Three_way_division {
    public static void main(String[] args) {
        int[] arra = {25, 15, 30, 10, 50, 3, 5, 30};
        QuickSort_Three_way_division t = new QuickSort_Three_way_division();
        t.quickSort(arra, 0, arra.length - 1);
        for (int i = 0; i < arra.length; i++) {
            System.out.print(arra[i] + " ");
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right <= left)
            return;
        int leftLabelPtr, rightLabelPtr, leftScanPtr, rightScanPtr;
        int pivot;// 锚点
        leftScanPtr = leftLabelPtr = left;
        rightScanPtr = rightLabelPtr = right - 1;
        pivot = nums[right];
        while (true) {
            while (leftScanPtr < right && nums[leftScanPtr] <= pivot) {
                if (nums[leftScanPtr] == pivot) {
                    swap(nums, leftScanPtr, leftLabelPtr);
                    leftLabelPtr++;
                }
                leftScanPtr++;
            }
            while (left <= rightScanPtr && nums[rightScanPtr] >= pivot) {
                if (nums[rightScanPtr] == pivot) {
                    swap(nums, rightScanPtr, rightLabelPtr);
                    rightLabelPtr--;
                }
                rightScanPtr--;
            }
            if (leftScanPtr >= rightScanPtr)
                break;
        /*
        * 将左边大于pivot的元素与右边小于pivot元素进行交换
        */
            swap(nums, leftScanPtr, rightScanPtr);
            leftScanPtr++;
            rightScanPtr--;
        }
    /*
    * 因为工作指针i指向的是当前需要处理元素的下一个元素
    * 故而需要退回到当前元素的实际位置，然后将等于pivot元素交换到序列中间
    */
        leftScanPtr--;
        leftLabelPtr--;
        while (leftLabelPtr >= left) {
            swap(nums, leftScanPtr, leftLabelPtr);
            leftScanPtr--;
            leftLabelPtr--;
        }
    /*
    * 因为工作指针j指向的是当前需要处理元素的上一个元素
    * 故而需要退回到当前元素的实际位置，然后将等于pivot元素交换到序列中间
    */
        rightScanPtr++;
        rightLabelPtr++;
        while (rightLabelPtr <= right) {
            swap(nums, rightScanPtr, rightLabelPtr);
            rightScanPtr++;
            rightLabelPtr++;
        }

    /*
    * 递归遍历左右子序列
    */
        quickSort(nums, left, leftScanPtr);
        quickSort(nums, rightScanPtr, right);
    }
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
