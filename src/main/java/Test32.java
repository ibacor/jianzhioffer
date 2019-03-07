public class Test32 {
    /**
     * 输入一个整数n求从1 到n这n个整数的十进制表示中1 出现的次数。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;

        int[] c = new int[n];
        return numberOf1(c, 0);
    }

    private int numberOf1(int[] n, int index) {
        return 0;
    }
}
