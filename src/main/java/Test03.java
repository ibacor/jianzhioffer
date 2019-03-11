public class Test03 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 思路；
     *      数组中存在一个规律，从左往右递增、从上往下递增
     * @param matrix
     * @param number
     * @return
     */
    public static boolean find(int[][] matrix, int number){
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == number)
                return true;
            if(matrix[row][col] < number)
                row++;
            else if(matrix[row][col] > number)
                col--;
        }
        return false;
    }
}
