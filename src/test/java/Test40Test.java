import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test40Test {

    @Test
    void findNumsAppearOnce() {
        Test40 test = new Test40();
        int[] a = new int[1];
        int[] b = new int[1];
        int[] r = new int[2];

        test.FindNumsAppearOnce(new int[]{4,6,2,2,3,3,8,8,9,9,1000000,1000000}, a, b);
        r[0] = a[0];r[1] = b[0];
        assertArrayEquals(new int[]{6,4}, r);
    }
}