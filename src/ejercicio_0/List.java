package ejercicio_0;

public class List<E> {
	private Node head;
	private Node tail;
	int count;
	
	public int getCount() {
		return this.count;
	}
	
	public List() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public void addFirst(E item) {
		if (this.count == 0) {
			this.head = this.tail = new Node(item, null);
			++this.count;
		} else {
			Node temp = new Node(item, null);
			temp.next = this.head;
			this.head = temp;
			++this.count;
		}
	}
	
	public void Better_AddFirst(E item) {
		Node temp = new Node(item, this.head);
		if (this.count == 0) {
			this.tail = temp;
		}
		this.head = temp;
		++this.count;
	}
	
	public void addLast(E item) {
		if (this.count == 0) {
			this.head = this.tail = new Node(item, null);
			++this.count;
		} else {
			Node temp = new Node(item, null);
			this.tail.next = temp;
			this.tail = temp;
			++this.count;
		}
	}
	
	public void Better_AddLast(E item) {
		Node temp = new Node(item, null);
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
		E item = this.head.item; //Toma el elemento que está en el primer NODO
		this.head = this.head.next; //Avanza a el siguiente nodo
		if (this.head == null) {
			this.tail = null;
		}
		--this.count;
		return item;
	}
	
	public E removeLast() {
		if (this.count == 0) {
			throw new RuntimeException("LA LISTA ESTA VACIA");	
		}
		E item = this.tail.item;
		if (this.head.next == null) { //Verifica si es el unico nodo en la lista
			this.head = this.tail = null;
		} else {
			Node skip = this.head;
			for ( ; skip.next.next != null; skip = skip.next) {}
			this.tail = skip;
			this.tail.next = null;
		}
		--this.count;
		return item;
	}
	
	/*public void visualizar(){
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.item + " ");
			temp = temp.next;
		}
		System.out.println();
	}*/
	
	public void Mostrar() {
		for (Node skip = this.head; skip != null; skip = skip.next) {
			System.out.print(skip.toString() + " ");
		}
		System.out.println();
	}
	
	private class Node {
		public E item;
		private Node next;
		
		public Node() {
			this(null, null);
		}
		
		public Node(E item) {
			this(item, null);
		}
		
		public Node(E item, Node next) {
			this.item = item;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return this.item.toString();
		}
	}	
}
