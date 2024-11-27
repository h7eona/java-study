package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			
			try {
				String domain = scanner.nextLine();
				
				if ("exit".equals(domain)) {
					break;
				}
				
				InetAddress[] InetAddresses = InetAddress.getAllByName(domain);
				
				for(InetAddress inetAddress : InetAddresses) {
					System.out.println(domain + " : " + inetAddress.getHostAddress());
				}
	
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
}
