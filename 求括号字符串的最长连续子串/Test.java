package leetcode;

/**
 * @author 东北大学软件工程 许正创
 * @version 2017/9/19.22:14
 */
public class Test {
//    public int maxLength(String str) {
//        if (null == str || str.equals("")) {
//            return 0;
//        }
//        char[] chas = str.toCharArray();
//        int[] dp = new int[chas.length];
//        int pre = 0;
//        int res = 0;
//        for (int i = 1; i < chas.length; i++) {
//            if (chas[i] == ')') {
//                pre = i - dp[i - 1] - 1;
//                if (pre > 0 && chas[pre] == '(') {
//                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        String str2 = "(())(()(())";
        System.out.println(str2.length());
        System.out.println(maxLength(str2));
    }
    public static int maxLength(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}