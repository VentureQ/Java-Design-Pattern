**概念：**

​		抽象工厂模式在工厂模式上添加了一个创建不同工厂的抽象接口(抽象类或接口实现)，该接口可叫作超级工厂。在使用过程中,我们首先通过抽象接口创建出不同的工厂对象,然后根据不同的工厂对象创建不同的对象。

> 我们可以将工厂模式理解为针对一个产品维度进行分类,比如上述工厂模式下的苹果手机和华为手机;而抽象工厂模式针对的是多个产品维度分类,比如苹果公司既制造苹果手机也制造苹果笔记本电脑,同样,华为公司既制造华为手机也制造华为笔记本电脑。
>
> **==>**我们可以将抽象工厂类比成厂商(苹果、华为)将通过抽象工厂创建出来的工厂类比成不同产品的生产线(手机生成线、笔记本电脑生产线),在需要生产产品时根据抽象工厂生产。



**Java实现**

第一类产品的手机接口及实现类：

```java
//接口
public interface Phone {
    String call();
}


//实现类
public class PhoneApple implements Phone{
    @Override
    public String call() {
        return "call somebody by apple phone";
    }
}

class PhoneHuawei implements Phone{

    @Override
    public String call() {
        return "call somebody by huawei phone";
    }
}
```

第二类产品的电脑接口及实现类：

```java
//接口
public interface Computer {
    String internet();
}

//实现类
public class ComputerApple implements Computer{

    @Override
    public String internet() {
        return "surf the internet by apple computer";
    }
}

class ComputerHuawei implements Computer{

    @Override
    public String internet() {
        return "surf the internet by Huawei computer";
    }
}
```

创建抽象工厂类：

```java
public abstract class AbstractFactory {
    public abstract Phone createPhone(String brand);
    public abstract Computer createComputer(String brand);
}
```

创建第一类产品手机的工厂类：

```java
public class PhoneFactory extends AbstractFactory{
    @Override
    public Phone createPhone(String brand) {
        if("Huawei".equals(brand)){
            return new PhoneHuawei();
        }else if("Apple".equals(brand)){
            return new PhoneApple();
        }else {
            return null;
        }
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
```

创建第二类产品电脑的工厂类：

```java
public class ComputerFactory extends AbstractFactory{
    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if("Huawei".equals(brand)){
            return new ComputerHuawei();
        }else if("Apple".equals(brand)){
            return new ComputerApple();
        }else {
            return null;
        }
    }
}
```

抽象工厂类的使用：

```java
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory=new PhoneFactory();
        PhoneApple phoneApple= (PhoneApple) factory.createPhone("Apple");
        System.out.println(phoneApple.call());
    }
}
```

