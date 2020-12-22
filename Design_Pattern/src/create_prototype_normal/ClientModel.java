package create_prototype_normal;

public class ClientModel {
	/**
	 * 持有需要使用的原型接口对象
	 */
	private Prototype prototype;
	
	/**
	 * 构造方法， 传入需要使用的原型接口对象
	 */
	public ClientModel(Prototype prototype) {
		this.prototype = prototype;
	}
	
	public void operation(Prototype example) {
        // 需要创建原型接口的对象
		Prototype copyPrototype = (Prototype) prototype.clone();
	}
}
