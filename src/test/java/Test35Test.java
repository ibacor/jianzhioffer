import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test35Test {

    @Test
    void firstNotRepeatingChar() {
        Test35 test = new Test35();
        assertEquals(4, test.FirstNotRepeatingChar("google"));
    }
}