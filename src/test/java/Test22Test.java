import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test22Test {

    @Test
    void isPopOrder() {
        Test22 test = new Test22();
        int[] push1 = {1,2,3,4,5,};
        int[] pop1 = {4,5,3,2,1};
        assertTrue(test.IsPopOrder(push1, pop1));

        int[] push2 = push1;
        int[] pop2 = {4,3,5,1,2};
        assertFalse(test.IsPopOrder(push2, pop2));

        int[] push3 = {1};
        int[] pop3 = {1};
        assertTrue(test.IsPopOrder(push3, pop3));

        assertFalse(test.IsPopOrder(null, null));
    }
}