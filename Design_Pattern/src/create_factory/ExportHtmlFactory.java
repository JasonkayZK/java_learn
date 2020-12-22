package create_factory;

public class ExportHtmlFactory implements ExportFactory {
	
	@Override
	public ExportFile getFactory(String type) {
		if ("standard".equals(type)) {
			return new ExportStandardHtmlFile();
		} else if ("financial".equals(type)) {
			return new ExportFinalcialHtmlFile();
		} else {
			throw new RuntimeException("Object not found!");
		}
	}
	
}
