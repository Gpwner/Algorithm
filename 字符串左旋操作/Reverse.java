/**
 * @author  dasperson
 *           ersondasp
 * @version 2017/6/22.9:17
 * @project Java8Test
 */


public class Reverse {


    public static void main(String[] args) {
        String string = "dasperson";
        System.out.println(string);
        System.out.println(leftRoate(4, string));
    }

    public static String leftRoate(int n, String str) {
        if (str==null||n > str.length())
            System.exit(1);
        String s = reStr(reStr(str.substring(0, n)) +reStr(str.substring(n, str.length())));
        return s;
    }

    public static String reStr(String str) {
        char[] data = str.toCharArray();
        int low = 0;
        int high = data.length - 1;
        while (low < high) {
            data[low] = (char) (data[low] ^ data[high]);
            data[high] = (char) (data[low] ^ data[high]);
            data[low] = (char) (data[low] ^ data[high]);
            low++;
            high--;
        }
        return new String(data);
    }
}
