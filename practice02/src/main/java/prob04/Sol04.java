package prob04;
public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] nc1 = new char[str.length()];
		
		for (int i = str.length()-1, j = 0; i >= 0; i--, j++) {
			nc1[j] = str.charAt(i);
		}
		
		
		return nc1;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println(array);
	}
}