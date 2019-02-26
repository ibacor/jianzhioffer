public class Test24 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;

        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if(start >= end)
            return true;
        int root = sequence[end];
        int i;
        for (i = start; i < end; i++) {
            if(sequence[i] > root)
                break;
        }
        // 验证右子树大于根结点
        for (int j = i; j < end; j++) {
            if(sequence[j] < root)
                return false;
        }

        return VerifySquenceOfBST(sequence, start, i - 1) && VerifySquenceOfBST(sequence, i, end - 1);
    }
}
