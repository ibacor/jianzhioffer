import ext.TreeNode;

public class Test63 {
    int index = 0;
    TreeNode kNode;

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
     * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        // 二叉搜索树中序遍历后的结果是一个从小到大排列的数组

        if (pRoot == null || k < 1) {
            return null;
        }
        return null;
    }

    void findNode(TreeNode node, int k){
        if(node == null)
            return;
        findNode(node.left,k);
        if(++index == k){
            kNode = node;
            return;
        }
        findNode(node.right,k);
    }
}
