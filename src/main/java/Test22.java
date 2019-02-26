import java.util.Stack;

public class Test22 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     *
     * 思路：如果下一个弹出数字刚好是栈顶数字，则直接弹出；否则把需要入栈的压入栈。
     * 如果所有数字都压入栈都没找到下一个弹出数字，则该序列不可能是一个弹出序列
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length != popA.length)
            return false;

        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;
        int pushIndex = 0;
        while(popIndex < popA.length) {
            if(stack.isEmpty()){
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }else{
                while(stack.peek() != popA[popIndex]){
                    if(pushIndex < pushA.length)
                        stack.push(pushA[pushIndex]);
                    else
                        return false;
                    pushIndex++;
                }
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
