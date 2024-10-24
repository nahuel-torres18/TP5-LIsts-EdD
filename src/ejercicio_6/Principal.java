package ejercicio_6;

import java.util.Random;
import ejercicio_1.Helper;
import java.util.Scanner;

public class Principal {
	
	public static void cargarLista(DoubleLinkedList<Integer> listaNumeros, Scanner input) {
		int cantidad = Helper.validarEntero(input, "Ingrese la cantidad de numeros que tendra la lista: ");
		for (int i = 0; i < cantidad; i++) {
			listaNumeros.addLast(Helper.validarEntero(input, "Ingrese un numero: "));
		}
	}
	
	public static void mostrar(DoubleLinkedList<Integer> listaNumeros) {
		for (Integer numero : listaNumeros) {
			System.out.print(numero + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DoubleLinkedList<Integer> listaNumeros = new DoubleLinkedList<Integer>();
		cargarLista(listaNumeros, input);
		listaNumeros.eliminarNumeroRepetido();
		mostrar(listaNumeros);
	}
}
