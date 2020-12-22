package day06;

public class NstInnerClassDemo {

	public static void main(String[] args) {
		Inter2 o1 = new Inter2() {
			
		};

		final int num = 5;
		
		Inter3 o3 = new Inter3() {
			
			@Override
			public void show() {
				System.out.println(num);
			}
		};
		o3.show();
	}

}

interface Inter3 {
	
	public void show();
}


interface Inter2 {
	
}



