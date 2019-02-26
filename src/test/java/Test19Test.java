import ext.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test19Test {

    @Test
    void mirror() {
        Test19 test19 = new Test19();
        // 普通二叉树
        //        0
        //       / \
        //      1   2
        //     /
        //    3
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        TreeNode t1M = new TreeNode(0);
        t1M.left = new TreeNode(2);
        t1M.right = new TreeNode(1);
        t1M.right.right = new TreeNode(3);
        test19.Mirror(t1);
        assertTrue(util.compareTree(t1M, t1));

        // 只有左子树
        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(1);
        t2.left.left = new TreeNode(2);
        TreeNode t2M = new TreeNode(0);
        t2M.right = new TreeNode(1);
        t2M.right.right = new TreeNode(2);
        test19.Mirror(t2);
        assertTrue(util.compareTree(t2M, t2));

        // 只有右子树
        TreeNode t3 = t2M;
        TreeNode t3M = new TreeNode(0);
        t3M.left = new TreeNode(1);
        t3M.left.left = new TreeNode(2);
        test19.Mirror(t3);
        assertTrue(util.compareTree(t3M, t3));

        // 输入null
        TreeNode t4 = null;
        test19.Mirror(t4);
        assertNull(t4);
    }
}