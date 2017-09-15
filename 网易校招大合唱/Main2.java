package leetcode;

import java.util.Scanner;
import java.lang.Math;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1) {
                    if (i == 0) {
                        dp[i][j] = 0;
                    } else {
                        int result = Integer.MAX_VALUE;
                        for (int z = 0; z < i; z++) {
                            int current_result = dp[z][i] + Math.abs(data[j] - data[z]);
                            result = current_result < result ? current_result : result;
                        }
                        //让一个人唱
                        int result_all_A = 0;
                        for (int z = 1; z < j; z++) {
                            result_all_A = result_all_A + Math.abs(data[z] - data[z - 1]);
                        }
                        dp[i][j] = (result_all_A < result) ? result_all_A : result;
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] + Math.abs(data[j] - data[j - 1]);
                }
            }
        }
        int final_result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            final_result = dp[i][n - 1] < final_result ? dp[i][n - 1] : final_result;
        }
        System.out.println(final_result);
    }
}