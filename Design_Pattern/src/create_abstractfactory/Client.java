package create_abstractfactory;

public class Client {

	public static void main(String[] args) {
		ComputerEngineer cf = new ComputerEngineer();
		AbstractFactory af = new IntelFactory();
		cf.makeComputer(af);
	}

}
