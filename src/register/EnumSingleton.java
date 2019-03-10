package register;

import java.io.File;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
    该方式序列化和反射均不能破坏其单例，序列化:详细答案参考ObjectInputStream类的readObject()方法的实现去找，
                                      反射：详细答案参考反射中的Constructor类的newInstance()方法的实现去找，
    其内部的实现原理是: 饿汉式单例

    推荐使用
*/
public enum EnumSingleton {
    INSTANCE;

    private Object single;

    public Object getSingle() {
        return single;
    }

    public void setSingle(Object single) {
        this.single = single;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
