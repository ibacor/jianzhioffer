import java.util.ArrayList;

public class Test30 {
    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * 解法一：比第k个数字小的在数组左边，大的在右边，调整后左边则为最小的k个数字（O（n））
     * 需要改变数组
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(input == null || k <= 0 || k > input.length)
            return ans;

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while(index != k-1){
            if(index > k-1){
                end = index - 1;
            }else{
                start = index + 1;
            }
            index = partition(input, start, end);
        }
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    /**
     * 分区算法：比第一个小的在左边，大的在右边
     * @param input 输入数组
     * @param start 开始下标
     * @param end 结束下标
     * @return 分区位置
     */
    int partition(int[] input, int start,int end){
        int tmp = input[start];
        while(start < end){
            while(start < end && input[end] >= tmp)
                end--;
            input[start] = input[end];

            while(start < end && input[start] <= tmp)
                start++;
            input[end] = input[start];
        }
        input[start] = tmp;
        return start;
    }

    /**
     * 解法二：用大小为k的容器保存最小的k个数字
     * 时间复杂度为O(n*logk)，适合处理海量数据
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(input == null || k <= 0 || k > input.length)
            return ans;

        return ans;
    }
}
