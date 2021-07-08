package Singleton;

public class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance;
    public static DoubleCheckedLocking getInstance(){
        if(instance==null){
            synchronized (DoubleCheckedLocking.class){
                if(instance==null){
                    instance=new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + DoubleCheckedLocking.getInstance().hashCode());
                }
            }).start();
        }
    }
}
