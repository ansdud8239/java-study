package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;

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

			// 1.기반 스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);

			// 2. 보조 스트림1(바이트|바이트|바이트 (3바이트)-> char )
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");

			// 3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);

			// 4.처리
			String line = null;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				StringTokenizer st = new StringTokenizer(line, "\t ");
				int index = 0;
				while (st.hasMoreElements()) {
					String token = st.nextToken();
//					System.out.print(st.nextToken());

					if (index == 0) {
						System.out.print(token + ":");
					} else if (index == 1) {
						System.out.print(token + "-");
					} else if (index == 2) {
						System.out.print(token + "-");
					} else {
						System.out.print(token);
					}
					index++;
				}
				System.out.println("");
			}

		} catch (UnsupportedEncodingException e) {
			System.out.println("error : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
