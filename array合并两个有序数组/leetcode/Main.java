package leetcode;

class Main {
    public static void main(String[] args) {
        int[] arrayA = {0};
        int[] arrayB = {1};
        Main main = new Main();
        main.merge(arrayA, 0, arrayB, 1);

        for (int i = 0; i < arrayA.length; i++) {
            System.out.print(arrayA[i] + " ");
        }
        System.out.println();

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int index = m + n - 1;
        while (indexA >= 0 && indexB >= 0) {
            nums1[index--] = nums1[indexA] > nums2[indexB] ? nums1[indexA--] : nums2[indexB--];
        }
        while (indexB >= 0) {
            nums1[index--] = nums2[indexB--];
        }
    }

}