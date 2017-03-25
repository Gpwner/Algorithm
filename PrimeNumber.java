package load;

/*
 * 求小于一百的质数，2017年3月25日22:07:14
 * */
public class PrimeNumber {
	public static void main(String[] args) {
		for (int i = 2; i < 100; i++) {
			boolean flag = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
				}
			}
			if (!flag) {
				System.out.print(i + " ");
			}
		}
	}

}
