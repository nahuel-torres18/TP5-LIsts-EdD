package ejercicio_2;

import java.util.Iterator;

public class DoubleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {
	protected class Node<ELEMENT> {
		protected Node<ELEMENT> next;
		protected Node<ELEMENT> prev;
		protected ELEMENT item;
		
		protected Node() {
			this(null, null, null);
		}
		
		protected Node(ELEMENT item) {
			this(item, null, null);
		}
		
		protected Node(ELEMENT item, Node<ELEMENT> next) {
			this(item, next, null);
		}
		
		protected Node(ELEMENT item, Node<ELEMENT> next, Node<ELEMENT> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return this.item.toString();
		}
	}
	
	private Node<ELEMENT> head;
	private Node<ELEMENT> tail;
	private int count;
	
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public int size() {
		return this.count;
	}
	
	public void addFirstRookieVersion(ELEMENT item) {
		if (this.size() == 0) {
			this.head = this.tail = new Node(item, null, null);
			++this.count;
		} else {
			Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
			temp.next = this.head;
			this.head.prev = temp;
			this.head = temp;
			++this.count;
		}
	}
	
	public void addFirst(ELEMENT item) {
		Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head, null);
		if (this.size() == 0) {
			this.tail = temp;
		} else {
			this.head.prev = temp;
		}
		this.head = temp;
		++this.count;
	}
	
	public void addLastRookieVersion(ELEMENT item) {
		if (this.size() <= 0) {
			this.head = this.tail = new Node<ELEMENT>(item, null, null);
			++this.count;
		} else {
			Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
			temp.prev = this.tail;
			this.tail.next = temp;
			this.tail = temp;
			++this.count;
		}
	}
	
	public void addLast(ELEMENT item) {
		Node<ELEMENT> temp = new Node<ELEMENT>(item, null, this.tail);
		if (this.size() <= 0) {
			this.head = temp;
		} else {
			this.tail.next = temp;
		}
		this.tail = temp;
		++this.count;
	}
	
	public ELEMENT removeFirst() {
		if (this.size() <= 0) {
			throw new RuntimeException("LISTA VACIA");
		}
		ELEMENT element = this.head.item;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		} else {
			this.head.prev = null;
		}
		--this.count;
		return element;
	}
	
	public ELEMENT removeLast() {
		if (this.size() <= 0) {
			throw new RuntimeException("LISTA VACIA");
		}
		ELEMENT element = this.tail.item;
		if (this.head.next == null) {
			this.head = this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		--this.count;
		return element;
	}
	
	public void insertarEnPosicion(ELEMENT item, int posicion) {
		if (posicion < 0) {
			throw new RuntimeException("POSICION NO ENCONTRADA");	
		}
		if (posicion == 0) {
			addFirst(item);
		} else if (posicion > this.size()) { 
			addLast(item);
		}else { 
			Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
			Node<ELEMENT> skip = this.head;
			for (int i = 0; i < posicion-1; i++) {
				skip = skip.next;
			}
			temp.next = skip.next;
			temp.prev = skip;
			if (skip.next != null) {
				skip.next.prev = temp;
			}
			skip.next = temp;
			++this.count;
		}
	}
	
	/*public void insertarEnPosicion(ELEMENT item, int posicion) {
		if (posicion == 1) {
			addFirst(item);
			++this.count;
		}
		if (posicion > this.count) {
			addLast(item);
			++this.count;
		}
		if (posicion == this.count) {
			Node<ELEMENT> skip = this.head;
			//int contador = 1;
			for (int i = 1; i < posicion; i++) {
				skip = skip.next;
			}
			if (posicion > 2) {
				skip = skip.next;
				Node<ELEMENT> temp = new Node<ELEMENT>(item, skip, skip.prev);
				skip.prev.next = temp;
				skip.prev = temp;
				++this.count;
			} else {
				Node<ELEMENT> temp = new Node<ELEMENT>(item, skip, skip.prev);
				skip.prev.next = temp;
				skip.prev = temp;
				++this.count;
			}
		}*/
		
		/*
		 * else {
			int contador = 1;
			Node<ELEMENT> skip = this.head;
			while (contador <= posicion) {
				skip = skip.next;
				contador++;
			}
			Node<ELEMENT> temp = new Node<ELEMENT>(item, skip, skip.prev);
			skip.prev.next = temp;
			skip.prev = temp;
			++this.count;
		}
		
	}*/
	
	@Override
	public Iterator<ELEMENT> iterator() {
		return new DoubleLinkedListIterator(this.head);
	}
	
	public class DoubleLinkedListIterator implements Iterator<ELEMENT> {
		private Node<ELEMENT> current;
		
		public DoubleLinkedListIterator(Node<ELEMENT> current) {
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
	
	public Iterator<ELEMENT> iteratorBack() {
		return new DoubleLinkedListIteratorBack(this.tail);
	}
	public class DoubleLinkedListIteratorBack implements Iterator<ELEMENT> {
		private Node<ELEMENT> current;
		
		public DoubleLinkedListIteratorBack(Node<ELEMENT> current) {
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
			this.current = this.current.prev;
			return item;
		}
	}
}