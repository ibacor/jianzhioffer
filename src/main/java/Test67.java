public class Test67 {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下
     * 四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        // 使用回溯法
        boolean[][] visited = new boolean[rows][cols];
        return steps(threshold,0,0,visited);
    }

    int steps(int limit, int r, int c, boolean[][] visited){
        if(r<0 || r>=visited.length || c<0 || c>=visited[0].length ||
                visited[r][c] || bitSum(r)+bitSum(c) > limit)
            return 0;
        visited[r][c] = true;
        return steps(limit,r,c-1,visited)+steps(limit,r-1,c,visited)+
                steps(limit,r,c+1,visited)+steps(limit,r+1,c,visited)+1;
    }

    int bitSum(int num){
        int bit=num%10, sum=bit;
        num = num/10;
        while(num != 0){
            bit = num%10;
            sum += bit;
            num /= 10;
        }
        return sum;
    }
}
