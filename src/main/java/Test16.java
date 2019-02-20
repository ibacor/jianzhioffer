import ext.ListNode;

public class Test16 {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     *
     * 原理：防止链表断裂，必须使用3个指针
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3;
        while(p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }
}
