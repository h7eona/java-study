package prob03;

public class Book {
	private int no;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int no, String title, String author) {
		this.no = no;
		this.title = title;
		this.author = author;
		setStateCode(1);
	}
	
	public void setStateCode(int n) {
		this.stateCode = n;
	}

	public int getNo() {
		return no;
	}

	public void rent() {
		setStateCode(0);
		System.out.println(title + "이(가) 대여 됐습니다.");
	}
	
	public void print() {
		System.out.println("책 제목:" + title + ", 작가:" + author + ", 대여 유무:" + borrow());
	}
	
	public String borrow() {
		if (stateCode == 1) {
			return "재고있음";
		}
		else {
			return "대여중";
		}
	}
}
