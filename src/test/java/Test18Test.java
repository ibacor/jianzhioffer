import ext.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test18Test {

    @Test
    void hasSubtree() {
        Test18 test18 = new Test18();
        // 树B是A的子结构
        //     0            1
        //    /  \         / \
        //   1    2       3   4
        //  / \
        // 3   4
        TreeNode t1A = new TreeNode(0);
        t1A.left = new TreeNode(1);
        t1A.right = new TreeNode(2);
        t1A.left.left = new TreeNode(3);
        t1A.left.right = new TreeNode(4);
        TreeNode t1B = new TreeNode(1);
        t1B.left = new TreeNode(3);
        t1B.right = new TreeNode(4);
        assertTrue(test18.HasSubtree(t1A, t1B));

        // B不是A的子结构
        //     0            0
        //    /  \         / \
        //   1    2       1   2
        //  / \          /
        // 3   4        4
        TreeNode t2A = t1A;
        TreeNode t2B = new TreeNode(0);
        t2B.left = new TreeNode(1);
        t2B.right = new TreeNode(2);
        t2B.left.left = new TreeNode(4);
        assertFalse(test18.HasSubtree(t2A, t2B));

        // 输入null
        assertFalse(test18.HasSubtree(t1A, null));

        // 没有左子树
        TreeNode t3A = new TreeNode(0);
        t3A.right = new TreeNode(1);
        t3A.right.right = new TreeNode(2);
        TreeNode t3B = new TreeNode(0);
        t3B.right = new TreeNode(1);
        assertTrue(test18.HasSubtree(t3A, t3B));

        //没有右子树
        TreeNode t4A = new TreeNode(0);
        t4A.left = new TreeNode(1);
        t4A.left.left = new TreeNode(2);
        TreeNode t4B = new TreeNode(0);
        t4B.left = new TreeNode(2);
        assertFalse(test18.HasSubtree(t4A, t4B));
    }
}