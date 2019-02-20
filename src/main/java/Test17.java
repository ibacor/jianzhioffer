import ext.ListNode;

public class Test17 {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode root = new ListNode(0);
        ListNode pre = root;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val) {
                pre.next = p1;
                p1 = p1.next;
            }else{
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }

        if(p1 == null){
            pre.next = p2;
        }else {
            pre.next = p1;
        }

        return root.next;
    }
}
