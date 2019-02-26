import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test24Test {

    @Test
    void verifySquenceOfBST() {
        Test24 test = new Test24();

        int[] a = {5,7,8,9,11,10,8};
        assertTrue(test.VerifySquenceOfBST(a));

        int[] b = {7,4,6,5};
        assertFalse(test.VerifySquenceOfBST(b));
    }
}