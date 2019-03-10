package lazy;

public class UnsafeLazySington {
    private static UnsafeLazySington single = null;

    private UnsafeLazySington(){};

    public static UnsafeLazySington getInstance(){
        if(single == null){
            single = new UnsafeLazySington();
        }
        return single;
    }
}
