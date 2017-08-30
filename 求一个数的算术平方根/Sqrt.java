/**
 * @version 2017/8/30.20:55
 */
public class Sqrt {
    //    private int sqrt(int x) {
//        if (x == 0)
//            return 0;
//        double last = 0;
//        double res = 1;
//        while (res != last) {
//            last = res;
//            res = (res + x / res) / 2;
//        }
//        return (int) res;
//    }
    public int mySqrt(int x) {
        if (x <= 0)
            return -999999999;
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(-4));
    }
}
