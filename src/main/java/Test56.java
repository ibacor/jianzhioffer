import ext.ListNode;

public class Test56 {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *
     * 思路：用速度来理解，快指针的速度是慢指针的2倍，若含有环必定相遇，
     * 快指针的路程是慢指针的2倍。这时把快指针重新指向第一个点，必定会在原来的位置相遇，
     * 所以第一次相等的节点就是环的入口
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }

        // 链表中没有环
        if(fast == null || fast.next == null)
            return null;

        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
