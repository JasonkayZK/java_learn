package create_prototype_normal;

public class ConcretePrototypeModel1 implements Prototype {

    // 最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
	@Override
	public Prototype clone() {
		Prototype prototype = new ConcretePrototypeModel1();
		return prototype;
	}
}

