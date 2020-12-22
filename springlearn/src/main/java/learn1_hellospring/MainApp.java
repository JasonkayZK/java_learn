package learn1_hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings({ "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloSpring obj = (HelloSpring)context.getBean("helloSpring");
		obj.getMessage();
		
	}

}
