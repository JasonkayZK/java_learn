package create_prototype_normal;

public class ConcretePrototypeModel2 implements Prototype {

	@Override
	public Prototype clone() {
        // 最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
		Prototype prototype = new ConcretePrototypeModel2();
		return prototype;
	}
}
