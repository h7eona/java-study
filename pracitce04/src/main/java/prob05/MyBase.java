package prob05;

public class MyBase extends Base {
	private String state;
	
	@Override
	public void service(String state){
		this.state = state;
		
		if(state.equals("낮")) {
			day();
		} 
		else if(state.equals("밤")){
			night();
		}
		else {
			afternoon();
		}
	}
	
	@Override
	public void day(){
		System.out.println(state + "에는 열심히 일하자!");
	}
	
	public void afternoon() {
		System.out.println(state + "도 낮과 마찬가지로 일해야 합니다.");
	}
}
