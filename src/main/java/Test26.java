import ext.RandomListNode;

public class Test26 {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * 书上的解题思路真是惊为天人：
     * 分为3步
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;

        cloneNodes(pHead);
        connectRandomNode(pHead);
        return reconnectNodes(pHead);
    }

    /**
     * 复制节点，把复制出来的节点放到原节点后面
     * @param pHead
     */
    private void cloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;

            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    /**
     * 设置随机连接
     * @param pHead
     */
    private void connectRandomNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node != null){
            RandomListNode cloned = node.next;
            if(node.random != null)
                cloned.random = node.random.next;
            node = cloned.next;
        }
    }

    /**
     * 把链表拆分成两个链表：奇数抽出来为原链表，偶数抽出来为复制链表
     * @param pHead
     * @return
     */
    private RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        if(node != null){
            cloneHead = cloneNode = node.next;
            node.next = cloneHead.next;
            node = node.next;
        }
        while(node != null){
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }
}
