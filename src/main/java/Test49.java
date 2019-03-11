public class Test49 {
    /**
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)
     * 数值为0或字符串不符合数字返回0
     * @param str
     * @return
     */
    public int StrToInt(String str){
        if(str == null || str.length() <= 0)
            return 0;

        char first = str.charAt(0);
        if(first == '-')
            return parseString(str, 1, false);
        else if(first == '+')
            return parseString(str, 1, true);
        else if(first >= '0' && first <= '9')
            return parseString(str, 0, true);
        else
            return 0;
    }

    private int parseString(String str, int index, boolean positive) {
        if(index >= str.length())
            return 0;
        int result = 0;
        while(index < str.length()){
            char c = str.charAt(index);
            if(c >= '0' && c <= '9')
                result = result * 10 + c - '0';
            else
                return 0;
            index++;
        }
        if(!positive)
            result = -result;
        return result;
    }
}
