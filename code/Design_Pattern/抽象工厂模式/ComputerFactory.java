package Design_Pattern.抽象工厂模式;

public class ComputerFactory extends AbstractFactory{
    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if("Huawei".equals(brand)){
            return new ComputerHuawei();
        }else if("Apple".equals(brand)){
            return new ComputerApple();
        }else {
            return null;
        }
    }
}
