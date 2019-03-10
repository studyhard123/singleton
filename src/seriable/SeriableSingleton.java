package seriable;

import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SeriableSingleton implements Serializable {

    private static final SeriableSingleton single = new SeriableSingleton();

    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return single;
    }

    //为了解决序列化单例在反序列化的时候，出现单例被迫坏情况，详细答案参考ObjectInputStream类的readObject()方法的实现去找
    private Object readResolve(){
        return single;
    }
}
