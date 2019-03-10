package hungry;

/**
 * 优点：1：没有加任何的锁、执行效率比较高
 *      2：线程安全，在线程还没出现以前就是实例化了，不可能存在访问安全问题
 *
 * 缺点：类加载的时候就初始化，浪费内存
 */
public class HungrySingleton {
    private static final HungrySingleton single = new HungrySingleton();//final 变量在并发当中，原理是通过禁止cpu的指令集重排序

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return single;
    }
}
