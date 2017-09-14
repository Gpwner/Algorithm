package leetcode;

import java.util.Scanner;

/**
 * 可先设 dp[i][j] 表示当前小Q唱到第 i 个音调，牛博士唱到第 j 个音调的难度和；
 * 不妨设当前 i > j ：
 * 若 i - 1 == j 则发生换人，由于不知道上一次 i 唱到哪里，状态由 min{ dp[k][j] + abs(v[i] - v[k]) }, k < j 转移来；
 * 若 i - 1 > j 则表示当前是从 i - 1 唱到 i 的，没有换人，状态由 dp[i-1][j] + abs(v[i] - v[i-1]) 累加；
 * 不妨设 dp[i][j] 表示当前演唱到第 i 个音调，上一个人演唱到第 j 个音调，则状态转移方程为
 * dp[i][j] = dp[i-1][j] + abs(v[i] - v[i-1]), j < i - 1
 * dp[i][i -1] = min{ dp[i-1][k] + abs(v[i] - v[k]) }, k < i - 1
 * 边界情况是一个人唱第一个，后面所有音调让另一个人唱
 * dp[i][0] = dp[i-1][0] + abs(v[i] - v[i-1]), i ≥ 2
 * 或者一个人唱前面所有音调，最后一个音调让另一个人唱
 * dp[i][i-1] = dp[i-1][i-2] + abs(v[i-1] - v[i-2]), i ≥ 2
 */
public class Main {
    public static final int NUMBER = 2000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] V = new long[NUMBER];
        //计算每每相邻的两个音符之间的差距cost[1]表示的是V[1]-V[0]
        long[] cost = new long[NUMBER];
        long[][] dp = new long[NUMBER][NUMBER];
        V[0] = scanner.nextLong();
        for (int i = 1; i < N; i++) {
            V[i] = scanner.nextLong();
            cost[i] = Math.abs(V[i] - V[i - 1]);
        }
        long res = Long.MAX_VALUE;
        //边界条件
        for (int i = 2; i < N; ++i) {
            // cost[i-1] = Math.abs(V[i-1] - V[i - 2]);
            dp[i][i - 1] = dp[i - 1][i - 2] + cost[i - 1];
        }
        for (int i = 2; i < N; ++i) {
            for (int j = 0; j < i - 1; ++j) {
                //换人的时候
                dp[i][j] = dp[i - 1][j] + cost[i];
                //没有换人的时候
                dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + Math.abs(V[i] - V[j]));
            }
        }
        //第一维的坐标是N-1是因为最后一个当前唱到的音调是最后一个音调了，
        for (int i = 0; i < N - 1; ++i) {
            res = Math.min(res, dp[N - 1][i]);
        }
        System.out.println(res);
    }
}