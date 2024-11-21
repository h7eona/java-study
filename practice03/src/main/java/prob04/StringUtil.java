package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String ans = "";
		for (int i = 0; i < strArr.length; i++) {
			ans += strArr[i];
		}
		return ans;
	}
}
