package prob06;

public class Sub {
	private int l;
	private int r;
	
	public void setValue(int l, int r) {
		this.l = l;
		this.r = r;
	}
	
	public int calculate() {
		return l - r;
	}
}
