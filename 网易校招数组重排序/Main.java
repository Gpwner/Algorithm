package leetcode;

import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * <p>
 * <p>
 * 解题思路：从数组中输出是2的倍数、4的倍数、奇数的个数
 * 分为两种情况来判断：
 * 1.2的倍数首先放在左边排列，紧接着放着一个4的倍数然后又是奇数，交替变化 ，要求是(secondCounter != 0 && fourCounter >= oodCounter)
 * 2.2的倍数个数为0，然后又可以拿一个奇数来替代原来2的倍数的位置，然后当(secondCounter == 0 && (fourCounter >= oodCounter + 1))
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int N = input.nextInt();
            int[] arra = new int[N];
            int fourCounter = 0;
            int secondCounter = 0;
            int oodCounter = 0;
            for (int j = 0; j < arra.length; j++) {
                arra[j] = input.nextInt();
                if (arra[j] % 4 == 0) {
                    fourCounter++;
                } else if (arra[j] % 2 == 0) {
                    secondCounter++;
                } else {
                    oodCounter++;
                }
            }
            if ((secondCounter != 0 && fourCounter >= oodCounter) || (secondCounter == 0 && (fourCounter >= oodCounter + 1))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}