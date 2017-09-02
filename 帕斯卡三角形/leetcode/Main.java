package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<List<Integer>> res = main.generate(5);
        for (List<Integer> re : res) {
            System.out.print("[ ");
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List temp = new LinkedList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    temp.add(1);
                } else {
                    List<Integer> lastList = res.get(res.size() - 1);
                    temp.add(lastList.get(j - 1) + lastList.get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}