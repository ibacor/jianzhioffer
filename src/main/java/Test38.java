public class Test38 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     * 思路：使用二分法找出第一个和最后一个k，总体时间为O(log(n))
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int result = 0;
        if(array != null && array.length > 0){
            int first = getFirstK(array, k);
            int last = getLastK(array, k);
            if(first > -1 && last > -1){
                result = last - first + 1;
            }
        }
        return result;
    }

    private int getFirstK(int[] array, int k){
        if(array == null || array.length <= 0)
            return -1;

        int start = 0;
        int end = array.length - 1;
        int midIndex;
        int midN;
        while(start <= end){
            midIndex = start + (end - start) / 2;
            midN = array[midIndex];

            if(midN == k){
                if(midIndex > 0 && array[midIndex-1] != k || midIndex == 0)
                    return midIndex;
                else
                    end = midIndex - 1;
            }else if(midN > k){
                end = midIndex - 1;
            }else{
                start = midIndex + 1;
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int k){
        if(array == null || array.length <= 0)
            return -1;

        int start = 0;
        int end = array.length - 1;
        int midIndex;
        int midN;
        while(start <= end){
            midIndex = start + (end - start) / 2;
            midN = array[midIndex];

            if(midN == k){
                if(midIndex + 1 < array.length && array[midIndex+1] != k || midIndex == array.length - 1)
                    return midIndex;
                else
                    start = midIndex + 1;
            }else if(midN > k){
                end = midIndex - 1;
            }else{
                start = midIndex + 1;
            }
        }
        return -1;
    }
}
