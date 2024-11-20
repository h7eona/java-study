package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("금액:");
		int total_money = scanner.nextInt();
		
		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		for (int i = 0; i < 10; i++) {
			System.out.println(MONEYS[i] + "원: " + (int)total_money/MONEYS[i] + "개");
			total_money = total_money % MONEYS[i];
		}
		scanner.close(); 
 	}
}