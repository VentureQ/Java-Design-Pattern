#### 1.工厂模式的概念及Java实现

**概念**

​		工厂模式提供了一种简单、快捷、高效且安全的创建对象的方式。工厂模式在接口中定义了创建对象的方法，而将具体的创建对象的过程在子类中实现，用户只需要通过接口创建需要的对象即可，不用关注对象的创建过程。并且用户还可以根据需求灵活实现创建对象的不同方法。

> 通俗的讲：工厂模式的本质就是用工厂方法代替new操作创建一个实例化对象的方式，以提供一种方便的创建有同种类型的产品的复杂对象。

**Java实现**

创建手机接口：

​		以创建手机实例为例子，假设手机有很多品牌，华为、苹果、小米等，我们要实现根据不同的传入参数创建不同的手机实例。

定义接口：

```java
public interface Phone {
    String band();
}
```

定义实现类：

​		定义了两个实现类，通过brand函数来打印自己的手机品牌。

```java
public class IPhone implements Phone{
    @Override
    public String band() {
        return "this is an apple phone!";
    }
}

class Huawei implements Phone{

    @Override
    public String band() {
        return "This is a Huawei phone!!";
    }
}

```

定义工厂类：

​		工厂类中定义了一个createPhone方法，用来根据传入的不同参数实例化不同品牌的手机类并返回。这样，对与调用者来说就屏蔽了实例化的细节。

```java
public class Factory {
    public Phone createPhone(String phoneName){
        if("Huawei".equals(phoneName)){
            return new Huawei();
        }
        else if("apple".equals(phoneName)){
            return new IPhone();
        }else{
            return null;
        }
    }
}
```

