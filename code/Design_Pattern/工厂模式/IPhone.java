package Design_Pattern.工厂模式;

public class IPhone implements Phone{
    @Override
    public String band() {
        return "this is an apple phone!";
    }
}

class Huawei implements Phone{

    @Override
    public String band() {
        return "This is a Huawei phone!!";
    }
}
