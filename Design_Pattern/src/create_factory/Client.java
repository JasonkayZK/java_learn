package create_factory;

public class Client {

	public static void main(String[] args) {
		String data = "";
		ExportFactory exportFactory = new ExportHtmlFactory();
		ExportFile ef = exportFactory.getFactory("financial");
		ef.export(data);
	}

}
