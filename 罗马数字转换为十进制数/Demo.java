import java.util.HashMap;

/**
 * @author 将罗马数字转换为整数，罗马数字中如果两个连续的字符代表的数字中，第一个比第二个字符代表的数字小的话，就用第二个所代表的数字减去第一个所代表的数字
 * @version 2017/6/16 22:42
 */

public class Demo {
    //第一种方法
    public int aromanToInt(String s) {
        char[] cs = s.toCharArray();
        int i = 0, val = 0;
        while (i < cs.length) {
            // System.out.print(cs[i]);
            switch (cs[i++]) {
                case 'M':
                    val += 1000;
                    break;
                case 'D':
                    val += 500;
                    break;
                case 'C':
                    if (i < cs.length && cs[i] == 'D') {
                        val += 400;
                        i++;
                    } else if (i < cs.length && cs[i] == 'M') {
                        val += 900;
                        i++;
                    } else val += 100;
                    break;
                case 'L':
                    val += 50;
                    break;
                case 'X':
                    if (i < cs.length && cs[i] == 'L') {
                        val += 40;
                        i++;
                    } else if (i < cs.length && cs[i] == 'C') {
                        val += 90;
                        i++;
                    } else val += 10;
                    break;
                case 'V':
                    val += 5;
                    break;
                case 'I':
                    if (i < cs.length && cs[i] == 'V') {
                        val += 4;
                        i++;
                    } else if (i < cs.length && cs[i] == 'X') {
                        val += 9;
                        i++;
                    } else val += 1;
                    break;
            }
            // System.out.println(" "+val);
        }
        return val;
    }

    //第二种方法
    public int romanToInt(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('M', 1000);
        hashMap.put('D', 500);
        hashMap.put('C', 100);
        hashMap.put('L', 50);
        hashMap.put('X', 10);
        hashMap.put('V', 5);
        hashMap.put('I', 1);

        char[] chs = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            if (hashMap.get(chs[i]) < hashMap.get(chs[i + 1]))
                result -= hashMap.get(chs[i]);
            else
                result += hashMap.get(chs[i]);
        }
        result += hashMap.get(chs[chs.length - 1]);
        return result;
    }

    public static void main(String[] args) {
        String str = "XCVIII";
        System.out.println(new Demo().romanToInt(str));
    }
}
