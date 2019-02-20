import ext.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test16Test {

    @Test
    void reverseList() {
        Test16 test16 = new Test16();
        // 多个节点
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        assertArrayEquals(new int[]{4,3,2,1}, listToArray(test16.ReverseList(h1)));

        // 单个节点
        ListNode h2 = new ListNode(1);
        assertArrayEquals(new int[]{1}, listToArray(test16.ReverseList(h2)));

        // 特殊输入
        assertNull(test16.ReverseList(null));
    }

    int[] listToArray(ListNode head){
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
}