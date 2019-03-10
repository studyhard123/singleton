package register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Spring中的做法，就是用这种注册式单例,线程安全的【不加synchronized还是不安全的，因此本质上是存在线程安全问题】，本质是：懒加载
//优点：对象方便管理，
public class ContainerSingleton {
    private static Map<String,Object> singles = new ConcurrentHashMap<>();

    private ContainerSingleton(){};

    public static Object getInstance(String className){
        synchronized (singles){
            if(!singles.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    singles.put(className,obj);//安全的，因为currentHashMap安全只是对内部的元素安全
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }else{
                return singles.get(className);
            }
        }
    }
}
