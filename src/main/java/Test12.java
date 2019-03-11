public class Test12 {
    /**
     * 打印1到n位数的最大值
     * 解法：即大数问题，使用数组表示
     * @param n
     */
    public void print1ToMaxOfNDigits(int n){
        if(n <= 0)
            throw new RuntimeException("Invalid input!");
        // 使用数组存储大数的每个数
        byte[] number = new byte[n + 1];
        while(number[0] != 1){
            printDigits(number);
            incrementDigit(number);
        }
    }

    private void incrementDigit(byte[] number) {
        int i = number.length - 1;
        number[i]++;
        while(number[i] > 9){
            number[i] = 0;
            i--;
            number[i]++;
        }
    }

    private void printDigits(byte[] number) {
        int index = number.length - 1;
        for (int i = 0; i < number.length; i++) {
            if(number[i] != 0){
                index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < number.length; i++) {
            sb.append(number[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        test12.print1ToMaxOfNDigits(3);
    }
}
