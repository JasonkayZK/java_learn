package create_builder;

/**
 * 　抽象建造者类Builder
 * 
 * @author Jasonkay
 *
 */
public interface Builder {
	// 一个产品的两个部件
	public void buildPart1();
	public void buildPart2();
	public Product retriveResult();
}
