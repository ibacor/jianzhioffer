public class Test36 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
     * 即输出P%1000000007
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 0)
            return 0;

        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        
        return inversePairsCore(array, copy, 0, array.length - 1);
    }

    private int inversePairsCore(int[] array, int[] copy, int start, int end) {
        if(start == end) {
            copy[start] = array[start];
            return 0;
        }

        int length = (end - start) / 2;
        // 注意这里下面array和copy位置
        int left = inversePairsCore(copy, array, start, start + length);
        int right = inversePairsCore(copy, array, start + length + 1, end);

        // 前半段最后一个下标
        int i = start + length;
        // 后半段最后一个下标
        int j = end;
        // 拷贝位置
        int indexCopy = end;
        int count = 0;

        while(i >= start && j >= start + length + 1){
            if(array[i] > array[j]){
                copy[indexCopy] = array[i];
                indexCopy--;
                i--;
                count += j - start - length;
            }else{
                copy[indexCopy] = array[j];
                indexCopy--;
                j--;
            }
        }
        for (; i >= start; i--) {
            copy[indexCopy] = array[i];
            indexCopy--;
            i--;
        }
        for (; j >= start + length + 1; j--) {
            copy[indexCopy] = array[j];
            indexCopy--;
            j--;
        }
        return left + right + count;
    }
}
