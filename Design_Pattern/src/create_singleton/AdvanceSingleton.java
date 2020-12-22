package create_singleton;

/**
 * 1. 什么是类级内部类？

　　简单点说，类级内部类指的是，有static修饰的成员式内部类。如果没有static修饰的成员式内部类被称为对象级内部类。

　　类级内部类相当于其外部类的static成分，它的对象与外部类对象间不存在依赖关系，因此可直接创建。而对象级内部类的实例，是绑定在外部对象实例中的。

　　类级内部类中，可以定义静态的方法。在静态方法中只能够引用外部类中的静态成员方法或者成员变量。

　　类级内部类相当于其外部类的成员，只有在第一次被使用的时候才被会装载。

 * 2. 多线程缺省同步锁的知识

　　大家都知道，在多线程开发中，为了解决并发问题，主要是通过使用synchronized来加互斥锁进行同步控制。但是在某些情况中，JVM已经隐含地为您执行了同步，这些情况下就不用自己再来进行同步控制了。这些情况包括：

	　　1.由静态初始化器（在静态字段上或static{}块中的初始化器）初始化数据时
	
	　　2.访问final字段时
	
	　　3.在创建线程之前创建对象时
	
	　　4.线程可以看见它将要处理的对象时
 * 
 * 
 * 解决方案的思路

　　要想很简单地实现线程安全，可以采用静态初始化器的方式，它可以由JVM来保证线程的安全性。比如前面的饿汉式实现方式。但是这样一来，不是会浪费一定的空间吗？因为这种实现方式，会在类装载的时候就初始化对象，不管你需不需要。

　　如果现在有一种方法能够让类装载的时候不去初始化对象，那不就解决问题了？一种可行的方式就是采用类级内部类，在这个类级内部类里面去创建对象实例。这样一来，只要不使用到这个类级内部类，那就不会创建对象实例，从而同时实现延迟加载和线程安全。
 * 
 * 评价：
 * 
 * 当getInstance方法第一次被调用的时候，它第一次读取SingletonHolder.instance，导致SingletonHolder类得到初始化；而这个类在装载并被初始化的时候，会初始化它的静态域，从而创建Singleton的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。

　　这个模式的优势在于，getInstance方法并没有被同步，并且只是执行一个域的访问，因此延迟初始化并没有增加任何访问成本。
 * 
 * 
 * @author ZK
 *
 */
public class AdvanceSingleton {
	private AdvanceSingleton() {}
	
	/**
	 * 类级的内部类， 即静态的成员式内部类， 该内部类的实例与外部类的
	 * 
	 * 实例没有绑定关系， 而且只有被调用时才会被装载， 从而实现了延时加载
	 */
	private static class SingletonHolder {
		/**
		 * 静态初始化器，由JVM来保证线程安全
		 */
		private static AdvanceSingleton instance = new AdvanceSingleton();
	}
	
	@Override
	public String toString() {
		return "AdvanceSingleton!";
	}
	
	public static AdvanceSingleton getInstance() {
		return SingletonHolder.instance;
	}
	
}
