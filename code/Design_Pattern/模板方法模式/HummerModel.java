package Design_Pattern.模板方法模式;

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