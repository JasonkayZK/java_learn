package learn4_postprocessor;

public class HelloWorldPostProcessor {
	private String message;

	public void getMessage() {
		System.out.println("Your message: " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("Bean is going through init.");
	}
	
	public void destroy() {
		System.out.println("Bean will destory now.");
	}
}
