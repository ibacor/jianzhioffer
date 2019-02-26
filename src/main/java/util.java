import ext.ListNode;
import ext.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class util {

    // 遍历比较树的内容是否相等
    public static boolean compareTree(TreeNode t1, TreeNode t2){
        if(t1 == null) {
            if(t2 != null)
                return false;
            return true;
        }
        if(t1.val != t2.val){
            return false;
        }

        if(!compareTree(t1.left, t2.left) ||
                !compareTree(t1.right, t2.right))
            return false;
        return true;
    }

    // 比较两个ArrayList内容是否相等
    public static boolean compareArrayList(ArrayList<Integer> array1, ArrayList<Integer> array2){
        if(array1.size() != array2.size())
            return false;
        int size = array1.size();
        for(int i = 0; i < size; i++){
            if(!array1.get(i).equals(array2.get(i)))
                return false;
        }
        return true;
    }

    public static int[] list2IntArray(ListNode head){
        int length = 1;
        ListNode node = head;
        while(node.next != null) {
            length++;
            node = node.next;
        }
        int[] array = new int[length];
        int i = 0;
        while(head != null){
            array[i] = head.val;
            head = head.next;
            i++;
        }
        return array;
    }

    public static int[] list2IntArray(List<Integer> list){
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
