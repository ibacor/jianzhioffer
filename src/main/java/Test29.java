public class Test29 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
     * 超过数组长度的一半，因此输出2。如果不存在则输出0。
     *
     * 思路：从第一个数开始，出现相同数个数值+1，不同数-1，最后统计剩下的是否超过一半
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0)
            return 0;

        int result = array[0];
        int times = 1;
        for (int i = 0; i < array.length; i++) {
            if(times == 0){
                result = array[i];
                times = 1;
            }else if(array[i] == result)
                times++;
            else
                times--;
        }

        times = 0;
        for(int n : array){
            if(result == n)
                times++;
        }
        if(times > array.length / 2)
            return result;
        return 0;
    }
}
