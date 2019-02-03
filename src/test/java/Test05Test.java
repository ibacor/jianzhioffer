import ext.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test05Test {

    @Test
    void printListFromTailToHead() {
        Test05 test05 = new Test05();
        ListNode head1 = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode tow = new ListNode(2);
        head1.next = one;
        one.next = tow;
        tow.next = new ListNode(3);
        ArrayList<Integer> result1 = test05.printListFromTailToHead(head1);
        ArrayList<Integer> ans1 = new ArrayList<Integer>();
        ans1.add(3);ans1.add(2);ans1.add(1);ans1.add(0);
        assertTrue(compareArrayList(ans1, result1));

        ListNode head2 = new ListNode(1);
        ArrayList<Integer> res2 = test05.printListFromTailToHead(head2);
        ArrayList<Integer> ans2 = new ArrayList<Integer>();
        ans2.add(1);
        assertTrue(compareArrayList(res2, ans2));

        ArrayList<Integer> res3 = test05.printListFromTailToHead(null);
        assertTrue(compareArrayList(new ArrayList<Integer>(), res3));
    }

    boolean compareArrayList(ArrayList<Integer> array1, ArrayList<Integer> array2){
        if(array1.size() != array2.size())
            return false;
        int size = array1.size();
        for(int i = 0; i < size; i++){
            if(!array1.get(i).equals(array2.get(i)))
                return false;
        }
        return true;
//        return !array1.retainAll(array2);
    }
}