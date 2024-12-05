package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		int i = 10;
		int j  = 10;
		System.out.println(i + ", " + j);
		
		//swap
		int tmp = j;
		i = j;
		j = tmp;
		
		System.out.println(i + ", " + j);

	}

}
