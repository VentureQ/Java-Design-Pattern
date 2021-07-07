​		单例模式的设计是保证了一个类在整个系统中同一时刻只有一个实例存在，主要是被用于一个全局类的对象在多个地方被使用并且对象的状态是全局变化的场景下。单例模式为系统资源的优化提供了一个很好的思路，频繁创建和销毁对象都会增加系统的资源消耗，单例模式很好的节约了资源。



:one:不安全类

```java
public class UnsafeLazyInitialization {
    private static UnsafeLazyInitialization instance;

    //加上Synchronized来保证线程安全
    public static UnsafeLazyInitialization getInstance(){
        if(instance==null){
            instance=new UnsafeLazyInitialization();
        }
        return instance;
    }
}
```

:two:懒汉模式，使用Synchronized来将对象实例进行加锁

​		定义一个静态对象***instance***：保证单例对象的唯一性。

```java
public class SafeLazyInitialization {
    private static SafeLazyInitialization instance;

    //加上synchronized来保证线程安全
    public static synchronized SafeLazyInitialization getInstance(){
        if(instance==null){
            instance=new SafeLazyInitialization();
        }
        return instance;
    }
}
```

:three:饿汉模式

​		直接定义一个全局静态对象的实例并初始化，然后提供一个获取该实例对象的方法。

```java
public class HungrySingleton {
    private static HungrySingleton instance=new HungrySingleton();

    //加上synchronized来保证线程安全
    public static  HungrySingleton getInstance(){
       return instance;
    }
}
```

:four:使用静态内部类

```java
public class Static_Class_Singleton {
    private static class SingletonHolder{
        private static final Static_Class_Singleton instance=new Static_Class_Singleton();
    }
    private static final Static_Class_Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
```

:five:双重校验锁

```java
public class DoubleCheckedLocking {
    private static volatile DoubleCheckedLocking instance=null;//此处volatile也是必不可少，防止JVM指令重排
    public static DoubleCheckedLocking getInstance(){
        if(instance==null){//第一次校验，判断是否实例化过，没有实例化过才进⼊加锁代码
            synchronized (DoubleCheckedLocking.class){
                if(instance==null){//第二次校验
                    instance=new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    //创建100个线程验证单例模式
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+DoubleCheckedLocking.getInstance().hashCode());
                }
            }).start();
        }
    }
}
```

**为什么使用双重校验锁实现单例模式呢？**

> **第一次校验**：由于单例模式只要创建一次实例即可，所以当创建了一个实例之后，再次调用getInstance方法就不必要进入同步代码块，不用竞争锁。直接返回前面创建的实例即可。
>
> **第二次校验**：这个校验是防止二次创建实例，假如有一种情况，当singleton还未被创建时，线程t1调用getInstance方法，由于第一次判断singleton==null，此时线程t1准备继续执行，但是由于资源被线程t2抢占了，此时t2页调用getInstance方法，同样的，由于singleton并没有实例化，t2同样可以通过第一个if，然后继续往下执行，同步代码块，第二个if也通过，然后t2线程创建了一个实例singleton。此时t2线程完成任务，资源又回到t1线程，t1此时也进入同步代码块，如果没有这个第二个if，那么，t1就也会创建一个singleton实例，那么，就会出现创建多个实例的情况，但是加上第二个if，就可以完全避免这个多线程导致多次创建实例的问题。
>
> **volatile必不可少**：volatile关键字可以防止jvm指令重排优化
>
> ```tex
> 因为 singleton = new Singleton() 这句话可以分为三步：
>  1. 为 singleton 分配内存空间；
>  2. 初始化 singleton；
>  3. 将 singleton 指向分配的内存空间。
>  但是由于JVM具有指令重排的特性，执行顺序有可能变成 1-3-2。 指令重排在单线程下不会出现问题，但是在多线程下会导致一个线程获得一个未初始化的实例。例如：线程T1执行了1和3，此时T2调用 getInstance() 后发现 singleton 不为空，因此返回 singleton， 但是此时的 singleton 还没有被初始化。
>  使用 volatile 会禁止JVM指令重排，从而保证在多线程下也能正常执行。
> ```
>
> **volatile的第二个作用**：保证多线程运行时的可见性。(**情景**：线程1读取了它在寄存器中的变量拷贝，但是线程2已经将改变的变量刷到主存中了，这就会造成数据的不一致问题。)