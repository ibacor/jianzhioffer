import ext.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Test25 {
    private ArrayList<ArrayList<Integer>> result;

    /**
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     *
     * 思路：使用前序遍历树，用栈保存路径
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        ArrayList<Integer> list = new ArrayList<Integer>();
        FindPath(root, target, list, 0);
        return result;
    }

    private void FindPath(
            TreeNode root, int target, ArrayList<Integer> list, int curSum) {
        if(root == null)
            return;

        curSum += root.val;
        list.add(root.val);

        if(curSum == target && root.right == null && root.left == null){
            ArrayList<Integer> l = new ArrayList<Integer>(list);
            result.add(l);
        }
        else if(curSum < target) {
            FindPath(root.left, target, list, curSum);
            FindPath(root.right, target, list, curSum);
        }

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Test25 test = new Test25();
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(5);
        a.right = new TreeNode(12);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> r1 = test.FindPath(a, 22);
        System.out.println(Arrays.toString(r1.toArray()));
    }
}
