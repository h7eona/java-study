package prob02;

public class Goods {
	private String drink;
	private int price;
	private int count;
	
	public Goods(String drink, int price, int count) {
		this.drink = drink;
		this.price = price;
		this.count = count;
	}
	
	public void printInfo() {	
		System.out.println(drink + "(가격:" +price + "원)이 " + count + "개 입고 되었습니다.");
	}
}