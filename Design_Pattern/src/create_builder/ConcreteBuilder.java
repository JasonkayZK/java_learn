package create_builder;

public class ConcreteBuilder implements Builder {
	private Product product = new Product();
	
    /**
     * 产品零件建造方法1
     */
	@Override
	public void buildPart1() {
		product.setPart1("Code: 9527");
	}

    /**
     * 产品零件建造方法2
     */
	@Override
	public void buildPart2() {
		product.setPart2("Name: XXX");
	}

	@Override
	public Product retriveResult() {
		return product;
	}
	
}
