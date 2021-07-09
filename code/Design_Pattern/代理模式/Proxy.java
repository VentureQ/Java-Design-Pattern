package Design_Pattern.代理模式;

import java.util.HashMap;
import java.util.Map;

public class Proxy implements Company {
    private HR hr;

    public Proxy() {
        super();
        this.hr = new HR();
    }

    @Override
    public void findWorker(String title) {//{需要代理的方法}
        hr.findWorker(title);
        String worker = getWorker(title);
        System.out.println("找到的Worker是："+worker);
    }

    private String getWorker(String title) {
        Map<String, String> workList = new HashMap<String, String>(){
            {put("Java", "张三");put("C++", "李四");}
        };
        return workList.get(title);
    }
}
