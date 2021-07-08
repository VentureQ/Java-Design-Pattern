package Design_Pattern.建造者模式;

public class ComputerDirector {
    public Computer constructComputer(ComputerBuilder computerBuilder){
        computerBuilder.builderMemory();
        computerBuilder.builderCpu();
        computerBuilder.builderDisk();
        return computerBuilder.builderComputer();
    }
}
