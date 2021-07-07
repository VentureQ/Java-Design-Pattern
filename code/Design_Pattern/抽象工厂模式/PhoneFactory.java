package Design_Pattern.抽象工厂模式;

public class PhoneFactory extends AbstractFactory{
    @Override
    public Phone createPhone(String brand) {
        if("Huawei".equals(brand)){
            return new PhoneHuawei();
        }else if("Apple".equals(brand)){
            return new PhoneApple();
        }else {
            return null;
        }
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
