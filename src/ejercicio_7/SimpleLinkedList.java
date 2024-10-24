package ejercicio_7;

import java.util.Iterator;

public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {
	private class Node<ELEMENT> {
		private Node<ELEMENT> next;
		private ELEMENT item;

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

	private Node<ELEMENT> head;
	private Node<ELEMENT> tail;
	private int count;
	
	public SimpleLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public int size() {
		return this.count;
	}

	public void addFirst(ELEMENT item) {
		Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head);
		if (this.count == 0) {
			this.tail = temp;
		}
		this.head = temp;
		++this.count;
	}

	public void addLast(ELEMENT item) {
		Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
		if (this.count == 0) {
			this.head = temp;
		} else {
			this.tail.next = temp;
		}
		this.tail = temp;
		++this.count;
	}

	public ELEMENT removeFirst() {
		if (this.count == 0) {
			throw new RuntimeException("La lista está vacía...");
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
			throw new RuntimeException("La lista está vacía...");
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
	
	public ELEMENT getFirst() {
		return this.head.item;
	}
	
	public ELEMENT getLast() {
		return this.tail.item;
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
				throw new RuntimeException("La lista está vacía...");
			}
			ELEMENT item = this.current.item;
			this.current = this.current.next;
			return item;
		}

	}
}
