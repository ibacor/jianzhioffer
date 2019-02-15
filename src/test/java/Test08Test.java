import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class Test08Test {

    @Test
    void minNumberInRotateArray() {
        normalTest();
        borderInput();
        specialInput();
    }

    void normalTest(){
        Test08 test08 = new Test08();
        int[] array1 = {3,4,5,1,2};
        int res1 = test08.minNumberInRotateArray(array1);
        assertEquals(1, res1);

        // 有重复数字
        int[] array2 = {3,3,4,5,1,1,2};
        int res2 = test08.minNumberInRotateArray(array2);
        assertEquals(1, res2);
    }

    void borderInput(){
        Test08 test08 = new Test08();
        // 顺序情况
        int[] array1 = {1,2,3,4,5};
        int res1 = test08.minNumberInRotateArray(array1);
        assertEquals(1, res1);

        int[] array2 = {3};
        int res2 = test08.minNumberInRotateArray(array2);
        assertEquals(3, res2);

        // 首尾相同情况
        int[] array3 = {1,2,3,4,5,1};
        int res3 = test08.minNumberInRotateArray(array3);
        assertEquals(1, res3);
        // 首尾相同中间也相同情况
        int[] array4 = {1,0,1,1,1};
        int res4 = test08.minNumberInRotateArray(array4);
        assertEquals(0, res4);
    }

    void specialInput(){
        final Test08 test08 = new Test08();
        assertThrows(RuntimeException.class, new Executable() {
            public void execute() throws Throwable {
                test08.minNumberInRotateArray(null);
            }
        });
        assertEquals(0, test08.minNumberInRotateArray(new int[0]));
    }
}