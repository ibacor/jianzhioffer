package ext;

/**
 * 包含父节点的树结点
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    // 父节点
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
