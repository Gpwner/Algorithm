package load;

/*
 * 题目：0,1,2,3,4,5,6,7....,n-1个数字排成一个圆圈，从数字0开始每次从这个删除第m个元素，求这个圆圈所剩下的元素的最后的元素的下标
 * 这是典型的约瑟夫问题，根据递推公式可以写出代码
 * */
public class JosephProblem {
	public static void main(String[] args) {
		// 从有三个元素的全中每一次删除第二个元素，最终留下来的元素的下标是：
		System.out.println(LastRemainIndex(3, 2));
		System.out.println(LastRemaining(3, 2));
	}

	// 返回的是最终留下来的元素的下标
	public static int LastRemainIndex(int n, int m) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		if (1 == n) {
			return 0;
		}
		return (LastRemainIndex(n - 1, m) + m) % n;
	}

	// 返回的是最终留下来的元素的下标
	public static int LastRemaining(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}
