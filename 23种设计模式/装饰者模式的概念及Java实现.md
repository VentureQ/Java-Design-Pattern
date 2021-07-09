​	装饰者模式（Decorator Pattern）是指在无需改变原有类以及类的继承关系的情况下，动态扩展一个类的功能。它通过装饰者来包裹真实的对象，并动态的向对象添加或者撤销功能。

定义Sourceable接口：

```java
public interface Sourceable {
    public void createComputer();
}
```

定义Sourceable接口的实现类：

```java
public class Source implements Sourceable{
    @Override
    public void createComputer() {
        System.out.println("create computer by Source.");
    }
}
```

定义装饰者Decorator类：

```java
public class Decorator implements Sourceable{
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void createComputer() {
        source.createComputer();
        System.out.println("make system.");
    }
}
```

使用装饰者模式：

```java
public class Test {
    public static void main(String[] args) {
        Sourceable source=new Source();
        Sourceable obj=new Decorator(source);
        obj.createComputer();
    }
}
```



