public class Test31 {
    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
     * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
     *
     * 思路：使用动态规划：f(i) = array[i]    i=0或f(i-1)<=0
     *                         f(i-1) + array[i] i!=0且f(i-1)>0
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0)
            return 0;

        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : array){
            if(sum <= 0)
                sum = i;
            else
                sum += i;

            if(result < sum)
                result = sum;
        }

        return result;
    }
}
