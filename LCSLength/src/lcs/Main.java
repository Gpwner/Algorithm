package lcs;

//求两个字符串的公共最长子序列
public class Main {
	public static void main(String[] args) {
		String aString = "ABCDJFLFKHOUH";
		String bString = "BCDLOUH" ;
		int[][] matrixL = new int[aString.length()][bString.length()];
		int[][] matrixC = new int[aString.length()][bString.length()];
		LCSLength(aString, bString, matrixL, matrixC);
//		for (int i = 0; i < matrixL.length; i++) {
//			for (int j = 0; j < matrixL[0].length; j++) {
//				System.out.print(matrixL[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.print("两个字符串的最长子序列是：");
		LCS(aString.length() - 1, bString.length() - 1, aString.toCharArray(), matrixC);

	}

	public static void LCSLength(String aString, String bstring, int[][] matrixLength, int[][] matrixChoose) {
		char[] arrayA = aString.toCharArray();
		char[] arrayB = bstring.toCharArray();
		if (arrayA[0] == arrayB[0]) {
			for (int i = 0; i < arrayA.length; i++) {
				matrixChoose[i][0] = 2;
				matrixLength[i][0] = 1;
			}
			for (int i = 0; i < arrayB.length; i++) {
				matrixChoose[0][i] = 3;
				matrixLength[0][i] = 1;
			}
			matrixChoose[0][0] = 1;
		}

		for (int i = 1; i < arrayA.length; i++) {
			for (int j = 1; j < arrayB.length; j++) {
				if (arrayA[i] == arrayB[j]) {
					matrixLength[i][j] = matrixLength[i - 1][j - 1] + 1;
					matrixChoose[i][j] = 1;
				} else if (matrixLength[i - 1][j] >= matrixLength[i][j - 1]) {
					matrixLength[i][j] = matrixLength[i - 1][j];
					matrixChoose[i][j] = 2;
				} else {
					matrixLength[i][j] = matrixLength[i][j - 1];
					matrixChoose[i][j] = 3;
				}
			}
		}
	}

	public static void LCS(int posi, int posj, char[] achars, int[][] matrixChoose) {
		if (posi == -1 || posj == -1) {
			return;
		}
		if (matrixChoose[posi][posj] == 1) {
			LCS(posi - 1, posj - 1, achars, matrixChoose);
			System.out.print(achars[posi]);
		} else if (matrixChoose[posi][posj] == 2) {
			LCS(posi - 1, posj, achars, matrixChoose);
		} else {
			LCS(posi, posj - 1, achars, matrixChoose);
		}
	}
}
