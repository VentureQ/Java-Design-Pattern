package Design_Pattern.原型模式;

public class Test {
    public static void main(String[] args) {
        Computer computer=new Computer("8core","16G","1TB");
        Computer computerClone=(Computer) computer.clone();
        Disk disk=new Disk("28G","2TB");

        ComputerDetail computerDetail=new ComputerDetail("12core","64G",disk);
        System.out.println(computerDetail);

        ComputerDetail computerDetailClone=(ComputerDetail) computerDetail.clone();
        System.out.println(computerDetailClone);
    }
}
