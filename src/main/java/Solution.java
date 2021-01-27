public class Solution {
    public String interpret(String command) {
        if (command == null || "".equals(command)) {
            return "";
        }

        char[] chars = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            switch(chars[i]) {
                case 'G':
                    sb.append("G");
                    i++;
                    break;
                case '(':
                    if (chars[i+1] == ')') {
                        sb.append("o");
                        i += 2;
                    } else if (chars[i+1]=='a' && chars[i+2]=='l') {
                    sb.append("al");
                    i += 4;
                }
                break;
            }
        }
        return sb.toString();
    }
}
