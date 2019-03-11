public class Test43 {
    /**
     * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
     * 输入骰子个数n，求所有s出现的概率。
     *
     * 思路：基于循环
     * 一个数组第n个数字表示和为n出现第次数，加上新的骰子的和应为
     * n-1,n-2,n-3,n-4,n-5,n-6的次数的总和
     * @param number 骰子个数
     * @return
     */
    public double[] printProbability(int number){
        int max = 6;
        double[] result = new double[max * number - number + 1];
        if(number <= 0)
            return result;

        int[][] prob = new int[2][max * number + 1];
        for (int i = 0; i < max * number + 1; i++) {
            prob[0][i] = 0;
            prob[1][i] = 0;
        }

        // 没加入新的骰子交换数组，通过flag实现
        int flag = 0;
        // 一个骰子的情况
        for (int i = 1; i <= max; i++) {
            prob[flag][i] = 1;
        }

        // 加入新的骰子
        for (int i = 2; i <= number; i++) {
            // 和为[0,i-1]的出现次数为0
            for (int j = 0; j < i; j++) {
                prob[1 - flag][j] = 0;
            }

            // 目前骰子的和的可能
            for (int j = i; j <= max * i; j++) {
                prob[1 - flag][j] = 0;

                // 核心，n等于它前面6个的和
                for (int k = 1; k < j && j <= max; k++) {
                    prob[1 - flag][i] += prob[flag][j - k];
                }
            }
            flag = 1 - flag;
        }

        double total = 1;
        for (int i = 0; i < number; i++) {
            total *= max;
        }

        int maxSum = number * max;
        for (int i = number; i <= maxSum; i++) {
            result[i - number] = prob[flag][i] / total;
        }

        return result;
    }
}
