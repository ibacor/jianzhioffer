import ext.TreeNode;

public class Test06 {
    // 前序遍历第一个就是根结点，中序遍历对应元素左边为左子树，右边为右子树
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null || pre.length != in.length || pre.length < 1)
            return null;
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        // 终止条件，作为叶子节点的"子节点"
        if(ps > pe)
            return null;
        int val = pre[ps];
        int index = is;
        while(index <= ie && in[index] != val)
            index++;
        // 遍历也找不到说明两个数组无法对应
        if(index > ie)
            throw new RuntimeException("Invalid input.");

        TreeNode node = new TreeNode(val);
        node.left = reConstructBinaryTree(pre, ps+1, ps+index-is, in, is, index -1);
        node.right = reConstructBinaryTree(pre, ps+index-is+1, pe, in, index+1, ie);
        return node;
    }
}
