package leetcode;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
class Main {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        Main main = new Main();
        System.out.println(main.findUnsortedSubarray(nums));
    }


    public int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, minFromRight = A[n - 1], maxFromLeft = A[0];
        for (int i = 1; i < n; i++) {
            maxFromLeft = Math.max(maxFromLeft, A[i]);
            minFromRight = Math.min(minFromRight, A[n - 1 - i]);
            //如果当前的元素比其之前的所有元素小的话，说明这个元素递减了，
            // 包括此元素在内的子串需要重新排序以达到升序的目的
            if (A[i] < maxFromLeft)
                end = i;
            //同理，如果当前元素比其右边的所有的元素中的最小值要大的话
            //说明这个元素的位置往右递减了，不符合题意
            //所以如果想要在从这个位置开始重新排序
            if (A[n - 1 - i] > minFromRight)
                beg = n - 1 - i;
        }
        //这里将end初始化为-2是考虑到极端的情况，这个数组是已排序的，此时end=-2,begin=-1,那么需要操作的长度自然就是-2-（-1）+1=-2+2=0，很机智
        return end - beg + 1;
    }

}