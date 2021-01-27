import java.util.Arrays;
import java.util.Comparator;

public class Test33 {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) {
            return "";
        }

        String[] numStr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numStr,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String t1 = s1+s2;
                String t2 = s2+s1;
                return t1.compareTo(t2);
            }
        });
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<numbers.length;i++){
            sb.append(numStr[i]);
        }
        return sb.toString();
    }
}
