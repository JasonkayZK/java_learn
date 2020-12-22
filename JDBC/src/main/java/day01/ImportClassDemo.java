package day01;

public class ImportClassDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("OK!");
		
	}

}
