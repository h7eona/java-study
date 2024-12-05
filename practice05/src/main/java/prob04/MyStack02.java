package prob04;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	public MyStack02(int capacity) {
		/* 구현하기 */
		this.buffer = new String[capacity];
		this.top = -1;
	}

	public void push(Object s) {
		/* 구현하기 */
		if (top == buffer.length-1) {
			resize();
		} 
		buffer[++top] = s;
	}

	public Object pop() throws MyStackException {
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
		Object[] newBuffer = new Object[buffer.length * 2];
		System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
		buffer = newBuffer;
	}	
}
