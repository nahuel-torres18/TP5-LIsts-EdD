package ejercicio_1;

import java.util.Iterator;

public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {
	
	private class Node<ELEMENT> {
		public ELEMENT item;
		public Node<ELEMENT> next;
		
		public Node() {
			this(null, null);
		}
		
		public Node(ELEMENT item) {
			this(item, null);
		}
		
		public Node(ELEMENT item, Node<ELEMENT> next) {
			this.item = item;
			this.next = next;	
		}
		
		@Override
		public String toString() {
			return this.item.toString();
		}
	}
	
	protected Node<ELEMENT> tail;
	protected Node<ELEMENT> head;
	protected int count;
	
	public SimpleLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public int size() {
		return this.count;
	}
	
	public void addFirst(ELEMENT item) {
		if (this.count == 0) {
			this.head = this.tail = new Node(item, null);
			++this.count;
		} else {
			Node<ELEMENT> temp = new Node<>(item, null);
			temp.next = this.head;
			this.head = temp;
			++this.count;
		}
	}
	
	public void addLast(ELEMENT item) {
		if (this.count == 0) {
			this.head = this.tail = new Node<>(item, null);
			++this.count;
		} else {
			Node<ELEMENT> temp = new Node<>(item, null);
			this.tail.next = temp;
			this.tail = temp;
			++this.count;
		}
	}
	
	public ELEMENT removeFirst() {
		if (this.count == 0) {
			throw new RuntimeException("LISTA VACIA");
		}
		ELEMENT item = this.head.item;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		}
		--this.count;
		return item;
	}
	
	public ELEMENT removeLast() {
		if (this.count == 0) {
			throw new RuntimeException("LISTA VACIA");
		}
		ELEMENT item = this.tail.item;
		if (this.head.next == null) {
			this.head = this.tail = null;
		} else {
			Node<ELEMENT> skip = this.head;
			while (skip.next.next != null) {
				skip = skip.next;
			}
			this.tail = skip;
			this.tail.next = null;
		}
		--this.count;
		return item;
	}
	
	public boolean eliminarEmpleado(int numeroLegajo) {
		if (this.head == null) {
			return false;
		}
		if (this.head.item instanceof Empleado && ((Empleado)this.head.item).getNumeroLegajo() == numeroLegajo) {
			removeFirst();
			return true;
		}
		Node<ELEMENT> current = this.head;
		Node<ELEMENT> previous = null;
		while (current != null && current.item instanceof Empleado) {
			Empleado empleado = (Empleado) current.item;
			if (empleado.getNumeroLegajo() == numeroLegajo) {
				if (previous != null) {
					previous.next = current.next;
					if (current == this.tail) {
						this.tail = previous;
					}
					--this.count;
					return true;
				}
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public void mostrar() {
		Node<ELEMENT> temp = this.head;
		while (temp != null) {
			System.out.println(temp.item.toString());
			temp = temp.next;
		}
	}
	
	@Override
	public Iterator<ELEMENT> iterator() {
		return new SimpleLinkedListIterator(this.head);
	}
	
	private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
		private Node<ELEMENT> current;
		
		public SimpleLinkedListIterator(Node<ELEMENT> current) {
			this.current = current;
		}
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}
		
		@Override
		public ELEMENT next() {
			if (!this.hasNext()) {
				throw new RuntimeException("LISTA VACIA");
			}
			ELEMENT item = this.current.item;
			this.current = this.current.next;
			return item;
		}
	}
}
