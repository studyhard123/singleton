package hungry;

public class HungryStaticSington {
    private static final HungryStaticSington single;//final 变量在并发当中，原理是通过禁止cpu的指令集重排序

    static {
        single = new HungryStaticSington();
    }

    private HungryStaticSington(){}

    public static HungryStaticSington getInstance(){
        return single;
    }
}
