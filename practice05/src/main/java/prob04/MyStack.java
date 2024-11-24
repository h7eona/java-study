package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		/* 구현하기 */
		this.buffer = new String[capacity];
		this.top = -1;
	}

	public void push(String s) {
		/* 구현하기 */
		if (top == buffer.length-1) {
			resize();
		} 
		buffer[++top] = s;
	}

	public String pop() throws MyStackException {
		/* 구현하기 */
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		
		return buffer[top--];
	}

	public boolean isEmpty() {
		/* 구현하기 */
		return top == -1;
	}

	private void resize() {
		/* 구현하기 */
		String[] newBuffer = new String[buffer.length * 2];
		System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
		buffer = newBuffer;
	}	
}