import java.util.Stack;

/**
 * 定义栈的数据结构，栈中
 * 调用pop、push 及min的时间复杂度都是0(1)
 */
public class Test21 {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        data.push(node);
        if(min.size() == 0 || node < min.peek())
            min.push(node);
        else
            min.push(min.peek());
    }

    public void pop() {
        if(data.isEmpty())
            throw new RuntimeException("stack is empty!");
        min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
