​		模板方法模式定义了一个算法框架，并通过继承的方式将算法的实现延迟到子类中，使得子类可以在不改变算法框架及流程的前提下重新定义该算法在某些特定环节的实现。

![img](https://gitee.com/venture_git/PicGo-CloudImg/raw/master/img/20210712150131.jpeg)

​		模板方法模式确实很简单，仅仅使用了java的继承机制，但是它是一个应用非常广泛的模式，其中AbstractClass叫做抽象模板，它的方法分为两类：基本方法（由子类去实现）和模板方法（可以有一个或多个，也就是一个框架，实现对基本方法的调度，完成固定的逻辑）。为了防止恶意的操作，一般模板方法上都添加上final关键字，不允许被覆写。我们来看一下AbstractClass模板：

```java
public abstract class AbstractClass {
	//基本方法
	protected abstract void doSomething();
	protected abstract void doAnything();
	//模板方法
	public void templateMethod() {
		//调用基本方法，完成相关的逻辑
		this.doAnything();
		this.doSomething();
	}
}
```

**优点：**

> 1）封装不变部分，扩展可变部分：把认为不变部分的算法封装到父类实现，可变部分则可以通过继承来实现，很容易扩展。
>
> 2）提取公共部分代码，便于维护：上面悍马的例子就是个很好的解释。
>
> 3）行为由父类控制，由子类实现。

  **缺点：**

> 模板方法模式颠倒了我们平常的设计习惯：抽象类负责声明最抽象、最一般的事物属性和方法，实现类实现具体的事物属性和方法。在复杂的项目中可能会带来代码阅读的难度。



​		我们先来看一个例子：假如现在老板让你做一个汽车的模型，要求只要完成基本功能即可，不考虑扩展性，那你会怎么做呢？我们首先会根据经验设计一个类图：

<img src="https://gitee.com/venture_git/PicGo-CloudImg/raw/master/img/20210712142902.jpeg" alt="img" style="zoom: 67%;" />

​		由这个类图可知，非常简单的实现了悍马车，该车有两个型号H1和H2。那现在我们开始实现这两个型号的悍马车，首先我们得把抽象类写好，然后两个不同的模型实现类通过简单的继承就可以实现要求。首先看看抽象类的代码：

```java
public abstract class HummerModel {
	public abstract void start(); //发动
	public abstract void stop();  //停止
	public abstract void alarm(); //鸣笛
	public abstract void engineBoom(); //轰鸣
	public abstract void run(); //车总归要跑
}
```

实现两个悍马的模型：

```java
//悍马H1
public class HummerH1 extends HummerModel {
 
	@Override
	public void start() {
		System.out.println("H1发动……");
	}
 
	@Override
	public void stop() {
		System.out.println("H1停止……");
	}
 
	@Override
	public void alarm() {
		System.out.println("H1鸣笛……");
	}
 
	@Override
	public void engineBoom() {
		System.out.println("H1轰鸣……");
	}
 
	@Override
	public void run() {
		this.start();
		this.engineBoom();
		this.alarm();
		this.stop();
	}
}
 
//悍马H2
public class HummerH2 extends HummerModel {
 
    @Override
    public void start() {
        System.out.println("H2发动……");
    }
 
    @Override
    public void stop() {
        System.out.println("H2停止……");
    }
 
    @Override
    public void alarm() {
        System.out.println("H2鸣笛……");
    }
 
    @Override
    public void engineBoom() {
        System.out.println("H2轰鸣……");
    }
 
    @Override
    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
```

​		很明显，已经发现代码有点问题了，两个悍马的run方法完全相同。所以这个run方法应该出现在抽象类中，不应该在实现类中，抽象是所有子类的共性封装。所以我们修改一下抽象类：

```java
public abstract class HummerModel {
	public abstract void start(); //发动
	public abstract void stop();  //停止
	public abstract void alarm(); //鸣笛
	public abstract void engineBoom(); //轰鸣
	public void run() { //车总归要跑
		this.start();
		this.engineBoom();
		this.alarm();
		this.stop();
	}
}
```

 这样两个实现类就不用实现run方法了，可以直接拿来用。其实，这就是模板方法模式。