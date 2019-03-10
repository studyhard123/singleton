package lazy;

//推荐使用
public class InnerClassLazySingleton {
    //默认不加载
    private static class LazyInnerClass {
        private static final InnerClassLazySingleton single = new InnerClassLazySingleton();
    }

    //默认使用LazyInnerClassGeneral的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private InnerClassLazySingleton(){
        if(LazyInnerClass.single != null){
            throw new RuntimeException("不允许存在多个实例");
        }
    }

    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static final InnerClassLazySingleton getInstance(){
        return LazyInnerClass.single;
    }
}
