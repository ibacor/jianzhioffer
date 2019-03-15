import ext.TreeNode;

import java.util.LinkedList;

public class Test50 {
    /**
     * 树中两个节点的最低公共祖先
     * @param root 树根结点
     * @param p1
     * @param p2
     * @return
     */
    public TreeNode getLastCommonParent(TreeNode root, TreeNode p1, TreeNode p2){
        if(root == null || p1 == null || p2 == null)
            return null;

        LinkedList<TreeNode> path1 = new LinkedList<TreeNode>();
        getNodePath(root, p1, path1);
        LinkedList<TreeNode> path2 = new LinkedList<TreeNode>();
        getNodePath(root, p2, path2);

        return getLastCommonParent(path1, path2);
    }

    private TreeNode getLastCommonParent(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
        int size1 = path1.size();
        int size2 = path2.size();
        if(size1 == 0 || size2 == 0)
            return null;

        int size = size1 < size2 ? size1 : size2;
        int i = 0;
        for (; i < size; i++) {
            if(path1.get(i) != path2.get(i))
                break;
        }

        return path1.get(--i);
    }

    /**
     * 寻找根结点到目标节点到路径
     * @param root
     * @param target
     * @param path
     */
    private void getNodePath(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        if(root == null)
            return;

        if(root == target){
            path.add(root);
            return;
        }
        getNodePath(root.left, target, path);
        getNodePath(root.right, target, path);

        // 现场还原
        path.remove(path.size() - 1);
    }
}
