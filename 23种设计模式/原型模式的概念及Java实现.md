​	原型模式是指通过调用原型实例的clone方法或其他手段来创建对象。

​		原型模式的Java实现很简单，只需要原型类实现Cloneable接口并覆写clone方法就可以。

- 浅拷贝：

  ​		Java中的浅拷贝是通过实现Cloneable接口并覆写其clone方法实现的。在浅拷贝的过程中，对象的基本类型的变量值会重新被复制并创建，但是引用类型数据仍然指向原对象的引用。也就是说，**浅拷贝不复制对象的引用类型数据**。

- 深拷贝：

  ​		深拷贝在复制的过程中，不论是基本类型还是引用类型都会被重新复制和创建。也就是说，**深拷贝彻底复制了对象的数据**。

浅拷贝代码实现：

```java
//浅拷贝
public class Computer implements Cloneable{
    private String cpu;
    private String memory;
    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public Object clone(){
        try {
            return (Computer)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

深拷贝代码实现：

```java
package Design_Pattern.原型模式;
//深拷贝
public class ComputerDetail implements Cloneable{
    private String cpu;
    private String memory;
    private Disk disk;

    public ComputerDetail(String cpu, String memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public Object clone(){
        try {
            ComputerDetail computerDetail= (ComputerDetail) super.clone();
            computerDetail.disk=(Disk) this.disk.clone();
            return computerDetail;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}


class Disk implements Cloneable{
    private String ssd;
    private String hhd;

    public Disk(String ssd, String hhd) {
        this.ssd = ssd;
        this.hhd = hhd;
    }
    public Object clone(){
        try {
            return (Disk)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

上面定义了两个类，其中ComputerDetail的disk属性是一个引用对象，要实现这种对象的复制，就要使用深拷贝技术，具体操作是引用对象类需要实现Cloneable接口并覆写clone方法，然后在复杂对象中声明式的将引用对象复制出来赋值给引用对象属性

```java
computerDetail.disk=(Disk) this.disk.clone();
```

使用原型模式：

```java
public class Test {
    public static void main(String[] args) {
        Computer computer=new Computer("8core","16G","1TB");
        Computer computerClone=(Computer) computer.clone();
        Disk disk=new Disk("28G","2TB");

        ComputerDetail computerDetail=new ComputerDetail("12core","64G",disk);
        System.out.println(computerDetail);

        ComputerDetail computerDetailClone=(ComputerDetail) computerDetail.clone();
        System.out.println(computerDetailClone);
    }
}
```

