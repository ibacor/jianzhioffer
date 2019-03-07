import java.util.HashMap;

public class Test35 {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : chars) {
            Integer i = map.get(c);
            if (i == null)
                map.put(c, 1);
            else
                map.put(c, i + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }
}
