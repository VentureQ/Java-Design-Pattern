​	建造者模式（Builder Pattern）使用多个简单的对象创建一个复杂的对象，用于将一个复杂的构建与其表示分离，使用同样的构建过程可以创建不同的表示，然后通过一个Builder类创建最终的对象。

​		建造者模式主要是为了解决软件系统中复杂对象的创建问题，

**该模式的主要优点如下：**

1. 封装性好，构建和表示分离。
2. 扩展性好，各个具体的建造者相互独立，有利于系统的解耦。
3. 客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。

**其缺点如下：**

1. 产品的组成部分必须相同，这限制了其使用范围。
2. 如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。



定义需要生产的产品：

```java
public class Computer {
    private String cpu;
    private String memory;
    private String disk;
    ...//省略了set、get方法
}
```

定义抽象接口：

```java
public interface ComputerBuilder {
    void builderCpu();
    void builderMemory();
    void builderDisk();
    Computer builderComputer();
}
```

定义ComputerBuilder接口实现类ComputerConcreteBuilder实现构造和装配该产品的各个组件。

```java
public class CumputerConcreteBuilder implements ComputerBuilder {
    Computer computer;

    public CumputerConcreteBuilder() {
        computer=new Computer();
    }

    @Override
    public void builderCpu() {
        computer.setCpu("8Core");
    }

    @Override
    public void builderMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void builderDisk() {
        computer.setDisk("1TG");
    }

    @Override
    public Computer builderComputer() {
        return computer;
    }
}
```

定义ComputerDirector使用Builder接口来实现产品的装配

```java
public class ComputerDirector {
    public Computer constructComputer(ComputerBuilder computerBuilder){
        computerBuilder.builderMemory();
        computerBuilder.builderCpu();
        computerBuilder.builderDisk();
        return computerBuilder.builderComputer();
    }
}
```

构建Computer

```java
public class ComputerDirector {
    public Computer constructComputer(ComputerBuilder computerBuilder){
        computerBuilder.builderMemory();
        computerBuilder.builderCpu();
        computerBuilder.builderDisk();
        return computerBuilder.builderComputer();
    }
}
```







