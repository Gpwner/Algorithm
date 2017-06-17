/**
 * @author 判断一个数字是不是2的幂次，比如
 * @version 2017/6/16 22:04
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(powerOfTwo(16));
    }


    public static boolean isPowerOfTwo(int n) {
//        1010=>false
//        100000=>true
        boolean flag = false;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (!flag)
                    flag = true;
                else
                    return false;
            }
            //每一次右移一位
            n = n >> 1;
        }
        return flag;
    }

    public static boolean powerOfTwo(int n) {
        //8=》1000
        //7=》0111
//        8^7=0
        return ((n & (n - 1)) == 0 && n > 0);
    }
}
