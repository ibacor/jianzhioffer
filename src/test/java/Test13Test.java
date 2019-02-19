import ext.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class Test13Test {

    @Test
    void deleteNode() {
        final Test13 test13 = new Test13();
        // 多个节点删除中间节点
        ListNode head = generateData();
        assertArrayEquals(new int[]{1,2,4,5}, listToArray(test13.deleteNode(head, head.next.next)));

        // 多个节点删除头节点
        head = generateData();
        assertArrayEquals(new int[]{2,3,4,5}, listToArray(test13.deleteNode(head, head)));

        // 多个节点删除尾节点
        head = generateData();
        assertArrayEquals(new int[]{1,2,3,4},
                listToArray(test13.deleteNode(head, head.next.next.next.next)));

        // 只有一个节点
        head = new ListNode(0);
        assertNull(test13.deleteNode(head, head));

        // 特殊输入
        assertNull(test13.deleteNode(null, head));
        assertEquals(head, test13.deleteNode(head, null));
    }

    private ListNode generateData() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
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