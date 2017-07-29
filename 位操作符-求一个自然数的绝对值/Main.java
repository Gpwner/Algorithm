public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.UdABS_1(-5));
    }

    /**
     * @param num 需要判断的数
     * @return 数字的绝对值
     */
    public int UdABS(int num) {
        //这种就是先右移31位，然后判断符号位是0还是1，如果是0返回的是本身，如果是1的话先取反再加上1即可得到相反数
        return num >> 31 == 0 ? num : (~num + 1);
    }

    /**
     * @param num 需要判断的数
     * @return 数字的绝对值
     */
    public int UdABS_1(int num) {
        //右移31位得到符号位
        int signed = num >> 31;
        //将原来的数字与符号位做异或运算。分两种情况：
        //1.符号位是-1，在计算机中的表示就是：11111111111111111111111111111111，任何数字与这种形式的数字做异或运算就相当于是做取反操作；
        //2.符号位是0，在计算机中的表示就是： 00000000000000000000000000000000，任何数字与这个数字做异或运算就是得到了其本身
        //最后在加上1，这里有一个点很重要，减法的优先级高于异或运算的优先级
        return (num ^ signed) - signed;
    }
}
