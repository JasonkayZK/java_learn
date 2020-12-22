package create_prototype_sign;

public class ClientModel {
	public static void main(String[] args) {
		try {
			Prototype p1 = new ConcretePrototypeModel1();
			PrototypeManager.setPrototype("p1", p1);
			
			// 获取p1原型来创建新的对象
			Prototype p3 = PrototypeManager.getPrototype("p1").clone();
			p3.setName("张三");
			System.out.println("Example 1: " + p3);
			
			// 有人动态切换了实现
			Prototype p2 = new ConcretePrototypeModel2();
			PrototypeManager.setPrototype("p1", p2);
			
			// 重新获取原型来创建对象
			Prototype p4 = PrototypeManager.getPrototype("p1").clone();
			p4.setName("李四");
			System.out.println("Example 2: " + p4);
			
			// 有人注销了这个原型
			PrototypeManager.removePrototype("p1");
			
			// 再次获取原型来创建对象
			Prototype p5 = PrototypeManager.getPrototype("p1").clone();
			p5.setName("王五");
			System.out.println("Example :" + p5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
