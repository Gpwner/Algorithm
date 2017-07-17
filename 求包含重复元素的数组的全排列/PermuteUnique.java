import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author
 * @version 2017/7/5.19:28
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> result = new PermuteUnique().permuteUnique(nums);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i : nums) {
            if (frequencies.containsKey(i)) {
                int val = frequencies.get(i);
                val++;
                frequencies.put(i, val);
            } else {
                frequencies.put(i, 1);
            }
        }
        //元素
        int[] items = new int[frequencies.size()];
        //元素对应的个数
        int[] count = new int[frequencies.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            items[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<List<Integer>> result = new ArrayList<>();
        //排列组合得到的数组，长度等于原来的数组
        int[] permutation = new int[nums.length];
        backtrack(items, count, permutation, result, 0);
        return result;
    }


    //level 表示排列组合得到的数组的第几个位置，level=0表示第一个元素，level=1表示第二个元素，level=2表示第三个元素
    private void backtrack(int[] items, int[] count, int[] permutation, List<List<Integer>> result, int level) {
        if (level == permutation.length) {
            List<Integer> validPermutation = IntStream.of(permutation).boxed().collect(Collectors.toList());
            result.add(validPermutation);
        }
        for (int j = 0; j < items.length; j++) {
            if (count[j] == 0)
                continue;
            permutation[level] = items[j];
            count[j]--;
            backtrack(items, count, permutation, result, level + 1);
            count[j]++;
        }
    }
}
