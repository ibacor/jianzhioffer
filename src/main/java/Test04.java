public class Test04 {
    // 从左往右替换，则每个空格都需要把后面代码往后搬移
    // 优化方法是先遍历字符串，预留位置从后往前赋值
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            if(str.charAt(i) == ' ')
                spaceNum++;
        }
        char[] newStr = new char[strLength + spaceNum*2];
        int index = strLength + spaceNum*2 - 1;
        for (int i = strLength - 1; i >= 0; i--) {
            if(str.charAt(i) != ' ') {
                newStr[index] = str.charAt(i);
            } else{
                newStr[index] = '0';
                newStr[--index] = '2';
                newStr[--index] = '%';
            }
            index--;
        }
        return new String(newStr);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world");
        System.out.println(new Test04().replaceSpace(str));
    }
}
