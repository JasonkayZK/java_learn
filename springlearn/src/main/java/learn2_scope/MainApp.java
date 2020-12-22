package learn2_scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		// 1. Singleton
		HelloWorldSingleton singleObjA = (HelloWorldSingleton) context.getBean("learn2_helloWorldSingleton");
		singleObjA.setMessage("Object A");
		singleObjA.getMessage(); // Object A
		
		HelloWorldSingleton singleObjb = (HelloWorldSingleton) context.getBean("learn2_helloWorldSingleton");
		singleObjb.getMessage(); // Object A
		
		singleObjb.setMessage("Object B");
		singleObjA.getMessage(); // Object B
		
		// 2. Prototype
		HelloWorldPrototype protoObjA = (HelloWorldPrototype) context.getBean("learn2_helloWorldPrototype");
		protoObjA.setMessage("Object A");
		protoObjA.getMessage(); // Object A
		
		HelloWorldPrototype protoObjB = (HelloWorldPrototype) context.getBean("learn2_helloWorldPrototype");
		protoObjB.getMessage(); // Object null
		
		
	}

}
