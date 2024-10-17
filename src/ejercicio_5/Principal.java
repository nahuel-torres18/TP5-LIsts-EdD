package ejercicio_5;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void menu(Scanner input) {
		boolean verdad = true;
		DoubleLinkedList<Integer> lista = new DoubleLinkedList<Integer>();
		while (verdad) {
			System.out.println("1. Agregar elemento");
			System.out.println("2. Recorrer hacia adelante");
			System.out.println("3. Recorrer hacia atras");
			System.out.println("4. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					lista.addLast(Helper.validarEntero(input, "Ingrese un numero: "));
					break;
				case 2:
					lista.recorrerHaciaAdelante();
					break;
				case 3:
					lista.recorrerHaciaAtras();
					break;
				case 4:
					verdad = false;
					System.out.println("--- FIN DEL PROGRAMA ---");
					break;
				default:
					System.out.println("--- OPCION FUERA DE RANGO ----");
					break;
			}
		}
	}
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
	}
}