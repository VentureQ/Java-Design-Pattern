package Design_Pattern.观察者模式;

public interface Observer {
    //温度、湿度、压强
    void update(float temp,float humidity,float pressure);
}
