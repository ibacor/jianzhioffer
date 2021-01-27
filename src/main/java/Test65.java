import java.util.ArrayDeque;
import java.util.ArrayList;

public class Test65 {
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * input [2,3,4,2,6,2,5,1],3
     * output [4,4,6,6,6,5]
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        // 使用双端队列，队列第一个位置保存当前窗口最大值下标，窗口每滑动一次
        // 1 判断当前最大值是否在窗口内
        // 2 新值从队尾开始插入，丢掉所有比它小的值
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return res;
        }

        int begin;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            } else if (begin > deque.peekFirst()) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (begin >= 0) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
