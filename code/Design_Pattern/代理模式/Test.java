package Design_Pattern.代理模式;

public class Test {
    public static void main(String[] args) {
        Company company=new Proxy();
        company.findWorker("Java");
    }
}
