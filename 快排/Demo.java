/**
 * @author 快速排序
 * @version 2017/6/16 22:42
 */

public class Demo {
    public static void main(String[] args) {
        int[] arra = {9, 19, 4, 5, 21, 43, 5, 6, 7, 12, 32, 1};
        new Demo().quickSort(arra, 0, arra.length - 1);
        for (int i = 0; i < arra.length; i++) {
            System.out.print(arra[i] + " ");
        }

    }

    public void quickSort(int[] arra, int low, int high) {
        if (low <= high) {
            int pivotpos = partitionArray(arra, low, high);
            quickSort(arra, low, pivotpos - 1);
            quickSort(arra, pivotpos + 1, high);
        }
    }

    public int partitionArray(int[] arra, int low, int high) {
        int pivot = arra[low];
        int pivotpos = low;
        for (int i = low + 1; i <= high; i++) {
            if (arra[i] > pivot) {
                //如果要升序排序，将大于号修改为小于号即可(arra[i] <pivot)
                pivotpos++;
                if (i != pivotpos) {
                    arra[pivotpos] = arra[pivotpos] ^ arra[i];
                    arra[i] = arra[pivotpos] ^ arra[i];
                    arra[pivotpos] = arra[pivotpos] ^ arra[i];
                }
            }
        }
        arra[low] = arra[pivotpos];
        arra[pivotpos] = pivot;

        return pivotpos;
    }

}
