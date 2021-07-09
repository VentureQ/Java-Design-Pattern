package Design_Pattern.适配器模式.类适配器模式;

public class Typec2Vga1 extends Phone implements Vga{
    @Override
    public void vgaInterface() {
        // TODO Auto-generated method stub
        typecPhone();
        System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
        System.out.println("信息已转换成VGA接口，显示屏可以对接。");
    }
}