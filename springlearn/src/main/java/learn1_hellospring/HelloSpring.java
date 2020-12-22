package learn1_hellospring;

// POJO
public class HelloSpring {
	private String message;

	public void getMessage() {
		System.out.println("Your Message: " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
