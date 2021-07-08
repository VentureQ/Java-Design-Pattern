package Singleton;

public class Static_Class_Singleton {
    private static class SingletonHolder{
        private static final Static_Class_Singleton instance=new Static_Class_Singleton();
    }
    private static final Static_Class_Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
