package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt");
			// 아스키값
			int data = fis.read();
			//System.out.println(data);
			// 실제 값
			System.out.println((char) data);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : " + e);
		} catch (IOException e) {
			System.out.println("ERROR : " + e);
		} finally {
			try {
				// 조건문이 없을 겨우 fis에 null이 때문에 nullpointexception에러 발생
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
