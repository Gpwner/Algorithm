import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int array[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = fourSum(array, 0);
        for (Iterator<List<Integer>> iterator = list.iterator(); iterator.hasNext(); ) {
            List<Integer> list2 = iterator.next();
            for (Iterator<Integer> iterator2 = list2.iterator(); iterator2.hasNext(); ) {
                Integer integer = iterator2.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (num.length < 4)
            return ans;
        // 先排序
        Arrays.sort(num);
        // 预留接下来的三个数的位置 i < num.length - 3，否则可能会越界访问数组
        for (int i = 0; i < num.length - 3; i++) {
            // 元素相同的跳过本次循环
            if (i > 0 && num[i] == num[i - 1])
                continue;
            // 预留接下来的两个位置j < num.length - 2，防止数组被越界访问
            // 接下来就是效仿三个数求和问题
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int low = j + 1, high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while (low < high && num[low] == num[low + 1])
                            low++;
                        while (low < high && num[high] == num[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (sum < target)
                        low++;
                    else
                        high--;
                }
            }
        }
        return ans;
    }
}