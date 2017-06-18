/**
 * @author 把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。输入n，打印出S的所有可能的值出现的概率。
 * @version 2017/6/18 10:28
 */
public class DiceProblem {
    private static int dice_max_value = 6;

    /*
    * numberOfDice骰子的个数
    * currentDice当前观察的骰子的序列
    * currentDiceValue当前骰子向上一面的数字
    * tempSum前几个骰子的向上那一面的累加和
    * sumArray次数统计数组
    * **/
    public static void calCount(int numberOfDice, int currentDice, int currentDiceValue, int tempSum, int[] sumArray) {
        if (currentDice == 1) {
            int sum = currentDiceValue + tempSum;
            sumArray[sum - numberOfDice]++;
        } else {
            for (int i = 1; i <= dice_max_value; i++) {
                int sum = currentDiceValue + tempSum;
                calCount(numberOfDice, currentDice - 1, i, sum, sumArray);
            }
        }
    }

    public static void calCount(int numberOfDice, int[] sumArray) {
        for (int i = 1; i <= dice_max_value; i++) {
            //第一个骰子向上的一面的数值为i,因为是第一个骰子所以呢，累加和自然为0
            calCount(numberOfDice, numberOfDice, i, 0, sumArray);
        }
    }

    public static void main(String[] args) {
        int diceNumber = 6;
        int max_value = diceNumber * dice_max_value;
        int[] sumArray = new int[max_value - diceNumber + 1];
        calCount(diceNumber, sumArray);
        double totalCount = Math.pow(6, 6);
        for (int i = diceNumber; i <= max_value; i++) {
            System.out.println(i + "  ---  " + (double)sumArray[i - diceNumber] / totalCount);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
