package create_prototype_sign;

/**
 * 
 * 　　具体原型角色1
 * 
 * @author ZK
 *
 */
public class ConcretePrototypeModel1  implements Prototype {
	private String name;

	@Override
	public Prototype clone() {
		ConcretePrototypeModel1 prototype = new ConcretePrototypeModel1();
		prototype.setName(this.name);
		return prototype;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Now in Prototype1, name = " + this.name;
	}
	
}
