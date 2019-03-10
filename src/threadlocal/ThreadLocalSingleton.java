package threadlocal;

/*
    该方式的单例是伪单例，在每一个线程中，是单例的，在多个线程中，是多个实例
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> singles = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton(){};

    public static ThreadLocalSingleton getInstance(){
        return singles.get();
    }
}
