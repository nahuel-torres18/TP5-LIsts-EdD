package ejercicio_0;

public class List2<E> {
	private Node head;
	private Node tail;
	private int count;
	
	public void addFirst(E item) {
		if (this.count == 0) {
			this.head = this.tail = new Node(item, null, null);
			++this.count;
		} else {
			Node temp = new Node(item, null, null);
			temp.next = this.head;
			this.head.prev = temp;
			this.head = temp;
			++this.count;
		}
	}
	
	public void Better_AddFirst(E item) {
		Node temp = new Node(item, this.head, null);
		if (this.count == 0) {
			this.tail = temp;
		} else {
			this.head.prev = temp;
		}
		this.head = temp;
		++this.count;
	}
	
	public void addLast(E item) {
		if (this.count == 0) {
			this.head = this.tail = new Node(item, null, null);
			++this.count;
		} else {
			Node temp = new Node(item, null, null);
			temp.prev = this.tail;
			this.tail.next = temp;
			this.tail = temp;
			++this.count;
		}
	}
	
	public void Better_AddLast(E item) {
		Node temp = new Node(item, null, this.tail);
		if (this.count == 0) {
			this.head = temp;
		} else {
			this.tail.next = temp;
		}
		this.tail = temp;
		++this.count;
	}
	
	public E removeFirst() {
		if (this.count == 0) {
			throw new RuntimeException("LA LISTA ESTA VACIA");
		}
		E item = this.head.item;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		} else {
			this.head.prev = null;
		}
		--this.count;
		return item;
	}
	
	public E removeLast() {
		if (this.count == 0) {
			throw new RuntimeException("LA LISTA ESTA VACIA");
		}
		E item = this.tail.item;
		if (this.head.next == null) {
			this.head = this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		--this.count;
		return item;
	}
	
	private class Node {
		public E item;
		public Node next;
		public Node prev;
		
		public Node() {
			this(null, null, null);
		}
		
		public Node(E item) {
			this(item, null, null);
		}
		
		public Node(E item, Node next) {
			this(item, next, null);
		}
		
		public Node(E item, Node next, Node prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
}
