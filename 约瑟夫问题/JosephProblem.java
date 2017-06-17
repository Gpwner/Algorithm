import java.util.LinkedList;
import java.util.List;

public class JosephProblem {
    public static void main(String[] args) {
        System.out.println(LastRemainIndex(41, 2));
        System.out.println(LastRemaining(41, 2));


        List<Integer> r;
        System.out.println(r = josephus(41, 2, 1));// show entire sequence
        System.out.printf("Person %d is last\n", r.get(r.size() - 1));  // who's last?
    }

    //使用递归算法
    public static int LastRemainIndex(int n, int m) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (1 == n) {
            return 0;
        }
        return (LastRemainIndex(n - 1, m) + m) % n;
    }

    //使用非递归算法
    public static int LastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }


    // remove N elements in equal steps starting at specific point
    public static List<Integer> josephus(int N, int step, int start) {
        if (N < 1 || step < 1 || start < 1) return null;

        List<Integer> p = new LinkedList<>();
        //创建数据集合
        for (int i = 0; i < N; i++)
            p.add(i + 1);
        //这个数据集记录最后存活的
        List<Integer> r = new LinkedList<>();
        int i = (start - 2) % N;
        for (int j = N; j > 0; j--) {
            i = (i + step) % N--;
            r.add(p.remove(i--));
        }
        return r;
    }
}
