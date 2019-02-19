import ext.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test15Test {

    @Test
    void findKthToTail() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Test15 test15 = new Test15();
        // 链表中间
        assertEquals(head.next.next, test15.FindKthToTail(head,3));
        // 链表头
        assertEquals(head, test15.FindKthToTail(head, 5));
        // 尾节点
        assertEquals(head.next.next.next.next, test15.FindKthToTail(head, 1));

        // 边界测试
        assertNull(test15.FindKthToTail(null, 3));
        assertNull(test15.FindKthToTail(head, 0));
        assertNull(test15.FindKthToTail(head, 10));
    }
}