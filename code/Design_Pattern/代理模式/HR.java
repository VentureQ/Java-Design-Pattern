package Design_Pattern.代理模式;

public class HR implements Company{
    @Override
    public void findWorker(String title) {
        System.out.println("I need worker,title is:"+title);
    }
}
