/**
 * @author 快速排序
 * @version 2017/6/16 22:04
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {9, 12, 2, 3, 1, 0};
        quickSort(0, arr.length - 1, arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int left, int right, int[] array) {
        if (left < right) {
            int position = partition(left, right, array);
            quickSort(left, position - 1, array);
            quickSort(position + 1, right, array);
        }
    }

    /**
     * 可以理解成先将pivot拿出来，然后再对剩下的元素进行排序，
     * 排序的标准是，小于pivot的元素放在左边，大于pivot的放在右边
     */
    public static int partition(int low, int high, int[] arra) {
        int pivot = arra[low];
        int position = low;
        for (int i = low + 1; i <= high; i++) {
            if (arra[i] < pivot) {
                //position表示的是比pivot小的元素应该在的位置
                position++;
                if (position != i) {
                    arra[position] = arra[position] ^ arra[i];
                    arra[i] = arra[position] ^ arra[i];
                    arra[position] = arra[position] ^ arra[i];
                }
            }
        }
        arra[low] = arra[position];
        arra[position] = pivot;
        return position;
    }
}
