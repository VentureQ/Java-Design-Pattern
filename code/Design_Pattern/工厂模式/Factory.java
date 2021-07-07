package Design_Pattern.工厂模式;

public class Factory {
    public Phone createPhone(String phoneName){
        if("Huawei".equals(phoneName)){
            return new Huawei();
        }
        else if("apple".equals(phoneName)){
            return new IPhone();
        }else{
            return null;
        }
    }
}
