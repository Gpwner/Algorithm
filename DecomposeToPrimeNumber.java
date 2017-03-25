package load;

import java.util.Scanner;

/*
 * 自然数序列中奇数有两种，一种是质数（奇数），
 * 另一种肯定是质奇数的倍数。所当输入的偶数据编程奇数之后肯定能被分解，
 * 分解或是一个质奇数，或者是几个质奇数的乘积。
 * */
public class DecomposeToPrimeNumber {
	public static void main(String[] args) {
		int num = new Scanner(System.in).nextInt();
		if (num < 1) {
			return;
		}
		while (num % 2 == 0) {
			num = num / 2;
			System.out.print("2 ");
		}
		for (int i = 3; i <= num; i = i + 2) {
			while (num % i == 0) {
				num = num / i;
				System.out.print(i + " ");
			}
		}
	}

}
