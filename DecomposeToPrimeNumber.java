package load;

import java.util.Scanner;

/*
 * ��Ȼ�����������������֣�һ������������������
 * ��һ�ֿ϶����������ı��������������ż���ݱ������֮��϶��ܱ��ֽ⣬
 * �ֽ����һ���������������Ǽ����������ĳ˻���
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
