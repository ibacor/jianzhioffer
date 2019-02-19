public class Test14 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * 思路：书上不要求相对位置不变，用首尾两指针往中间移交换元素
     * 这里获取第一个偶数的指针，再获取第一个偶数之后的第一个奇数指针，中间元素整体后移
     * 最终时间复杂度是O(n^2)
     * @param array
     */
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)
            return;
        int pEven = 0;
        while(pEven < array.length && (array[pEven] & 1) != 0){
            pEven++;
        }
        int pOdd = pEven;
        while(pOdd < array.length) {
            while((array[pOdd] & 1) == 0){
                pOdd++;
                if(pOdd >= array.length){
                    return;
                }
            }

            int temp = array[pOdd];
            System.arraycopy(array, pEven, array, pEven + 1, pOdd - pEven);
            array[pEven] = temp;

            pEven++;
        }
    }
}
