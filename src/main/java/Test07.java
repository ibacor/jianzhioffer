import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Test07 {
    public Test07(){}

    public Test07(int[] a){
        for (int i = 0; i < a.length; i++) {
            stack1.push(a[i]);
        }
    }

    /**
     * 利用栈后进先出的特点，把一个栈的元素倒入另一个栈中即可实现顺序逆转
     * pop时弹出stack2的数据，stack2为空则从stack1中倒入
     * push时推入stack1中
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        // 还没有就抛出异常
        if(stack2.isEmpty())
            throw new RuntimeException("queue is empty!");

        return stack2.pop();
    }
}
