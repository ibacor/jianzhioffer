import ext.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Test60 {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // 用BFS控制遍历顺序也能实现
        // 一般做法是使用两个栈，一个栈存奇数行，一个存偶数行，利用LIFO特性分别从右到左、从左到右遍历

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (pRoot == null) {
            return res;
        }

        // 存奇数行节点
        Stack<TreeNode> stack1 = new Stack<>();
        // 存偶数行节点
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()) {
            ArrayList<Integer> res1 = new ArrayList<>();
            ArrayList<Integer> res2 = new ArrayList<>();

            TreeNode cur;
            // 遍历奇数行
            while (!stack1.empty()) {
                cur = stack1.pop();
                if (cur.left != null) {
                    stack2.push(cur.left);
                }
                if (cur.right != null) {
                    stack2.push(cur.right);
                }
                res1.add(cur.val);
            }
            if (!res1.isEmpty()) {
                res.add(res1);
            }

            // 遍历偶数行
            while(!stack2.empty()) {
                cur = stack2.pop();
                if (cur.right != null) {
                    stack1.push(cur.right);
                }
                if (cur.left != null) {
                    stack1.push(cur.left);
                }
                res2.add(cur.val);
            }
            if (!res2.isEmpty()) {
                res.add(res2);
            }
        }
        return res;
    }
}
