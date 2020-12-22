package day03;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ThrowsDemo {

	public void dosome() throws IOException, AWTException {
		
	}

}

class Son extends ThrowsDemo {

//	True:
//	 1. 不处理
//	@Override
//	public void dosome() throws IOException, AWTException {
//		
//	}
	
//	 2. 父类部分异常
//	public void dosome() {
//		
//	}
	
//	 3. 父类的子类异常
//	public void dosome() throws FileNotFoundException {
//		
//	}
	
//	False:
//	1. 抛父类异常的父类异常
//	public void dosome() throws Exception {
//		
//	}
	
//	2. 抛与父类无关的异常
//	public void dosome() throws SQLException {
//		
//	}
	
}
