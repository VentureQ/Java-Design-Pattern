package Design_Pattern.工厂模式;

public class FactoryTest {
    public static void main(String[] args) {
        Factory factory=new Factory();
        Phone huawei=factory.createPhone("Huawei");

    }
}
