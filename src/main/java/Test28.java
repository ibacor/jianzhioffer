import java.util.ArrayList;
import java.util.HashSet;

public class Test28 {
    HashSet<String> result;
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        result = new HashSet<String>();
        if(str == null || str.length() == 0)
            return new ArrayList<String>();

        char[] chars = str.toCharArray();
        permutation(chars, 0);
        return  new ArrayList<String>(result);
    }

    private void permutation(char[] chars, int begin) {
        if(begin == chars.length - 1)
            result.add(new String(chars));
        else {
            for (int i = begin; i < chars.length; i++) {
                if(chars[i] != chars[begin]) {
                    char temp = chars[i];
                    chars[i] = chars[begin];
                    chars[begin] = temp;
                    permutation(chars, begin+1);
                }
                if(i == begin)
                    permutation(chars, begin+1);
            }
        }
    }
}
