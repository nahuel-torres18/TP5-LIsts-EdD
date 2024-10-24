package ejercicio_4;

import java.util.Iterator;
import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void menu(Scanner input) {
		DoubleLinkedOrderedList<Integer> lista1 = new DoubleLinkedOrderedList<Integer>();
		DoubleLinkedOrderedList<Integer> lista2 = new DoubleLinkedOrderedList<Integer>();
		DoubleLinkedOrderedList<Integer> unionLista = new DoubleLinkedOrderedList<Integer>();
		boolean verdad = true;
		int numero;
		while (verdad) {
			System.out.println("1. Cargar lista 1");
			System.out.println("2. Cargar lista 2");
			System.out.println("3. Combinar las dos listas en una");
			System.out.println("4. Mostrar lista");
			System.out.println("5. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					numero = Helper.validarEntero(input, "Ingrese un numero: ");
					lista1.addInOrder(numero);
					break;
				case 2:
					numero = Helper.validarEntero(input, "Ingrese un numero: ");
					lista2.addInOrder(numero);
					break;
				case 3:
					unionLista = unionLista(lista1, lista2);
					break;
				case 4:
					mostrar(unionLista);
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
	
	
	public static DoubleLinkedOrderedList<Integer> unionLista(DoubleLinkedOrderedList<Integer> lista1, DoubleLinkedOrderedList<Integer> lista2) {
		DoubleLinkedOrderedList<Integer> unionLista = new DoubleLinkedOrderedList<Integer>();
		
		Iterator<Integer> iterator1 = lista1.iterator();
		Iterator<Integer> iterator2 = lista2.iterator();
		
		Integer current1 = null;
		Integer current2 = null;
		
		if (iterator1.hasNext()) {
			current1 = iterator1.next();
		}
		if (iterator2.hasNext()) {
			current2 = iterator2.next();
		}
		
		while (current1 != null || current2 != null) {
			if (current1 == null) {
				unionLista.addLast(current2);
				if (iterator2.hasNext()) {
					current2 = iterator2.next();
				} else {
					current2 = null;
				}
			} else if (current2 == null) {
				unionLista.addLast(current1);
				if (iterator1.hasNext()) {
					current1 = iterator1.next();
				} else {
					current1 = null;
				}
			} else {
				if (current1 <= current2) {
					unionLista.addLast(current1);
					if (iterator1.hasNext()) {
						current1 = iterator1.next();
					} else {
						current1 = null;
					}
				} else {
					unionLista.addLast(current2);
					if (iterator2.hasNext()) {
						current2 = iterator2.next();
					} else {
						current2 = null;
					}
				}
			}
		}
		return unionLista;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
	}
}
