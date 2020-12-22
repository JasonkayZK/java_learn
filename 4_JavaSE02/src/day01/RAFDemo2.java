package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFDemo2 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf1.dat", "rw");
		int max = Integer.MAX_VALUE;
		
		// 1. void writeInt(int num)
		raf.write(max >> 24);
		raf.write(max >> 16);
		raf.write(max >> 8);
		raf.write(max);
		raf.writeInt(Integer.MAX_VALUE);
		raf.writeDouble(123.123);
		raf.writeLong(1234L);
		
		// 2. int readInt()
//		int d = raf.readInt();
		
		// 3. long getFilePointer()
		long pd = raf.getFilePointer();
		System.out.println(pd);
		
		// 4. void seek(long pos)
		raf.seek(0);
		System.out.println(raf.readInt());
		pd = raf.getFilePointer();
		System.out.println(pd);		
		
		raf.close();
	}

}
