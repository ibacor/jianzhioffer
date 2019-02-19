import ext.ListNode;

public class Test15 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k 倒数第k个节点，从1开始
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k < 1){
            return null;
        }

        ListNode p1 = head, p2 = head;
        for (int i = 0; i < k-1; i++) {
            p2 = p2.next;
            if(p2 == null)
                return null;
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
