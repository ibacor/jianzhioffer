public class Test53 {
    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        // 两个字符串非空，为true
        if(str == null && pattern == null)
            return true;
        if(str == null || pattern == null)
            return false;
        
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] input, int i, char[] pattern, int p) {

        // 匹配串和模式串都到达尾，说明成功匹配
        if (i >= input.length && p >= pattern.length) {
            return true;
        }

        // 只有模式串到达结尾，说明匹配失败
        if (i != input.length && p >= pattern.length) {
            return false;
        }

        // 模式串未结束，匹配串有可能结束有可能未结束

        // p位置的下一个字符中为*号
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {

            // 匹配串已经结束
            if (i >= input.length) {
                return matchCore(input, i, pattern, p + 2);
            }
            // 匹配串还没有结束
            else {
                if (pattern[p] == input[i] || pattern[p] == '.') {
                    return
                            // 匹配串向后移动一个位置，模式串向后移动两个位置
                            matchCore(input, i + 1, pattern, p + 2)
                                    // 匹配串向后移动一个位置，模式串不移动
                                    || matchCore(input, i + 1, pattern, p)
                                    // 匹配串不移动，模式串向后移动两个位置
                                    || matchCore(input, i, pattern, p + 2);
                } else {
                    return matchCore(input, i, pattern, p + 2);
                }
            }
        }

        //

        // 匹配串已经结束
        if (i >= input.length) {
            return false;
        }
        // 匹配串还没有结束
        else {
            if (input[i] == pattern[p] || pattern[p] == '.') {
                return matchCore(input, i + 1, pattern, p + 1);
            }
        }


        return false;
    }
}
