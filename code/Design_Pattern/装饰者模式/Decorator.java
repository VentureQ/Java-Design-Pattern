package Design_Pattern.装饰者模式;

public class Decorator implements Sourceable{
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void createComputer() {
        source.createComputer();
        System.out.println("make system.");
    }
}
