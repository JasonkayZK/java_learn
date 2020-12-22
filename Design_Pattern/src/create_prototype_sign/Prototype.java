package create_prototype_sign;

/**
 * 　　抽象原型角色
 * 
 * @author ZK
 *
 */
public interface Prototype {
	public Prototype clone();
	public String getName();
	public void setName(String name);
}
