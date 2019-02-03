import ext.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class Test06Test {

    private boolean isEquals;

    @Test
    void reConstructBinaryTree() {
        isEquals = true;
        completeBT();

        isEquals = true;
        normalBT();

        isEquals = true;
        noRight();

        isEquals = true;
        noLeft();

        isEquals = true;
        oneNode();

        exceptionTest();
    }

    // 遍历比较树的内容
    void compareTree(TreeNode t1, TreeNode t2){
        if(t1 == null) {
            if(t2 != null)
                isEquals = false;
            return;
        }
        if(t1.val != t2.val){
            isEquals = false;
            return;
        }
        compareTree(t1.left, t2.left);
        compareTree(t1.right, t2.right);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     /
    //        4   5   6
    void completeBT(){
        TreeNode ans = new TreeNode(1);
        TreeNode tow = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        ans.left = tow;ans.right = three;
        tow.left = new TreeNode(4);
        tow.right = new TreeNode(5);
        three.left = new TreeNode(6);

        int[] pre = {1,2,4,5,3,6};
        int[] in = {4,2,5,1,6,3};
        TreeNode res = new Test06().reConstructBinaryTree(pre, in);
        compareTree(ans, res);
        assertTrue(isEquals);
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private void normalBT() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode res = new Test06().reConstructBinaryTree(preorder, inorder);

        TreeNode ans = new TreeNode(1);
        TreeNode tow = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        ans.left = tow;ans.right = three;
        tow.left = four;
        four.right = new TreeNode(7);
        three.left = new TreeNode(5);three.right = six;
        six.left = new TreeNode(8);

        compareTree(ans, res);
        assertTrue(isEquals);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private void noRight() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode res = new Test06().reConstructBinaryTree(preorder, inorder);

        TreeNode ans = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        ans.left = two;
        two.left = three;
        three.left = four;
        four.left = new TreeNode(5);

        compareTree(ans, res);
        assertTrue(isEquals);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private void noLeft() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode res = new Test06().reConstructBinaryTree(preorder, inorder);

        TreeNode ans = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        ans.right = two;
        two.right = three;
        three.right = four;
        four.right = new TreeNode(5);

        compareTree(ans, res);
        assertTrue(isEquals);
    }

    // 树中只有一个结点
    private void oneNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode res = new Test06().reConstructBinaryTree(preorder, inorder);

        TreeNode ans = new TreeNode(1);
        compareTree(ans, res);
        assertTrue(isEquals);
    }

    // 输入的两个序列不匹配
    private void exceptionTest() {
        final int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        final int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        assertThrows(RuntimeException.class, new Executable() {
            public void execute() {
                new Test06().reConstructBinaryTree(preorder, inorder);
            }
        });
    }

}