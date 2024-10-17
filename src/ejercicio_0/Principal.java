package ejercicio_0;

public class Principal {
	
	public static void main(String[] args) {
		List<Integer> lista = new List<Integer>();
		
		for (int i = 1; i <= 6; i++) {
			lista.Better_AddFirst(i);
		}
		
		for (int i = 7; i <= 12; i++) {
			lista.Better_AddLast(i);
		}
		
		lista.Mostrar();
		
		for (int i = 0; i < 4; i++) {
			System.out.println(lista.removeFirst());
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(lista.removeLast());
		}
	}
}
