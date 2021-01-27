public class Test66 {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
     * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 回溯搜索
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isHasPath(matrix, i, j, rows, cols, visited, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isHasPath(char[] matrix, int i, int j, int rows, int cols, boolean[] visited, char[] str, int k) {
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || visited[index]) {
            return false;
        }

        if (k == str.length - 1) {
            return true;
        }

        visited[index] = true;
        if (isHasPath(matrix, i - 1, j, rows, cols, visited, str, k + 1) ||
                isHasPath(matrix, i + 1, j, rows, cols, visited, str, k + 1) ||
                isHasPath(matrix, i, j - 1, rows, cols, visited, str, k + 1) ||
                isHasPath(matrix, i, j + 1, rows, cols, visited, str, k + 1)) {
            return true;
        }

        visited[index] = false;
        return false;
    }
}
