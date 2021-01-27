import ext.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test61 {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // 使用BFS遍历二叉树，用两个int值标志一行节点数

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        // 当前层个数，初始化=1
        int current = 1;
        // 下一层个数
        int next = 0;
        ArrayList<Integer> res1 = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            res1.add(node.val);
            current--;

            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }

            if (current == 0) {
                res.add(res1);

                res1 = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return res;
    }
}
