import java.util.ArrayList;
import java.util.List;


/**
 * 这种算法的思路，可以这么理解，1,2,3，三个数的组合可以由1,2、1,3、2,3组成
 *
 * @version 2017/7/26.20:37
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n)
            return ans;
        /*因为数组的排序都是从1开始计数的，而不是从0开始计数*/
        combineSub(ans, 1, n, new ArrayList<>(), k);
        return ans;
    }

    /**
     * @param ans   最终的结果
     * @param begin 开始取的自然数
     * @param n     从1-N个自然数
     * @param tmp   用来存储一个结果
     * @param k     当前要取的K个数
     */
    public void combineSub(List<List<Integer>> ans, int begin, int n, List<Integer> tmp, int k) {
        if (k == 0) {
            //将一个排列结果添加到最终的结果
            ans.add(new ArrayList<>(tmp));
            return;
        }
        /*之所以让i的上界为n-k是因为，n个数取k个进行排列，
        所有排列中开头最大的数字是n-k+1,例如加入有三个数，
        1-3，则所有排列中开头最大的排列肯定是3-2+1=2的排列*/
        for (int i = begin; i <= n - k + 1; i++) {
            tmp.add(i);
            //如果排列中的第一个数字是1，则第二个肯定大于等于2，可能是2也可能是3
            combineSub(ans, i + 1, n, tmp, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combine().combine(3, 2);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }
    }
}
