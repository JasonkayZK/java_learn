package create_factory;

public class ExportPdfFactory implements ExportFactory {

	@Override
	public ExportFile getFactory(String type) {
		if ("standard".equals(type)) {
			return new ExportStandardPdfFile();
		} else if ("financial".equals(type)) {
			return new ExportFinancialPdfFile();
		} else {
			throw new RuntimeException("Object not found!");
		}
	}

}
