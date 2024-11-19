package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("수를 입력 하세요 : ");
			int num = scanner.nextInt();
			int sm = 0;
			
			if (num % 2 == 0) {
				for (int i = 2; i <= num; i+=2) {
					sm  = sm + i;
				}
			}
			else {
				for (int i = 1; i <= num; i+=2) {
					sm = sm + i;
				}
			}
			System.out.println("결과값: " + sm);
		}
	}
}
