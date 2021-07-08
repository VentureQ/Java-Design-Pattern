package Singleton;

public class SafeLazyInitialization {
    private static SafeLazyInitialization instance;

    //加上synchronized来保证线程安全
    public static synchronized SafeLazyInitialization getInstance(){
        if(instance==null){
            instance=new SafeLazyInitialization();
        }
        return instance;
    }
}
