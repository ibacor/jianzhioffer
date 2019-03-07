import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test38Test {

    @Test
    void getNumberOfK() {
        Test38 test = new Test38();
        assertEquals(4, test.GetNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 3));
        assertEquals(4, test.GetNumberOfK(new int[]{1,2,3,3,3,3}, 3));
        assertEquals(4, test.GetNumberOfK(new int[]{3,3,3,3,4,5}, 3));
    }
}