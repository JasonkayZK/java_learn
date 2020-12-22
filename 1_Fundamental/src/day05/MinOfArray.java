package day05;

public class MinOfArray {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; ++i)
			arr[i] = (int)(Math.random() * 100);
		int min = arr[0];
		for (int x : arr)
			if (x < min)
				min = x;
		System.out.println("The minimum number in the arr is:" + min);
		
		int[] arr1 = new int[arr.length + 1];
		System.arraycopy(arr, 0, arr1, 1, arr.length);
		arr1[0] = min;
		for (int x : arr1)
			System.out.println(x);
	}
	
}
