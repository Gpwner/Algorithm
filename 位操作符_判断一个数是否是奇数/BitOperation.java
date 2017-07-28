/**
 * @author 东北大学软件工程 许正创
 * @version 2017/7/28.22:14
 */
public class BitOperation {
    public static void main(String[] args) {
        System.out.println(new BitOperation().OddOrNot(3));
    }

    //判断一个数是奇数还是偶数
    public boolean OddOrNot(int num) {
        return (num & 1) == 0 ? false : true;
    }
}
