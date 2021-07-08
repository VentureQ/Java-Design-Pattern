package Design_Pattern.建造者模式;

public class CumputerConcreteBuilder implements ComputerBuilder {
    Computer computer;

    public CumputerConcreteBuilder() {
        computer=new Computer();
    }

    @Override
    public void builderCpu() {
        computer.setCpu("8Core");
    }

    @Override
    public void builderMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void builderDisk() {
        computer.setDisk("1TG");
    }

    @Override
    public Computer builderComputer() {
        return computer;
    }
}
