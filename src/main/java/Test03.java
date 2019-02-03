public class Test03 {
    // 数组中存在一个规律，从左往右递增、从上往下递增
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
