代理模式是指为对象提供一种通过代理方式来访问并控制对象行为的方法。在客户端不不适合或者不能够直接引用一个对象时，可以通过该对象的代理来实现对该对象的访问，可以将该代理对象理解为客户端和目标对象之间的中介者。

定义Company接口：

```java
public interface Company {
    void findWorker(String title);
}
```

Company接口的实现类HR：

```java
public class HR implements Company{
    @Override
    public void findWorker(String title) {
        System.out.println("I need worker,title is:"+title);
    }
}
```

定义Proxy：

```java
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
        System.out.println(worker);
    }

    private String getWorker(String title) {
        Map<String, String> workList = new HashMap<String, String>(){
            {put("Java", "张三");put("C++", "李四");}
        };
        return workList.get(title);
    }
}
```

代理模式使用：

```java
public class Test {
    public static void main(String[] args) {
        Company company=new Proxy();
        company.findWorker("Java");
    }
}
```

