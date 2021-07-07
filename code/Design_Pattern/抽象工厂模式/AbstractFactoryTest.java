package Design_Pattern.抽象工厂模式;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory=new PhoneFactory();
        PhoneApple phoneApple= (PhoneApple) factory.createPhone("Apple");
        System.out.println(phoneApple.call());
    }

}
