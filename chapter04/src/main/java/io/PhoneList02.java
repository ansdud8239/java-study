package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			File file = new File("phone.txt");
			if ((!file.exists())) {
				System.out.println("file not found");
				return;
			}

			System.out.println("=============파일정보=============");
			// 절대경로
			System.out.println(file.getAbsolutePath());
			// 길이 (byte)
			System.out.println(file.length() + "bytes");

			// 파일 마지막 수정시간
			// Date d = new Date(file.lastModified());
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// String date = sdf.format(d);
			// System.out.println(date);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

			System.out.println("=============전화번호=============");

			sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				System.out.println(sc.next()+":"+sc.next()+"-"+sc.next()+"-"+sc.next());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found : " + e);
		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}

	}

}
