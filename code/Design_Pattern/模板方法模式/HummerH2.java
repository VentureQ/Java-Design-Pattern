package Design_Pattern.模板方法模式;

//悍马H2
public class HummerH2 extends HummerModel {
 
    @Override
    public void start() {
        System.out.println("H2发动……");
    }
 
    @Override
    public void stop() {
        System.out.println("H2停止……");
    }
 
    @Override
    public void alarm() {
        System.out.println("H2鸣笛……");
    }
 
    @Override
    public void engineBoom() {
        System.out.println("H2轰鸣……");
    }
 
    @Override
    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}