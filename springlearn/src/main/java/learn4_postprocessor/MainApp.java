package learn4_postprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorldPostProcessor obj = (HelloWorldPostProcessor) context.getBean("learn4_helloWorldPostProcessor");
		obj.getMessage();
		context.registerShutdownHook();
	}

}
