package Design_Pattern.适配器模式.接口适配器模式;

public class Test {
    public static void main(String[] args) {
        VgaAdapter vgaAdapter = new VgaAdapter();
        vgaAdapter.typec();
        vgaAdapter.typec2vga();//适配器将typec转换成vga
    }
}
