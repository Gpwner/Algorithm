package com.gpwner;

/**
 * Created by root on 2017/5/7.
 */
/*
折半查找
 */
public class BinarySearch {
    //
    public static final int NOT_FOUND = -1;

    //返回要查找的下标
    public static int binarySearch(int a[], int x) {
        int high = a.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i + 1;
        }
        int index=binarySearch(a,6);
        System.out.println(a[index]);
    }
}
