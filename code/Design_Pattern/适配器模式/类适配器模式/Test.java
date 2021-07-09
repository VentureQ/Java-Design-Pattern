package Design_Pattern.适配器模式.类适配器模式;

public class Test {
    public static void main(String[] args) {
        Vga vga=new Typec2Vga1();
        vga.vgaInterface();
    }
}
