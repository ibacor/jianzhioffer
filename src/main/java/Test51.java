public class Test51 {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * @param numbers
     * @param length
     * @param duplication 保存重复数字
     * @return 返回是否存在重复数字
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length < 1)
            return false;

        for(int i : numbers){
            if(i < 0 || i >= length)
                return false;
        }

        for (int i = 0; i < length; i++) {
            // 当i和numbers[i]位置当数字不相同时一直交换
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return false;
    }

    private void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
