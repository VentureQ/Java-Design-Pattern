package Design_Pattern.装饰者模式;

public class Source implements Sourceable{
    @Override
    public void createComputer() {
        System.out.println("create computer by Source.");
    }
}
