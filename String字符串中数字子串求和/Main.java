package leetcode;

public class Main {
    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            //不是数字
            if (!Character.isDigit(charArr[i])) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ?cur: -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        String test = "-AK-100ABC500----D-T--100F200G!!100H---300";
        System.out.println(numSum(test));
    }

}
