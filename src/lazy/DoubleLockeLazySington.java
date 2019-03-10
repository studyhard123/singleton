package lazy;

public class DoubleLockeLazySington {
    private volatile static DoubleLockeLazySington single = null;//volatile的作用是禁止cpu的指令集重排序

    private DoubleLockeLazySington(){};

    public static DoubleLockeLazySington getInstance(){
        if(single == null){
            synchronized (DoubleLockeLazySington.class){
                if(single == null){
                    single = new DoubleLockeLazySington();
                }
            }
        }
        return single;
    }
}
