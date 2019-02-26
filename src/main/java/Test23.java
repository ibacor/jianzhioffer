import ext.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test23 {
    /**
     *从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 思路：本质是树的广度搜索
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node;
        while(!queue.isEmpty()){
            node = queue.remove();
            res.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return res;
    }
}
