
public class KMPMatcher {
	private String P;
	int[] Pi = null;
    public KMPMatcher(String p) {
    	this.P = p;
    	init();
    }
    
    private void init() {
    	Pi = new int[P.length() + 1];
    	for (int i = 0; i < Pi.length; i++) {
    		Pi[i] = -1;
    	}
    	
    	Pi[1] = 0;
    }
    
    public int[] computePi() {
    	try{
    		for (int i = P.length(); i > 0; i--) {
            	Pi[i] = getLongestSuffix(i);
            }
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
        
        
        return Pi;
    }
    
    public int match(String T) {
    	int n = T.length();
    	int m = P.length();
    	int q = 0;
    	
    	for (int i = 0; i < T.length(); i++) {
    		while (q > 0 && P.charAt(q) != T.charAt(i)) {
    			q = Pi[q]; //鑾峰彇鏈�闀垮悗缂�,骞跺垽鏂渶闀垮悗缂�鐨勪笅涓�涓瓧绗︽槸鍚﹁兘璺熷綋鍓嶆瘮瀵逛綅缃殑涓嬩竴涓瓧绗﹀尮閰�
    		}
    		
    		if (P.charAt(q) == T.charAt(i)) {
    			q = q + 1;
    		}
    		
    		if (q == m) {
    			return i - m + 1;
    		}
    	}
    	
    	return -1;
    }
    
    private int getLongestSuffix(int s) throws Exception {
    	if (s <= 0 || s > Pi.length) {
    		throw new Exception("Illegal index");
    	}
    	
    	if (Pi[s] != -1) {
    		return Pi[s];
    	}
    	
    	Pi[s] = 0;
    	int k = getLongestSuffix(s-1);
    	do {
    		if (P.charAt(k) == P.charAt(s - 1)) {
    			Pi[s] = k + 1;
    			return Pi[s];
    		}
    		if (k > 0) {
    			k = getLongestSuffix(k);	
    		}
    		
    	} while (k > 0);
    	
    	
    	return Pi[s];
    }
    public static void main(String[] args) {
		KMPMatcher matcher=new KMPMatcher("ababaca");
		matcher.computePi();
		System.out.println("有效偏移是："+matcher.match("abababacab"));
	}
}
