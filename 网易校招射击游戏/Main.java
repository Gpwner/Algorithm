package leetcode;

/**
 * 小易正在玩一款新出的射击游戏,这个射击游戏在一个二维平面进行,小易在坐标原点(0,0),平面上有n只怪物,每个怪物有所在的坐标(x[i], y[i])。小易进行一次射击会把x轴和y轴上(包含坐标原点)的怪物一次性消灭。
 * 小易是这个游戏的VIP玩家,他拥有两项特权操作:
 * 1、让平面内的所有怪物同时向任意同一方向移动任意同一距离
 * 2、让平面内的所有怪物同时对于小易(0,0)旋转任意同一角度
 * 小易要进行一次射击。小易在进行射击前,可以使用这两项特权操作任意次。
 * 小易想知道在他射击的时候最多可以同时消灭多少只怪物,请你帮帮小易。
 * <p>
 * <p>
 * 所有点对于坐标原点(0,0)顺时针或者逆时针旋转45°,可以让所有点都在坐标轴上,所以5个怪物都可以消灭。
 * <p>
 * 输入描述:
 * <p>
 * 输入包括三行。
 * 第一行中有一个正整数n(1 ≤ n ≤ 50),表示平面内的怪物数量。
 * 第二行包括n个整数x[i](-1,000,000 ≤ x[i] ≤ 1,000,000),表示每只怪物所在坐标的横坐标,以空格分割。
 * 第二行包括n个整数y[i](-1,000,000 ≤ y[i] ≤ 1,000,000),表示每只怪物所在坐标的纵坐标,以空格分割。
 * 输出描述:
 * 输出一个整数表示小易最多能消灭多少只怪物。
 * <p>
 * 输入例子1:
 * 5
 * 0 -1 1 1 -1
 * 0 -1 -1 1 1
 * 输出例子1:
 * 5
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] x = new int[100];
        int[] y = new int[100];
        int n;
        n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = cin.nextInt();
        }
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        //至少能够消灭一个怪物
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int dx1 = x[j] - x[i];
                    int dy1 = y[j] - y[i];
                    for (int k = 0; k < n; k++) {
                        int cnt = 0;
                        if (i != k && j != k) {
                            for (int r = 0; r < n; r++) {
                                int dx2 = x[r] - x[i];
                                int dy2 = y[r] - y[i];
                                //点在直线上
                                if (dy1 * dx2 == dy2 * dx1) {
                                    cnt++;
                                } else {
                                    dx2 = x[r] - x[k];
                                    dy2 = y[r] - y[k];
                                    //如果两条直线垂直的话，说明两条指向互相垂直
                                    if (dy1 * dy2 == -dx2 * dx1) {
                                        cnt++;
                                    }
                                }
                            }
                        }
                        res = Math.max(res, cnt);
                    }
                }
            }
        }
        System.out.println(res);
    }
}