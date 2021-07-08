package Design_Pattern.建造者模式;

public interface ComputerBuilder {
    void builderCpu();
    void builderMemory();
    void builderDisk();
    Computer builderComputer();
}
