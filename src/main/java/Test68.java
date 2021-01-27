public class Test68 {
    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段
     * （m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度
     * 记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积
     * 是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的
     * 三段，此时得到的最大乘积是18。
     */
    public int cutRope(int target) {
        // 找规律
        /**
        * 4 ： 2*2
        * 5 ： 2*3
        * 6 ： 3*3
        * 7 ： 2*2*3 或者4*3
        * 8 ： 2*3*3
        * 9 ： 3*3*3
        * 10：2*2*3*3 或者4*3*3
        * 11：2*3*3*3
        * 12：3*3*3*3
        * 13：2*2*3*3*3 或者4*3*3*3
         * */
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }

        if (target % 3 == 0) {
            return (int) Math.pow(3, target / 3);
        } else if (target % 3 == 1) {
            return 4 * (int) Math.pow(3, target / 3 - 1);
        } else {
            return 2 * (int) Math.pow(3, target / 3);
        }
    }
}
