public class Test52 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if(A == null || A.length < 2)
            return null;

        int[] result = new int[A.length];
        // 第一步，每个result[i]保存A[0]A[1]...A[i-1]
        result[0] = 1;
        for (int i = 1; i < A.length; i++) {
            result[i] = A[i-1] * result[i - 1];
        }
        // 使用temp保存A[n-1]*A[n-1]...A[i+1]
        int temp = 1;
        // 第二步，计算剩下的部分
        for (int i = A.length - 1; i > 0; i--) {
            temp *= A[i];
            result[i - 1] *= temp;
        }

        return result;
    }
}
