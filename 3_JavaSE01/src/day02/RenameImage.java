package day02;

public class RenameImage {

	public static void main(String[] args) {
		/*
		 * ������ͼƬ
		 */
		String imgName = "1.jpg";
		String[] names = imgName.split("\\.");
		imgName = System.currentTimeMillis() + "." + names[1];
		System.out.println(imgName);
	}

}
