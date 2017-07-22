import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个n,在从1-n的数字的 全排列中找到第k个全排列
 *
 * @version 2017/7/21.21:33
 */
public class K_th_Permutation {
    public static void main(String[] args) {
        System.out.println(new K_th_Permutation().getPermutation(4, 15));
    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder builder = new StringBuilder();
        // create an array of factorial lookup
        //求n的阶乘
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        // create a list of list to get indices
        for (int i = 1; i <= n; i++)
            list.add(i);
        // list = {1, 2, 3, 4}
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            builder.append(String.valueOf(list.get(index)));
            list.remove(index);
            k -= index * factorial[n - i];
        }
        return String.valueOf(builder);
    }
}
