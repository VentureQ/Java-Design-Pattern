​		适配器模式通过定义一个适配器类作为两个不兼容的接口之间的桥梁，讲一个类的接口转换成用户期望的另一个接口，使得两个或多个原来不兼容的接口可以基于适配器一起工作。

​		适配器模式主要通过适配器类实现各个接口之间的兼容，该类通过依赖注入或者继承实现各个接口的功能并对外同一提供服务。

![img](https://gitee.com/venture_git/PicGo-CloudImg/raw/master/img/20210709223336.png)

​		如图所示，这有一个适配器，一号口是typec口，二号口是vga口，只有将视频信号从typec口输入，转换输出到vga口，才能和投影仪对接，实现手机屏幕投影到投影仪上的任务。涉及的物品有：手机、适配器、投影仪。

- **类适配器模式**

  ​		在不需要改变原有接口或者类结构的情况下扩展类的功能以适配不同的接口时，可以使用类的适配器模式。

  定义一个手机，它有个typec口，这是视频源。

  ```java
  public class Phone {
      public void typecPhone() {
          System.out.println("信息从Typec口的手机输出。");
      }
  }
  ```

  定义一个vga接口

  ```java
  public interface Vga {
      void vgaInterface();
  }
  ```

  通过继承特性来实现适配器功能。

  ```java
  public class Typec2Vga1 extends Phone implements Vga{
      @Override
      public void vgaInterface() {
          // TODO Auto-generated method stub
          typecPhone();
          System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
          System.out.println("信息已转换成VGA接口，显示屏可以对接。");
      }
  }
  ```

  使用类的适配器

  ```java
  public class Test {
      public static void main(String[] args) {
          Vga vga=new Typec2Vga1();
          vga.vgaInterface();
      }
  }
  ```

  

- **对象适配器模式**

  原理：通过组合方式来实现适配器功能。

  ```java
  public class Typec2Vga2 implements Vga{
  
      private Phone phone;
      
      public Typec2Vga2(Phone phone) {
          // TODO Auto-generated constructor stub
          this.phone = phone;
      }
      
      @Override
      public void vgaInterface() {
          // TODO Auto-generated method stub
          if(phone != null) {
              phone.typecPhone();
              System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
              System.out.println("信息已转换成VGA接口，显示屏可以对接。");
          }
      }
  }
  ```

  使用对象适配器

  ```java
  public class Test {
      public static void main(String[] args) {
          Typec2Vga2 typec2Vga1 = new Typec2Vga2(new Phone());
          typec2Vga1.vgaInterface();//适配器将typec转换成vga
      }
  }
  ```

  

- **接口适配器模式**

  原理：借助抽象类来实现适配器功能。

  定义三个接口：

  ```java
  public interface Target {
      void typec();
      void typec2vga();
      void typec2hdmi();
  }
  ```

  定义一个抽象类：

  ```java
  public abstract class Adapter implements Target{
      public void typec() { }
      public void typec2vga() { }
      public void typec2hdmi() { }
  }
  ```

  实现一个VGA适配器：

  ```java
  public class VgaAdapter extends Adapter{
      
      public void typec() {
          System.out.println("信息从Typec口的手机输出。");
      }
      
      public void typec2vga() {
          System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
          System.out.println("信息已转换成VGA接口，显示屏可以对接。");
      }
  }
  ```

  使用接口适配器：

  ```java
  public class Test {
      public static void main(String[] args) {
          VgaAdapter vgaAdapter = new VgaAdapter();
          vgaAdapter.typec();
          vgaAdapter.typec2vga();//适配器将typec转换成vga
      }
  }
  ```

  