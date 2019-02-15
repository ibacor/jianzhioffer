import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test07Test {

    @Test
    void push() {
        Test07 empptyQueue = new Test07();
        empptyQueue.push(1);
        empptyQueue.push(2);
        assertEquals(1, empptyQueue.pop());
        empptyQueue.push(3);
        assertEquals(2, empptyQueue.pop());
        assertEquals(3, empptyQueue.pop());

        Test07 queue = new Test07(new int[]{1,2});
        queue.push(3);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
    }

    @Test
    void pop() {
    }
}