import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test02Test {

    @Test
    private void testSingleton1(){
        final Test02.Singleton1[] singleton1s = new Test02.Singleton1[100];
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    singleton1s[finalI] = Test02.Singleton1.getInstance();
                }
            }).start();
        }
        try {
            Thread.sleep(200);
            for (int i = 1; i < 100; i++) {
                assertSame(singleton1s[0], singleton1s[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}