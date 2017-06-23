import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.HashMap;

/**
 * @author 将十进制数转换罗马数字
 * @version 2017/6/16 22:42
 */

public class Demo {
    public static void main(String[] args) {
        System.out.println(new Demo().intToRoma(98));
    }

    public String intToRoma(int num) {
        String[] romanPieces = {
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",//1
                "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",//10
                "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",//100
                "", "M", "MM", "MMM", "MMMM"};//1000
        return romanPieces[num / 1000 + 30] + romanPieces[(num / 100) % 10 + 20]
                + romanPieces[(num / 10) % 10 + 10] + romanPieces[num % 10];
    }
}
