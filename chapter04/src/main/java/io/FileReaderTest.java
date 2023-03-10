package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		try {
			in = new FileReader("test.txt");

			int count = 0;
			int data = -1;
			//3바이트씩 읽음
			while ((data = in.read()) != -1) {
				// System.out.println(data);
				System.out.print((char) data);
				count++;
			}

			System.out.print("\n");
			System.out.println("count: " + count);
			System.out.println("================================");

			is = new FileInputStream("test.txt");
			count = 0;
			data = -1;
			
			//1바이트씩 읽음
			while ((data = is.read()) != -1) {
				System.out.print((char) data);
				count++;
				
			}
			System.out.print("\n");
			System.out.println("count: " + count);
			

		} catch (FileNotFoundException e) {
			System.out.println("file not found : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
