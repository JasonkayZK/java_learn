package create_prototype_sign;

/**
 * 
 * 　　具体原型角色2
 * 
 * @author ZK
 *
 */
public class ConcretePrototypeModel2 implements Prototype {
	private String name;

	@Override
	public Prototype clone() {
		ConcretePrototypeModel2 prototype = new ConcretePrototypeModel2();
		prototype.setName(this.name);
		return prototype;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Now in Prototype2, name = " + this.name;
	}
	
}
