package lcs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//��һ��nά������������֮��Ϊ0�����п��ܣ��������ظ��Ľ�
public class ThreeSum {
	public static void main(String[] args) {
		int array[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> list = threeSum(array);
		for (Iterator<List<Integer>> iterator = list.iterator(); iterator.hasNext();) {
			List<Integer> list2 = (List<Integer>) iterator.next();
			for (Iterator<Integer> iterator2 = list2.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		// length - 2��ֹ����Խ�磬��Ϊlo = i + 1
		for (int i = 0; i < num.length - 2; i++) {

			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				// ������num[i]���Ϊ0�Ľⲻֹ��һ���
				while (lo < hi) {
					// ����������ʱ�򣬽����װ��ArrayList
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						// ������ͬ�Ľ�Сֵ
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						// ������ͬ�����ֵ
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						// ���λ�����λ������1
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return res;
	}
}
