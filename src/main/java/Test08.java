public class Test08 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     *
     * 思路：这是二分查找的变形，在这里要区分的情况较多，并且需要特别注意当相等时只能顺序遍历的情况
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array == null)
            throw new RuntimeException("Invalid input");
        if(array.length <= 0)
            return 0;

        int l = 0;
        int h = array.length - 1;
        int m = l;
        while(array[l] >= array[h]){
            // array[l] >= array[h]，只剩下两个，所以array[h]最小
            if(h - l == 1)
                return array[h];
            m = (l + h) / 2;
            // 首尾、中间都相等只能顺序查找
            if(array[l] == array[m] && array[h] == array[m])
                return findInOrder(array, l, h);
            // 最小值在后半部分
            if(array[m] >= array[l])
                l = m;
            // 最小值在前半部分
            else if(array[m] <= array[h])
                h = m;
        }
        return array[m];
    }

    private int findInOrder(int[] array, int l, int h) {
        int min = array[l];
        for (int i = l + 1; i <= h; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
