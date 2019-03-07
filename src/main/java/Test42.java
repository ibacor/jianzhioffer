public class Test42 {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字啊的顺序不变。
     *
     * 思路：先翻转整个字符串，再翻转单词，节省内存
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0)
            return str;

        char[] c = str.toCharArray();
        reverse(c, 0, str.length() - 1);

        int start = 0;
        int end = 0;

        while(start < c.length){
            if(c[start] == ' '){
                start++;
                end++;
            }else if(end == c.length || c[end] == ' '){
                reverse(c, start, end - 1);
                end++;
                start = end;
            }else{
                end++;
            }
        }
        return new String(c);
    }

    private void reverse(char[] str, int start, int end) {
        if(str == null || start < 0 || end >= str.length || start > end)
            return;

        while(start < end){
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;

            start++;
            end--;
        }
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     *
     * 思路：以n为界，两部分内部翻转，再全局翻转可达到左旋效果
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0 || n > str.length())
            return str;

        char[] c = str.toCharArray();
        reverse(c, 0, n - 1);
        reverse(c, n, c.length - 1);
        reverse(c, 0, c.length - 1);
        return new String(c);
    }
}
