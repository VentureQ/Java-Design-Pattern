package Design_Pattern.建造者模式;

public class ConcreteBuilderTest {
    public static void main(String[] args) {
        ComputerDirector computerDirector=new ComputerDirector();
        ComputerBuilder computerConcreteBuilder=new CumputerConcreteBuilder();
        Computer computer=computerDirector.constructComputer(computerConcreteBuilder);
        System.out.println(computer.getCpu());
    }
}
