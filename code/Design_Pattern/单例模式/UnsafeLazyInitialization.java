package Singleton;

//1.懒汉模式
public class UnsafeLazyInitialization {
    private static UnsafeLazyInitialization instance;

    //加上Synchronized来保证线程安全
    public static UnsafeLazyInitialization getInstance(){
        if(instance==null){
            instance=new UnsafeLazyInitialization();
        }
        return instance;
    }

}
