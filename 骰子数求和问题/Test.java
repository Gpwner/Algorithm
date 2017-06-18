/**
 * @author 把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。输入n，打印出S的所有可能的值出现的概率。
 * @version 2017/6/16 22:04
 */
public class Test {
    public static void main(String[] args) {
        Test p = new Test();
        p.printProbability(2);
    }

    public void printProbability(int number) {
        if (number < 1)
            return;
        int gMaxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[gMaxValue * number + 1];//13
        probabilities[1] = new int[gMaxValue * number + 1];//13
        //*****************************************************************
        int flag = 0;
        //第一个骰子
        for (int i = 1; i <= gMaxValue; i++) {
            probabilities[flag][i] = 1;
        }
        //除了第一个骰子之外的其余骰子
        for (int k = 2; k <= number; ++k) {
            //0->k
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;//初始化第二个数组
            }
            //k->gMaxValue * k，k个骰子最小之和为k,,最大之和为k*每一个骰子的最大点数
            for (int i = k; i <= gMaxValue * k; i++) {
                probabilities[1 - flag][i] = 0;//更新这个位置，这个位置表示和为n的次数
                for (int j = 1; j <= i && j <= gMaxValue; j++)//j<=i是为了下面的数组不越界
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        //*****************************************************************


        double total = Math.pow(gMaxValue, number);
        for (int i = number; i <= gMaxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.print(i + " ");
            System.out.println(ratio);
        }
    }
}
