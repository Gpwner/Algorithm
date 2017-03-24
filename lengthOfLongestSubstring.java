package lcs;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		int[] a = { 3, 2, 4 };
		int[] b = getSolution(a, 6);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	// 求一个一维数组中和为target的两个数的坐标
	public static int[] getSolution(int[] nums, int target) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(target - nums[i])) {
				int toReturn[] = { hash.get(target - nums[i]), i };
				return toReturn;
			}
			hash.put(nums[i], i);
		}
		return null;
	}
}
