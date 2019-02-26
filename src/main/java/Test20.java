import java.util.ArrayList;

public class Test20 {
    private final int toRight = 0, toDown = 1, toLeft = 2, toUp = 3;
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     *
     * 思路是模拟打印路径，从外层一直走
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int l = 0, r = matrix[0].length, d = matrix.length, u = 0;
        int to = toRight;
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(l < r && u < d){
            result.add(matrix[i][j]);
            switch(to){
                case toRight:
                    if(j+1 >= r){
                        to = toDown;
                        i++;
                        u++;
                    }else {
                        j++;
                    }
                    break;
                case toDown:
                    if(i+1 >= d){
                        to = toLeft;
                        j--;
                        r--;
                    }else {
                        i++;
                    }
                    break;
                case toLeft:
                    if(j-1 < l){
                        to = toUp;
                        i--;
                        d--;
                    }else{
                        j--;
                    }
                    break;
                case toUp:
                    if(i-1 < u){
                        to = toRight;
                        j++;
                        l++;
                    }else{
                        i--;
                    }
                    break;
            }
        }
        return result;
    }
}
