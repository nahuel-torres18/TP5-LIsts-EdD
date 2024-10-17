package ejercicio_2;

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {
	public int size();
	public void addFirst(ELEMENT item);
	public void addLast(ELEMENT item);
	public ELEMENT removeFirst();
	public ELEMENT removeLast();
}
