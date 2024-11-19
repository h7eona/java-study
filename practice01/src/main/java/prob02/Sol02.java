package prob02;

public class Sol02 {
	public static void main(String[] args) {
		
		/* 코드 작성 */
		String nums = "1 2 3 4 5 6 7 8 9 10";
		System.out.println(nums);
		
		for(int i = 11; i < 19; i++) {
			nums = nums + " " + String.valueOf(i);
			System.out.println(nums);
		}
	
	}
}