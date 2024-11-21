package prob02;

import java.util.Scanner;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력 
		for (int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] info = line.split(" ");
			
			String drink = info[0];
			int price = Integer.parseInt(info[1]);
			int count = Integer.parseInt(info[2]);
			
			goods[i] = new Goods(drink, price, count);
		}
		
		// 상품 출력
		for (int i = 0; i < COUNT_GOODS; i++) {
			goods[i].printInfo();
		}
	
		scanner.close();
	}
}