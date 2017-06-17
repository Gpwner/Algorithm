import java.util.Arrays;

/**
 * @author 从扑克牌中随机抽五张牌，判断是不是一个顺子，即这五张牌是不是连续的，2-10为数字本身，A为1，J为11，Q为12，K为13，大王和小王可以代替任何数字，使用0表示
 * @version 2017/6/16 22:04
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4, 5};
        System.out.println(isConntinue(arr));
    }

    public static boolean isConntinue(int[] arra) {
        if (arra.length == 0)
            return false;
        //快排
        Arrays.sort(arra);
        //大小王的个数
        int zeros = 0;
        int gap = 0;
        for (int i = 0; i < arra.length && arra[i] == 0; i++) {
            zeros++;
        }
        // 因为已经排下序了，所以非零的数字的下标从zeros的个数为下标开始
        int small = zeros;
        int big = small + 1;
        while (big < arra.length) {
            //对子
            if (arra[small] == arra[big]) {
                return false;
            }
            gap += arra[big] - arra[small] - 1;
            small = big;
            big++;
        }
        return gap > zeros ? false : true;
    }
}
