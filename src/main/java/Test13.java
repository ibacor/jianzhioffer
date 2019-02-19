import ext.ListNode;

public class Test13 {
    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点
     * 原理为把下一节点覆盖到待删除节点，把待删除节点的next指针指向后两个节点，
     * 即可实现O(1)级复杂度
     * @param head
     * @param toBeDeleted
     * @return
     */
    public ListNode deleteNode(ListNode head, ListNode toBeDeleted){
        ListNode node = head;
        if(node == null || toBeDeleted == null)
            return node;

        if(toBeDeleted.next != null){
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        // 尾节点
        else {
            // 只有一个节点且删除该节点
            if(node.next == null)
                return null;
            while(node.next != toBeDeleted)
                node = node.next;
            node.next = null;
        }
        return head;
    }
}
