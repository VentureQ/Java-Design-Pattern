package Design_Pattern.装饰者模式;

public class Test {
    public static void main(String[] args) {
        Sourceable source=new Source();
        Sourceable obj=new Decorator(source);
        obj.createComputer();
    }
}
