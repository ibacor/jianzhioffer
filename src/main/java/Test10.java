public class Test10 {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 解法一：把原数字和1与，再右移
     * 解法二：把1左移在与运算
     * @param n
     * @return
     */
    public int NumberOf1I(int n) {
        int count = 0;
//        // int型数值逐个右移查看
//        for (int i = 0; i < 32; i++) {
//            count += n & 1;
//            n >>>= 1;
//        }
        // 1左移做对比
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            if((n&flag) != 0){
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    /**
     * 效率更高，原理是：一个数减1之后与原值相与，二进制最后的1归0
     * @param n
     * @return
     */
    public int NumberOf1II(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();
        System.out.println(test10.NumberOf1I(8));
    }
}
