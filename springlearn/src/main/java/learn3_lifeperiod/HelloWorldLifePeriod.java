package learn3_lifeperiod;

public class HelloWorldLifePeriod {
	private String message;

	public void getMessage() {
		System.out.println("Your message: " + message);
	}

	public void setMessage(String message) {
		this.message = message;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		System.out.println("Bean is going through init.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		System.out.println("Bean will destory now.");
	}
	
}
