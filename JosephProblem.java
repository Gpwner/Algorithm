package load;

/*
 * ��Ŀ��0,1,2,3,4,5,6,7....,n-1�������ų�һ��ԲȦ��������0��ʼÿ�δ����ɾ����m��Ԫ�أ������ԲȦ��ʣ�µ�Ԫ�ص�����Ԫ�ص��±�
 * ���ǵ��͵�Լɪ�����⣬���ݵ��ƹ�ʽ����д������
 * */
public class JosephProblem {
	public static void main(String[] args) {
		// ��������Ԫ�ص�ȫ��ÿһ��ɾ���ڶ���Ԫ�أ�������������Ԫ�ص��±��ǣ�
		System.out.println(LastRemainIndex(3, 2));
		System.out.println(LastRemaining(3, 2));
	}

	// ���ص���������������Ԫ�ص��±�
	public static int LastRemainIndex(int n, int m) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		if (1 == n) {
			return 0;
		}
		return (LastRemainIndex(n - 1, m) + m) % n;
	}

	// ���ص���������������Ԫ�ص��±�
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
