import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 有一个一维数组，只有一个数字只出现了一次，其余的数字都出现了两次，求出这个数字
 * @version 2017/6/22.9:17
 * @project Java8Test
 */


public class FindDiffInArray {
    public static void main(String[] args) {
//        int[] arra = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] arra = {1, 2, 3, 4, 1, 2, 3, 4,  7, 8};
        FindDiffInArray findDiffInArray = new FindDiffInArray();
        int[] result = findDiffInArray.getSolution(arra);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] getSolution(int[] arra) {
        if (arra.length < 4)
            System.exit(1);
        int[] result = new int[2];
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int index = getOneIndex(Xor(arra));
        if (index == 0)
            System.exit(1);
        for (int i = 0; i < arra.length; i++) {
            if (nPosIsOne(arra[i], index)) {
                arrayList1.add(arra[i]);
            } else {
                arrayList2.add(arra[i]);
            }
        }

        result[0] = Xor(Arrays.stream(arrayList1.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray());
        result[1] = Xor(Arrays.stream(arrayList2.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray());
        return result;
    }

    //获取数组中单独出现的那两个数字的异或结果
    public int getOneIndex(int num) {
        int index = 0;
        while (true && num != 0) {
            if (1 == (num >>> 1 & 1)) {
                index++;
                break;
            }
        }
        return index != 0 ? index + 1 : 0;
    }


    //将数组中的所有元素做异或
    public int Xor(int[] num) {
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            result ^= num[i];
        }
        return result;
    }

    //判断一个数字的第n位是不是1，是1返回TRUE，否则返回false
    public boolean nPosIsOne(int num, int pos) {
        return (num >>> (pos - 1) & 1) == 1 ? true : false;
    }
}
