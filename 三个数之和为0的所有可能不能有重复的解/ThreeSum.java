import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//求一个n维数组中三个数之和为0的所有可能，不能有重复的解
public class ThreeSum {
    public static void main(String[] args) {
        int array[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(array);
        for (Iterator<List<Integer>> iterator = list.iterator(); iterator.hasNext(); ) {
            List<Integer> list2 = iterator.next();
            for (Iterator<Integer> iterator2 = list2.iterator(); iterator2.hasNext(); ) {
                Integer integer = iterator2.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        // length - 2防止数组越界，因为lo = i + 1
        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                // 可能与num[i]相加为0的解不止有一组解
                while (lo < hi) {
                    // 满足条件的时候，将结果装入ArrayList
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        // 跳过相同的较小值
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        // 跳过相同的最大值
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        // 最高位和最低位都递增1
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}