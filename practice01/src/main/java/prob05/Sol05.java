package prob05;

public class Sol05 {
	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			int cnt = counting(String.valueOf(i));
			if (cnt > 0) {
				System.out.println(i+ " " + "짝".repeat(cnt));
			}
		}
	}
	public static int counting(String str) {
		int flen = str.length();
		str = str.replace("3", "");
		str = str.replace("6", "");
		str = str.replace("9", "");
		
		return flen - str.length();
	}
}
