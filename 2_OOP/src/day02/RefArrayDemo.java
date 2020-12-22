package day02;

public class RefArrayDemo {

	public static void main(String[] args) {
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(2, 5);
		cells[1] = new Cell(2, 4);
		cells[2] = new Cell(3, 4);
		cells[3] = new Cell(4, 5);
		
		Cell[] cells2 = new Cell[] {
			new Cell(1,2),
			new Cell(2,3),
			new Cell(4,3)
		};
		cells2[0] = null;
		
		int[][] arr = new int[3][];
		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[4];
		
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				arr[i][j] = 100;
			}
		}
	
	}

}
