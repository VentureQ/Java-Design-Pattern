package Design_Pattern.原型模式;

//浅复制
public class Computer implements Cloneable{
    private String cpu;
    private String memory;
    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }

    public Object clone(){
        try {
            return (Computer)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
