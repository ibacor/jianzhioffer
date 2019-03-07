import ext.TreeNode;

public class Test40 {
    /**
     * 一个整型数组里除了两个数字之外，
     * 其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
     *
     * 思路：这道题比较难，解题方法是通过异或得到某位数不为1，以此为标志把原数组分成两份，
     * 第一份n位为1，第二份n位为0，再分别组内异或，得到'唯一'的结果
     * @param array
     * @param num1 num1[0]为返回结果
     * @param num2 num2[0]为返回结果
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
            return;

        int xor = 0;
        for(int i : array){
            xor ^= i;
        }

        int indexOf1 = findFirstBit1(xor);
        num1[0] = num2[0] = 0;
        for (int i : array) {
            if(isBit1(i, indexOf1))
                num1[0] ^= i;
            else
                num2[0] ^= i;
        }
    }

    /**
     * n位是否是1
     * @param num
     * @param indexOf1
     * @return
     */
    private boolean isBit1(int num, int indexOf1) {
        num >>>= indexOf1;
        return (num & 1) == 1;
    }

    /**
     * 寻找num二进制第一个为1的数
     * @param num
     * @return
     */
    private int findFirstBit1(int num) {
        int index = 0;
        while((num & 1) == 0 && index < 32){
            num >>>= 1;
            index++;
        }
        return index;
    }

}
