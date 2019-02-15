public class Test09 {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;

        int one = 1;
        int two = 1;
        int FN = 0;
        for (int i = 3; i <= n; i++) {
            FN = one + two;
            one = two;
            two = FN;
        }
        return FN;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;

        int one = 1;
        int two = 1;
        int FN = 0;
        for (int i = 2; i <= target; i++) {
            FN = one + two;
            one = two;
            two = FN;
        }
        return FN;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……
     * 它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;
        return 1 << (target - 2) + 1;
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;

        int one = 1;
        int two = 1;
        int FN = 0;
        for (int i = 2; i <= target; i++) {
            FN = one + two;
            one = two;
            two = FN;
        }
        return FN;
    }

    public static void main(String[] args) {
        Test09 test09 = new Test09();
        System.out.println(test09.Fibonacci(3));
        System.out.println(test09.JumpFloor(3));
        System.out.println(test09.JumpFloorII(4));
        System.out.println(test09.RectCover(5));
    }
}
