import java.util.LinkedList;
import java.util.List;

/**
 * @version 2017/7/29 14:55
 */
public class PrimeNumber_2 {
    public static void main(String[] args) {
        PrimeNumber_2 prime = new PrimeNumber_2();
        List<Integer> result = prime.getPrimeNumbers(100);
        for (Integer integer : result) {
            System.out.print(integer + "  ");
        }
    }

    //思路在：http://blog.csdn.net/morewindows/article/details/7347459
    public List<Integer> getPrimeNumbers(int num) {
        //初始值为FALSE
        boolean[] flag = new boolean[num];
        List<Integer> result = new LinkedList<>();
        int index = 0;
        for (int i = 2; i < num; i++) {
            if (!flag[i]) {
                result.add(i);
                index++;
            }
            for (int j = 0; (j < index) && (i * result.get(j) < num); j++) {
                flag[i * result.get(j)] = true;
                if (i % result.get(j) == 0)
                    break;
            }
        }
        return result;
    }
}
