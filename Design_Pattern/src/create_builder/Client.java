package create_builder;

public class Client {

	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.construct();
		
		Product product = builder.retriveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}

}
