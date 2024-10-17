package ejercicio_4;

import java.lang.Comparable;
import java.util.Iterator;

public class DoubleLinkedOrderedList<ELEMENT extends Comparable<ELEMENT>> implements Iterable<ELEMENT> {
	
	protected class Node<ELEMENT> {
		protected Node<ELEMENT> next;
		protected Node<ELEMENT> prev;
		protected ELEMENT item;
		
		public Node() {
			this(null, null, null);
		}
		
		public Node(ELEMENT item) {
			this(item, null, null);
		}
		
		public Node(ELEMENT item, Node<ELEMENT> next) {
			this(item, next, null);
		}
		
		public Node(ELEMENT item, Node<ELEMENT> next, Node<ELEMENT> prev) {
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
	
	public DoubleLinkedOrderedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public int size() {
		return this.count;
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
	
	public void addLast(ELEMENT item) {
		Node<ELEMENT> temp = new Node<ELEMENT>(item, null, this.tail);
		if (this.size() == 0) {
			this.head = temp;
		} else {
			this.tail.next = temp;
		}
		this.tail = temp;
		++this.count;
	}
	
	public void addInOrder(ELEMENT item) {
		if (this.size() == 0) {
			this.head = this.tail = new Node<ELEMENT>(item, null, null);
			++this.count;
		} else {
			if (item.compareTo(this.head.item) <= 0) {
				this.addFirst(item);
			} else {
				if (item.compareTo(this.tail.item) > 0) {
					this.addLast(item);
				} else {
					Node<ELEMENT> skip = this.head;
					while ((skip != null) && (item.compareTo(skip.item) > 0)) {
						skip = skip.next;
					}
					if (skip == null) {
						throw new RuntimeException("Algo esta mal en el orden de los elementos de la lista");
					} else {
						Node<ELEMENT> temp = new Node<ELEMENT>(item, skip, skip.prev);
						skip.prev.next = temp;
						skip.prev = temp;
						++this.count;
					}
				}
			}
		}
	}
	
	public boolean findAndRemove(ELEMENT item) {
		if (this.size() == 0) {
			return false;
		}
		Node<ELEMENT> skip = this.head;
		while ((skip != null) && !(item.compareTo(skip.item) == 0)) {
			skip = skip.next;
		}
		if (skip == null) {
			return false;
		} else {
			if (skip.prev == null) {
				this.removeFirst();
				return true;
			} else {
				if (skip.next == null) {
					this.removeLast();
					return true;
				} else {
					skip.prev.next = skip.next;
					skip.next.prev = skip.prev;
					skip.prev = skip.next = null;
					return true;
				}
			}
		}
	}
	
	public ELEMENT removeFirst() {
		if (this.size() <= 0) {
			throw new RuntimeException("LISTA VACIA");
		}
		ELEMENT item = this.head.item;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		} else {
			this.head.prev = null;
		}
		--this.count;
		return item;
	}
	
	public ELEMENT removeLast() {
		if (this.size() <= 0) {
			throw new RuntimeException("COLA VACIA");
		}
		ELEMENT item = this.tail.item;
		if (this.head.next == null) {
			this.head = this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		--this.count;
		return item;
	}
	
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
                throw new RuntimeException("La lista está vacía...");
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
                throw new RuntimeException("La lista está vacía...");
            }
            ELEMENT item = this.current.item;
            this.current = this.current.prev;
            return item;
        }
 
    }
}
