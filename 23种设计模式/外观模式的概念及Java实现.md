​		外观模式（Facade Pattern）是指提供了一个统一接口，用来访问子系统中的一群接口，从而让子系统更容易使用。

​		目的是降低访问拥有多个子系统的复杂系统的难度，简化客户端与其之间的接口。

<img src="https://gitee.com/venture_git/PicGo-CloudImg/raw/master/img/20210710161645.png" alt="img" style="zoom: 67%;" />

观看电影需要操作很多电器，使用外观模式实现一键看电影功能。

```java
public class SubSystem {
    public void turnOnTV() {
        System.out.println("turnOnTV()");
    }

    public void setCD(String cd) {
        System.out.println("setCD( " + cd + " )");
    }

    public void startWatching(){
        System.out.println("startWatching()");
    }
}
```

```java
public class Facade {
    private SubSystem subSystem = new SubSystem();

    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("a movie");
        subSystem.startWatching();
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.watchMovie();
    }
}
```

**设计原则：**

最少知识原则：只和你的密友谈话。也就是说客户对象所需要交互的对象应当尽可能少。