import ext.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 解法一：利用栈先进后出的特性
 * 解法二：利用递归
 */
public class Test05 {
    // 反向输出链表值，这里要去不能改变链表结构，即无法链表反转
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null)
            return new ArrayList<Integer>();
//        return useStack(listNode);
        ArrayList<Integer> result = new ArrayList<Integer>();
        useRecursive(result, listNode);
        return result;
    }

    // 利用栈后进先出的特性
    private ArrayList<Integer> useStack(ListNode listNode){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(listNode.val);
        while(listNode.next != null){
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    // 方法二：使用递归
    private void useRecursive(ArrayList<Integer> list, ListNode listNode){
        if(listNode == null)
            return;

        useRecursive(list, listNode.next);
        list.add(listNode.val);
    }
}
