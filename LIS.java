package com.gpwner;

/**
 * Created by root on 2017/5/10.
 * 动态规划求最长的非递减序列的长度
 */
public class LIS {
    public static int lIS(int[] array) {
        int[] d = new int[array.length];
        int length = 1;
        for (int i = 0; i < array.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
                if (d[i] > length) {
                    length = d[i];
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 8, 6, 7};
        System.out.println(lIS(array));
    }
}
