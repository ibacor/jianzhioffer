public class Test54 {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }
        int index = 0;

        if (str[index] == '+' || str[index] == '-') {
            index++;
        }

        // 已经到达字符串的末尾了
        if (index >= str.length) {
            return false;
        }

        boolean numeric = true;
        index = scanDigits(str, index);
        // 还未到字符串的末尾
        if (index < str.length) {
            // 如果是小数点
            if (str[index] == '.') {
                // 移动到下一个位置
                index++;
                index = scanDigits(str, index);

                // 已经到了字符串的末尾了
                if (index >= str.length) {
                    numeric = true;
                }
                // 还未到字符串结束位置
                else if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
                    numeric = isExponential(str, index);
                } else {
                    numeric = false;
                }
            }
            // 如果是指数标识
            else if (str[index] == 'e' || str[index] == 'E') {
                numeric = isExponential(str, index);
            } else {
                numeric = false;
            }

            return numeric;
        }
        // 已经到了字符串的末尾了，说明其没有指数部分
        else {
            return true;
        }
    }

    /**
     * 判断是否是科学计数法的结尾
     * @param str
     * @param index
     * @return
     */
    private boolean isExponential(char[] str, int index) {
        if (index >= str.length || (str[index] != 'e' && str[index] != 'E')) {
            return false;
        }

        // 移动到下一个要处理的位置
        index++;

        // 到达字符串的末尾，就返回false
        if (index >= str.length) {
            return false;
        }

        if (str[index] == '+' || str[index] == '-') {
            index++;
        }

        // 到达字符串的末尾，就返回false
        if (index >= str.length) {
            return false;
        }

        index = scanDigits(str, index);

        // 如果已经处理到了的数字的末尾就认为是正确的指数
        return index >= str.length;
    }

    /**
     * 扫描处理到的数字末尾被认为是正确的指数
     * @param str
     * @param index
     * @return
     */
    private int scanDigits(char[] str, int index) {
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index;
    }
}
