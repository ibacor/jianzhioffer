import ext.TreeNode;

public class Test39 {
    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
     * 形成树的一条路径，最长路径的长度为树的深度。
     *
     * 思路：流程就是遍历树，对于当前节点，包含该节点的深度是左右子树的深度最大值加1
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 思路；使用后序遍历，在遍历一个节点之前就遍历它的左右子树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        int[] depth = new int[1];
        return isBanlanced(root, depth);
    }

    private boolean isBanlanced(TreeNode root, int[] depth) {
        if(root == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if(isBanlanced(root.left, left) && isBanlanced(root.right, right)){
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }
}
