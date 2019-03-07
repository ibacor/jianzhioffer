public class Test34 {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     *
     * 思路：使用空间换时间的方法，用一个数组保存1到第N个丑数的值。
     * 假设第M个前面数组已排好序，则下一个肯定是前面某个书乘2、3或5之后的最小值
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;

        int[] array = new int[index];
        array[0] = 1;
        int nextIndex = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while(nextIndex < index){
            array[nextIndex] = min(array[p2] * 2, array[p3] * 3, array[p5] * 5);
            while(array[p2] * 2 <= array[nextIndex])
                p2++;
            while(array[p3] * 3 <= array[nextIndex])
                p3++;
            while(array[p5] * 5 <= array[nextIndex])
                p5++;
            nextIndex++;
        }
        return array[nextIndex - 1];
    }

    private int min(int a, int b, int c){
        int min = a < b ? a : b;
        min = min < c ? min : c;
        return min;
    }
}
