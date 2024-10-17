package ejercicio_1;

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {
	
	public int size(); //Retorna el numero de elementos de la lista
	
	public void addFirst(ELEMENT item); //Inserta un elemento especifico al principio de la lista
	
	public void addLast(ELEMENT item); //Agrega un elemento especifico al final de la lista
	
	public ELEMENT removeFirst(); //Remueve o retorna el primer elemento de la lista
	
	public ELEMENT removeLast(); //Remueve o retorna el ultimo elemento de la lista
}
