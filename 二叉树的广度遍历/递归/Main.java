package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        node1.right = node2;
        node1.left = node3;
        node3.left = node6;
        node2.left = node5;
        node2.right = node4;
        node5.right = node7;
        System.out.println(new Main().levelOrder(node1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(res, root, 0);
        return res;
    }

    public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int hight) {
        if (root == null) {
            return;
        }
        if (hight == res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(hight).add(root.val);
        levelOrderHelper(res,root.right,hight+1);
        levelOrderHelper(res,root.left,hight+1);
    }

}
