package prob04;

import java.util.Scanner;

public class Sol04 {

	public static void main(String[] args) {
		
		/* 코드 작성 */
		
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		
		for (int i=1; i<str.length(); i++) {
			for (int j=0; j<i; j++) {
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}
		System.out.println(str);
		scanner.close();
	}
}