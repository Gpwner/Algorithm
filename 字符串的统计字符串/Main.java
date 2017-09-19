package leetcode;


public class Main {
    public static void main(String[] args) {
        String s = "aaabbccdfra";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(s.charAt(0)));
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append("_" + count + "_" + String.valueOf(s.charAt(i)));
                count = 1;
            }
        }
        stringBuilder.append("_" + count);
        System.out.println(stringBuilder);
    }
}
