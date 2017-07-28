/**
 * @version 2017/7/28.22:14
 */
public class BitOperation {
    public static void main(String[] args) {
        BitOperation operation = new BitOperation();
        System.out.println(operation.getOppositeNumber(0));
    }

    /*
    *
    * 对于-11和11，可以通过下面的变换方法将-11变成11

          1111 0101(二进制) –取反-> 0000 1010(二进制) –加1-> 0000 1011(二进制)

    同样可以这样的将11变成-11

          0000 1011(二进制) –取反-> 0000 0100(二进制) –加1-> 1111 0101(二进制)

    因此变换符号只需要取反后加1即可
    *
    * */
    public int getOppositeNumber(int num) {
        return ~num + 1;
    }
}