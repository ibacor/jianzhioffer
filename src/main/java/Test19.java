import ext.TreeNode;

public class Test19 {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 思路：画图，根据过程，每个节点的左右节点互相交换即可得到树的镜像；
     * 编码时先遍历每个节点，如果有节点则交换两个子节点。
     * @param root
     */
    public void Mirror(TreeNode root) {
        // 根结点为null，或者为叶子节点
        if(root == null || (root.left == null && root.right == null))
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }
}
