import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author
 * @version 2017/7/5.19:28
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> result = new Demo().permuteUnique(nums);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0);
        return res;
    }

    private  void helper(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            //将int[]转换为List
            List<Integer> temp = IntStream.of(nums).boxed().collect(Collectors.toList());
            res.add(temp);
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            if (isDuplicate(nums, start, i))
                continue;
            swap(nums, start, i);
            helper(res, nums, start + 1);
            swap(nums, start, i);
        }
    }

    private  void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private  boolean isDuplicate(int[] nums, int i, int j) {
        //注意这里一定是小于，不能是小于等于
        while (i < j) {
            if (nums[i] == nums[j])
                return true;
            i++;
        }
        return false;
    }
}
