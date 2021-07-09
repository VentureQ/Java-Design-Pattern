package Design_Pattern.适配器模式.对象适配器模式;

public class Test {
    public static void main(String[] args) {
        Typec2Vga2 typec2Vga1 = new Typec2Vga2(new Phone());
        typec2Vga1.vgaInterface();//适配器将typec转换成vga
    }
}
