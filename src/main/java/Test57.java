import ext.ListNode;

public class Test57 {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null)
            return null;

        // 记录头节点，预防前几个节点相同的情况
        ListNode root = new ListNode(0);
        root.next = pHead;
        // 前驱节点
        ListNode prev = root;
        // 当前处理节点
        ListNode node = pHead;
        while(node != null && node.next != null){
            // 节点重复
            if(node.val == node.next.val){
                // 下一个不同值节点
                while(node.next != null && node.next.val == node.val)
                    node = node.next;

                prev.next = node.next;
            }else{
                prev = prev.next;
            }
            node = node.next;
        }

        return root.next;
    }
}
