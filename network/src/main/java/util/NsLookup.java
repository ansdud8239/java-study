package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		try {
			//주소를 스캐너로 입력받음
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.douzone.com");
			
			//exit로 빠져나오기
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
