import java.util.LinkedList;
import java.util.List;

/**
 * @version 2017/7/29 14:55
 */
public class PrimeNumber_1 {
    public static void main(String[] args) {
        PrimeNumber_1 prime = new PrimeNumber_1();
        List<Integer> result = prime.getPrimeNumbers(100);
        for (Integer integer : result) {
            System.out.print(integer + "  ");
        }
    }

    /**
     * 对于每一个数，他的倍数肯定不是质数
     * 但是这样做的话虽然能够解决问题，但是会做了一些重复的工作，比如说flag[10]会被重复访问，（i=2或者i=5的时候）
     *
     * @param num
     * @return
     */
    public List<Integer> getPrimeNumbers(int num) {
        //初始值为FALSE
        boolean[] flag = new boolean[num];
        List<Integer> result = new LinkedList<>();
        for (int i = 2; i < num; i++) {
            if (!flag[i]) {
                result.add(i);
                for (int j = i; j < num; j += i) {
                    flag[j] = true;
                }
            }
        }
        return result;
    }
}
