import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test14Test {

    @Test
    void reOrderArray() {
        Test14 test14 = new Test14();
        // 奇数、偶数交替出现
        int[] a1 = {1,2,3,4,5};
        test14.reOrderArray(a1);
        assertArrayEquals(new int[]{1,3,5,2,4}, a1);
        // 所有奇数在偶数前
        int[] a2 = {1,3,5,2,4};
        test14.reOrderArray(a2);
        assertArrayEquals(new int[]{1,3,5,2,4}, a2);
        // 所有偶数在奇数前
        int[] a3 = {2,4,1,3,5};
        test14.reOrderArray(a3);
        assertArrayEquals(new int[]{1,3,5,2,4}, a3);

        // 边界测试
        int[] a4 = null;
        test14.reOrderArray(a4);
        assertNull(a4);

        int[] a5 = {1};
        test14.reOrderArray(a5);
        assertArrayEquals(new int[]{1}, a5);
    }
}