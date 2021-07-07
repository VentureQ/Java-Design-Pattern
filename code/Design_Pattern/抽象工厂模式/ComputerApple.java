package Design_Pattern.抽象工厂模式;

public class ComputerApple implements Computer{

    @Override
    public String internet() {
        return "surf the internet by apple computer";
    }
}

class ComputerHuawei implements Computer{

    @Override
    public String internet() {
        return "surf the internet by Huawei computer";
    }
}