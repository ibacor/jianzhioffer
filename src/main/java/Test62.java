import ext.TreeNode;

import java.util.LinkedList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的
 * 二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节
 * 点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
// todo 待ac
public class Test62 {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.remove(0);
            if (node == null) {
                sb.append("#!");
            }else {
                sb.append(node.val);
                sb.append("!");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        String[] strs = str.split("!");
        Integer[] numbers = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if ("#".equals(strs[i])) {
                numbers[i] = null;
            } else {
                numbers[i] = Integer.parseInt(strs[i]);
            }
        }
        return Deserialize(numbers, 0);
    }

    TreeNode Deserialize(Integer[] numbers, int index) {
        if (numbers.length <= index || numbers[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(numbers[index]);
        root.left = Deserialize(numbers, index*2+1);
        root.right = Deserialize(numbers, index*2+2);
        return root;
    }
}
