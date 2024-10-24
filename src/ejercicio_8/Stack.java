package ejercicio_8;

public class Stack<ELEMENT> {
	private SimpleLinkedList<ELEMENT> stack;
	
	public Stack() {
		this.stack = new SimpleLinkedList<>();
	}
	
	public boolean isEmpty() {
		return stack.size() <= 0;
	}
	
	public void push(ELEMENT item) {
		stack.addFirst(item);
	}
	
	public ELEMENT pop() {
		if (isEmpty()) {
			throw new RuntimeException("Pila vacia");
		}
		return stack.removeFirst();
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new RuntimeException("Pila vacia");
		}
		return stack.getFirst();
	}
}
