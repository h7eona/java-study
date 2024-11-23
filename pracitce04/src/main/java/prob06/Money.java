package prob06;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}
	
	public int add(Money other) {
		return amount + other.amount;
	}
	
	public int minus(Money other) {
		return amount - other.amount;
	}
	
	public int multiply(Money other) {
		return amount * other.amount;
	}
	
	public int divide(Money other) {
		return amount / other.amount;
	}
	
	public boolean equals(int sum) {
		if (amount == sum) {
			return true;
		} else {
			return false;
		}
	}
}
