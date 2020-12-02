import ext.TreeLinkNode;

public class Test58 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        // 存在右节点
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }

        while(pNode.next != null){
            // 子节点是父节点的左节点
            if(pNode.next.left == pNode) return pNode.next;
            // 子节点是父节点的有节点，需要往上回溯
            pNode = pNode.next;
        }
        return null;
    }
}
