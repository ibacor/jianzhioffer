import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Test64 {
    /**
     * 使用最大堆和最小堆保持大小排序
     * 奇数位置放入最小堆，偶数位置放入最大堆，最终个数为奇数时取最小堆root，为偶数时取最小堆和最大堆root的平均数
     */

    private int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,new Comparator<Integer>(){
        public int compare(Integer i1,Integer i2){
            return i2 - i1;
        }
    });

    public void Insert(Integer num) {
        if(count%2 == 0){
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        }else{
            minHeap.offer(num);
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2 == 0){
            return new Double((minHeap.peek() + maxHeap.peek()))/2;
        }else
            return new Double(minHeap.peek());
    }

}
