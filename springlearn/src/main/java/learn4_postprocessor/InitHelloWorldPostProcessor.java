package learn4_postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorldPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before initialization: " + beanName);
		return bean;
	}
	
	@Override 
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After initialization: " + beanName);
		return bean;
	}
	
	
}
