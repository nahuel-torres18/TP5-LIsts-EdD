package ejercicio_4;

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT>{
	
	public void addFirst(ELEMENT item);
	public void addLast(ELEMENT item);
	public ELEMENT removeFirst();
	public ELEMENT removeLast();
}
