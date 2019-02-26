import ext.TreeNode;

public class Test27 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * 思路：先解链，二叉搜索树中序遍历的结果为有序；
     * 再找到双向链表的最小节点，返回
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;

        TreeNode[] lastNode = new TreeNode[1];
        convert(pRootOfTree, lastNode);

        TreeNode head = lastNode[0];
        while(head != null && head.left != null)
            head = head.left;
        return head;
    }

    private void convert(TreeNode node, TreeNode[] lastNode){
        if(node == null)
            return;

        if(node.left != null){
            convert(node.left, lastNode);
        }

        node.left = lastNode[0];
        if(lastNode[0] != null)
            lastNode[0].right = node;
        lastNode[0] = node;

        if(node.right != null){
            convert(node.right, lastNode);
        }
    }
}
