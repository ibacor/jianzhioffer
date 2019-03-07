import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test36Test {

    @Test
    void inversePairs() {
        Test36 test = new Test36();
        assertEquals(3, test.InversePairs(new int[]{1,2,3,4,7,6,5}));
        assertEquals(15, test.InversePairs(new int[]{6,5,4,3,2,1}));
        assertEquals(0, test.InversePairs(new int[]{1}));
        assertEquals(3, test.InversePairs(new int[]{1,2,1,2,1}));
    }
}