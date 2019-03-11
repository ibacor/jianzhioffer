/**
 * 单例模式的7种实现方式
 */
public class Test02 {
    // 懒汉式，线程不安全
   public static class Singleton1 {
        private static Singleton1 instance;
        private Singleton1(){}

        public static Singleton1 getInstance(){
            if(instance == null){
                instance = new Singleton1();
            }
            return instance;
        }
    }

    // 懒汉式，线程安全, 效率低
    static class Singleton2{
        private static Singleton2 instance;
        private Singleton2(){}

        public static synchronized Singleton2 getInstance(){
            if(instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }

    // 饿汉式，线程安全，类加载即执行，效率不高
    static class Singleton3{
        private static Singleton3 instance = new Singleton3();
        private Singleton3(){}

        public Singleton3 getInstance(){
            return instance;
        }
    }

    // 饿汉式，变种，线程安全
    static class Singleton4{
        private static Singleton4 instance = null;
        static{
            instance = new Singleton4();
        }

        private Singleton4(){}

        public Singleton4 getInstancen(){
            return instance;
        }
    }

    // 静态内部类
    static class Singleton5{
        private static class SingletonHolder{
            private static Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5(){}

        public static Singleton5 getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }

    // 枚举
    enum Singleton6 {
        INSTANCE;
    }

    // 双重校验锁
    static class Singleton7 {
        private static volatile Singleton7 instance;
        private Singleton7(){}

        public static Singleton7 getInstance(){
            if(instance == null) {
                synchronized(Singleton7.class){
                    if(instance == null)
                        instance = new Singleton7();
                }
            }
            return instance;
        }
    }
}
