package ejercicio_7;

public class Queue<ELEMENT> {
	private SimpleLinkedList<ELEMENT> lista;
	private int longitud;
	
	public Queue(int longitud) {
		this.lista = new SimpleLinkedList<ELEMENT>();
		this.longitud = longitud;
	}
	
	public boolean isEmpty() {
		return lista.size() <= 0;
	}
	
	public boolean isFull() {
		return lista.size() >= this.longitud;
	}
	
	public int size() {
		return this.longitud;
	}
	
	public boolean add(ELEMENT item) {
		if (isFull()) {
			throw new RuntimeException("COLA LLENA");
		}
		lista.addLast(item);
		return true;
	}
	
	public boolean offer(ELEMENT item) {
		if (isFull()) {
			return false;
		}
		lista.addLast(item);
		return true;
	}
	
	public ELEMENT remove() {
		if (isEmpty()) {
			throw new RuntimeException("COLA VACIA");	
		}
		ELEMENT item = lista.removeFirst();
		return item;
	}
	
	public ELEMENT poll() {
		if (isEmpty()) {
			return null;
		}
		ELEMENT item = lista.removeFirst();
		return item;
	}
	
	public ELEMENT element() {
		if (isEmpty()) {
			throw new RuntimeException("COLA VACIA");
		}
		return lista.getFirst();
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			return null;
		}
		return lista.getFirst();
	}
}
