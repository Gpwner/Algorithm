/**
 * @author
 * @version 2017/6/22.9:17
 * @project Java8Test
 */


public class ReverseS {


    public static void main(String[] args) {
        String string = "I am a good person";
        System.out.println(string);
        String str = reStr(string);

        String[] data = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(reStr(data[i]) + " ");
        }
        System.out.println(stringBuilder);

    }

    public static String reStr(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
