package day06;

public class InnerClassDemo {

	public static void main(String[] args) {
		Mama m = new Mama();
		// Baby b = new Baby();
		

	}

}

class Mama {
	private String name;
	
	Baby createBaby() {
		return new Baby();
	}
	class Baby {
		//String name;
		public void showMamaName() {
			System.out.println(Mama.this.name);
		//	System.out.println(this.name);
		}
	}
}

