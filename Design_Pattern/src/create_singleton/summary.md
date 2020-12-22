http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html

单例模式：
    作为对象的创建模式，单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
    这个类称为单例类。

单例模式的结构
　　单例模式的特点：

    单例类只能有一个实例。
    单例类必须自己创建自己的唯一实例。
    单例类必须给所有其他对象提供这一实例。

分类：
	1. 饿汉式： EagerSingleton
	
	2. 懒汉式： LazySingleton
	
	3. 懒汉式-双重检查加锁： Singleton ****
	
	4. 延迟加载和线程安全: Lazy initialization holder class模式 ****
	
	5. 单例和枚举： EnumSingleton *****
	