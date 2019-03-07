import ext.ListNode;

public class Test37 {
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     *
     * 思路：遍历两个链表找出它们的长度m 和 n（m>n），先走m-n，在一起走知道第一个共同点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);
        ListNode Long;
        ListNode Short;
        int dif;
        if(length1 > length2){
            Long = pHead1;
            Short = pHead2;
            dif = length1 - length2;
        }else{
            Long = pHead2;
            Short = pHead1;
            dif = length2 - length1;
        }
        for (int i = 0; i < dif; i++) {
            Long = Long.next;
        }
        while(Long != null && Short != null){
            if(Long == Short)
                return Long;
            Long = Long.next;
            Short = Short.next;
        }
        return null;
    }

    private int getListLength(ListNode listNode){
        int len = 0;
        while(listNode != null){
            len++;
            listNode = listNode.next;
        }
        return len;
    }
}
