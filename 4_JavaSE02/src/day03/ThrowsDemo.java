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
//	 1. ������
//	@Override
//	public void dosome() throws IOException, AWTException {
//		
//	}
	
//	 2. ���ಿ���쳣
//	public void dosome() {
//		
//	}
	
//	 3. ����������쳣
//	public void dosome() throws FileNotFoundException {
//		
//	}
	
//	False:
//	1. �׸����쳣�ĸ����쳣
//	public void dosome() throws Exception {
//		
//	}
	
//	2. ���븸���޹ص��쳣
//	public void dosome() throws SQLException {
//		
//	}
	
}
