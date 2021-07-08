package Singleton;

public class HungrySingleton {
    private static HungrySingleton instance=new HungrySingleton();

    //加上synchronized来保证线程安全
    public static  HungrySingleton getInstance(){
       return instance;
    }
}
