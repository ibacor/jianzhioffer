import ext.TreeNode;

public class Test59 {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，
     * 如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }

    /**
     * 递归比较左右子树
     */
    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
