import java.util.Arrays;

public class Test44 {
    /**
     * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。
     * 2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
     *
     * 思路：先对数组进行排序，然后统计0的个数，最后统计数字之间的空缺数，大于0的个数则不连续
     * 另外，如果数组中有数字相等则肯定不为顺子
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length <= 0)
            return false;

        Arrays.sort(numbers);
        int numberOf0 = 0;
        int gap = 0;
        int i = 0;
        for (; i < numbers.length && numbers[i] == 0; i++) {
            numberOf0++;
        }

        while(i + 1 < numbers.length){
            if(numbers[i] == numbers[i+1])
                return false;

            gap += numbers[i+1] - numbers[i] - 1;
            i++;
        }

        return gap <= numberOf0;
    }
}
