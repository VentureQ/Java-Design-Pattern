package Design_Pattern.抽象工厂模式;

public abstract class AbstractFactory {
    public abstract Phone createPhone(String brand);
    public abstract Computer createComputer(String brand);
}
