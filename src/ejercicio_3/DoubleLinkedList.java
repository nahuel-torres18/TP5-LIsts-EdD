package ejercicio_3;

import java.util.Iterator;

public class DoubleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {
	
	protected class Node<ELEMENT> {
		protected ELEMENT item;
		protected Node<ELEMENT> next;
		protected Node<ELEMENT> prev;
		
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
	
	public DoubleLinkedList() {
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
	
	public ELEMENT removeFirst() {
		if (this.size() == 0) {
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
		if (this.size() == 0) {
			throw new RuntimeException("LISTA VACIA");
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
	
	public boolean eliminarPorCodigo(int codigo) {
		if (this.head == null) {
			return false;
		}
		if (this.head.item instanceof Deuda && ((Deuda)this.head.item).getCodigo() == codigo) {
			removeFirst();
			return true;
		}
		Node<ELEMENT> temp = this.head;
		while (temp != null && temp.item instanceof Deuda) {
			Deuda deuda = (Deuda)temp.item;
			if (deuda.getCodigo() == codigo) {
				if (temp == this.tail) {
					removeLast();
					return true;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					return true;
				}
			}
			temp = temp.next;
			
		}
		return false;
	}
	
	public boolean eliminarPorNombreAcredor(String nombreAcredor) {
		if (this.head == null) {
			return false;
		}
		if (this.head.item instanceof Deuda && ((Deuda)this.head.item).getNombreAcredor().equals(nombreAcredor)) {
			removeFirst();
			return true;
		}
		Node<ELEMENT> temp = this.head;
		while (temp != null && temp.item instanceof Deuda) {
			Deuda deuda = (Deuda)temp.item;
			if (deuda.getNombreAcredor().equals(nombreAcredor)) {
				if (temp == this.tail) {
					removeLast();
					return true;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					return true;
				}
			}
			temp = temp.next;
			
		}
		return false;
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
