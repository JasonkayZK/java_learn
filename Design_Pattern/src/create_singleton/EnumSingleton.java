package create_singleton;

/**
 * 单元素的枚举类型已经成为实现Singleton的最佳方法。用枚举来实现单例非常简单，只需要编写一个包含单个元素的枚举类型即可。
 * 
 * 评价：
 *     
 *     　　使用枚举来实现单实例控制会更加简洁，而且无偿地提供了序列化机制，并由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 *     
 * 原因：
 * 
 *    https://blog.csdn.net/whgtheone/article/details/82990139
 *     
 */
public enum EnumSingleton {
	/**
	 * 定义一个枚举的元素， 代表了singleton的一个实例
	 */
	uniqueInstance;
	
	/**
	 * 单例可以有自己的操作
	 */
	public void singletonOperation() {
		System.out.println("EnumSingleton!");
	}
	
}
