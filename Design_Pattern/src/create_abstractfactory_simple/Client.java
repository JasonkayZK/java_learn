package create_abstractfactory_simple;

public class Client {
	public static void main(String[] args) {
		ComputerEngineer cf = new ComputerEngineer();
		cf.makeComputer(1, 2);
	}
}
