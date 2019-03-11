public class Test47 {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * 思路：通过二进制位运算实现
     * 分成3步实现：第一步，不考虑进位相加，异或运算；第二步，考虑进位，先与运算再左移
     * 第三步，重复前两步直到没有进位
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return sum;
    }
}
