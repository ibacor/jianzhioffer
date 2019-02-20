import ext.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test17Test {

    @Test
    void merge() {
        Test17 test17 = new Test17();
        // 多个不同节点
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(3);
        h1.next.next = new ListNode(5);
        h1.next.next.next = new ListNode(7);
        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(4);
        h2.next.next = new ListNode(6);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7}, listToArray(test17.Merge(h1,h2)));
        // 多个含有相同节点
        ListNode h5 = new ListNode(1);
        h5.next = new ListNode(3);
        h5.next.next = new ListNode(5);
        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(3);
        assertArrayEquals(new int[]{1,2,3,3,5}, listToArray(test17.Merge(h5,h3)));

        // 只有一个节点
        ListNode h4 = new ListNode(4);
        ListNode h6 = new ListNode(1);
        h6.next = new ListNode(3);
        h6.next.next = new ListNode(5);
        assertArrayEquals(new int[]{1,3,4,5}, listToArray(test17.Merge(h6, h4)));

        //输入null
        assertArrayEquals(listToArray(h1), listToArray(test17.Merge(h1, null)));
        assertArrayEquals(listToArray(h2), listToArray(test17.Merge(null, h2)));
        assertNull(test17.Merge(null, null));

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