import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test20Test {

    @Test
    void printMatrix() {
        Test20 test20 = new Test20();
        // 正常输入
        int[][] a = {{1,2,3}, {4,5,6},{7,8,9}};
        assertArrayEquals(new int[]{1,2,3,6,9,8,7,4,5},
                util.list2IntArray(test20.printMatrix(a)));

        // 只有行
        int[][] b = {{1,2,3}};
        assertArrayEquals(new int[]{1,2,3}, util.list2IntArray(test20.printMatrix(b)));

        // 只有列
        int[][] c = {{1}, {2}, {3}};
        assertArrayEquals(new int[]{1,2,3}, util.list2IntArray(test20.printMatrix(c)));

        // 只有一个
        int[][] d = {{1}};
        assertArrayEquals(new int[]{1}, util.list2IntArray(test20.printMatrix(d)));
    }
}