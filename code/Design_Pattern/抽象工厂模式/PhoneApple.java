package Design_Pattern.抽象工厂模式;

public class PhoneApple implements Phone{
    @Override
    public String call() {
        return "call somebody by apple phone";
    }
}

class PhoneHuawei implements Phone{

    @Override
    public String call() {
        return "call somebody by huawei phone";
    }
}