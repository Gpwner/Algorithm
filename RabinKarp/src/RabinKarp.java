public class RabinKarp {
    private String  T ;//Ŀ���ַ���
    private String  P ;//Ҫƥ���
    private int d;//����
    private int q;//�����������
    private int n = 0;
    private int m = 0;//Ҫƥ����ַ����ĳ���
    private int h = 1;
    //����Ҫƥ����ı��ַ�����Сд��ĸ{a...z}

    public RabinKarp(String t, String p, int d, int q) {
        T = t;
        P = p;
        this.d = d;
        this.q = q;
        n = T.length();
        m = P.length();

        for (int i = 0; i < m-1 ; i++) {
            h *= (d );
            h = (h % q);
        }
    }

   public int match() {
       int p = 0;
       int t = 0;

       //Ԥ��������p �� t0.
       for (int i = 0; i < m; i++) {
           p = (d*p + (P.charAt(i) - 'a')) % q;
           t = (d*t + (T.charAt(i) - 'a')) % q;
       }

       for (int s = 0; s <= n - m; s++) {

           if (p == t) {
               //����������ȣ���ô������ַ��Ƚ�
               for (int i = 0; i < m; i++) {
                   if (i == m-1 && P.charAt(i) == T.charAt(s+i)) {
                       return s;
                   } else if (P.charAt(i) != T.charAt(s+i)){
                       break;
                   }
               }
           }

           if (s <= n - m) {

               t = (d*(t-(T.charAt(s) - 'a')*h) + T.charAt(s+m) - 'a') % q;

               if (t < 0) {
                   t += q;
               }
           }
       }

       return -1;
   }
   public static void main(String[] args) {
       String T = "abcabaabcabac";
       String P = "abaa";
       RabinKarp rk = new RabinKarp(T, P, 26, 29);
       int s = rk.match();

       System.out.println("Valid shift is: "+ s);
   }
}

 class ArrayAndString {

    
}