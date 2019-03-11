public class Test45 {
    /**
     * 题目：0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始
     * 每次从圆圏里删除第 m 个数字。求出这个圈圈里剩下的最后一个数字。--约瑟夫（Josephuse）环问题
     *
     * 解法一：用环形链表模拟圆圈
     * 解法二：找规律直接计算
     * f(n,m) = 0   n=1
     *        = [f(n-1,m) + m]%n    n>1
     *
     * @param n 排成圆圈的数字个数
     * @param m 第m个数字
     * @return 最后剩下的数字
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;

        int result = 0;
        for (int i = 2; i <=n ; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
