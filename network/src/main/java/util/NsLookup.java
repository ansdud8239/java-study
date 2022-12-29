package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NsLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				// 주소를 스캐너로 입력받음
				System.out.print(">> ");
				String dns = sc.nextLine();
				
				// exit로 빠져나오기
				if (dns.equals("exit")) {
					sc.close();
					break;
				}
				
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(dns);
				for (InetAddress inetAddress : inetAddresses) {
					System.out.println(dns + " : " + inetAddress.getHostAddress());
				}

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
