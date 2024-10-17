package ejercicio_4;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void menu(Scanner input) {
		DoubleLinkedOrderedList<Integer> listaOrdenada = new DoubleLinkedOrderedList<Integer>();
		boolean verdad = true;
		int numero;
		while (verdad) {
			System.out.println("1. Agregar al principio");
			System.out.println("2. Agregar al final");
			System.out.println("3. Agregar en orden");
			System.out.println("4. Mostrar lista");
			System.out.println("5. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					numero = Helper.validarEntero(input, "Ingrese un numero: ");
					listaOrdenada.addFirst(numero);
					break;
				case 2:
					numero = Helper.validarEntero(input, "Ingrese un numero: ");
					listaOrdenada.addLast(numero);
					break;
				case 3:
					numero = Helper.validarEntero(input, "Ingrese un numero: ");
					listaOrdenada.addInOrder(numero);
					break;
				case 4:
					mostrar(listaOrdenada);
					break;
				case 5:
					System.out.println("--- FIN DEL PROGRAMA ---");
					verdad = false;
					break;
				default:
					System.out.println("--- OPCION NO VALIDAD ---");
					break;
			}
		}
	}
	
	public static void mostrar(DoubleLinkedOrderedList<Integer> listaOrdenada) {
		for (Integer numero : listaOrdenada) {
			System.out.println(numero);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
	}
}
