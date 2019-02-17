public class Test11 {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if(exponent == 0 && base == 0)
            throw new RuntimeException("base=0 and exp=0!");
        // 指数=0返回1
        if(exponent == 0)
            return 1;

        double result;
        if(exponent < 0) {
            // 指数小于0取倒数
            result = powerWithUnsignedExponent(base, -exponent);
            result = 1.0 / result;
        }else {
            result = powerWithUnsignedExponent(base, exponent);
        }
        return result;
    }

    /**
     * 求正整数次幂
     * 使用递归、位运算实现，减少乘法次数以及取余运算
     * @param base
     * @param exp
     * @return
     */
    private double powerWithUnsignedExponent(double base, int exp) {
        if(exp == 0)
            return 1;
        if(exp == 1)
            return base;

        double result = powerWithUnsignedExponent(base, exp >> 1);
        // 分成两半
        result *= result;
        // 如果是奇数还要再乘一次
        if((exp & 1) == 1)
            result *= base;
        return result;
    }
}
