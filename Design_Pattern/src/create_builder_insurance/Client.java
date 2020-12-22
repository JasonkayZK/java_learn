package create_builder_insurance;

public class Client {

	public static void main(String[] args) {
		InsuranceContract.ConcreteBuilder builder = new InsuranceContract.ConcreteBuilder("#9527", 123L, 456L);
		InsuranceContract contract = builder.setPersonName("Jasonkay").setOtherData("test").build();
		contract.someOperation();
	}

}
