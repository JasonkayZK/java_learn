package learn3_lifeperiod;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorldLifePeriod obj = (HelloWorldLifePeriod) context.getBean("learn3_helloWorldLifePeriod");
		obj.getMessage();
		context.registerShutdownHook();
	}

}
