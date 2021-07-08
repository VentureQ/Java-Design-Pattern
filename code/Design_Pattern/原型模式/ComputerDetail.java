package Design_Pattern.原型模式;

public class ComputerDetail implements Cloneable{
    private String cpu;
    private String memory;
    private Disk disk;

    public ComputerDetail(String cpu, String memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "ComputerDetail{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk=" + disk +
                '}';
    }

    public Object clone(){
        try {
            ComputerDetail computerDetail= (ComputerDetail) super.clone();
            computerDetail.disk=(Disk) this.disk.clone();
            return computerDetail;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}


class Disk implements Cloneable{
    private String ssd;
    private String hhd;

    public Disk(String ssd, String hhd) {
        this.ssd = ssd;
        this.hhd = hhd;
    }
    public Object clone(){
        try {
            return (Disk)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}