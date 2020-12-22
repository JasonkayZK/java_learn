package create_abstractfactory;

public class AmdFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new IntelCpu(938);
	}

	@Override
	public Mainboard createMainboard() {
		return new IntelMainboard(938);
	}

}
