package prob01;

public class SmartPhone extends MusicPhone {
	public void execute(String function) {
		if(function.equals("앱")) {
			app();
		} else if(function.equals("음악")) {
			music();
		} else {
			super.execute(function);
		}
	}
	
	public void music() {
		System.out.println("다운로드해서 음악재생");
	}
	
	public void app() {
		System.out.println("앱실행");
	}
}
