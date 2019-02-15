public class Test08 {
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
