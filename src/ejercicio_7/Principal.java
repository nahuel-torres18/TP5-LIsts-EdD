package ejercicio_7;

import java.util.Random;
import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void cargarQueue(Queue<Integer> queueNumeros , int longitud, Scanner input) {
		Random random = new Random();
		for (int i = 0; i < queueNumeros.size(); i++) {
			queueNumeros.add(random.nextInt(100)+1);
		}
	}
	
	public static void mostrar(Queue<Integer> queueNumeros) {
		Queue<Integer> queueAuxiliar = new Queue<Integer>(queueNumeros.size());
		while (!queueNumeros.isEmpty()) {
			Integer numero = queueNumeros.remove();
			System.out.print(numero + " ");
			queueAuxiliar.add(numero);
		}
		while (!queueAuxiliar.isEmpty()) {
			queueNumeros.add(queueAuxiliar.remove());
		}
		System.out.println();
	}
	
	public static void promedio(Queue<Integer> queueNumeros, int longitud) {
		int suma = 0;
		double promedio;
		while (!queueNumeros.isEmpty()) {
			suma += queueNumeros.remove();
		}
		promedio = suma / longitud;
		System.out.println("El promedio de los numeros cargados es: " + promedio);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int longitud = Helper.validarEntero(input, "Ingrese la cantidad de elementos en Queue: ");
		Queue<Integer> queueNumeros = new Queue<Integer>(longitud);
		cargarQueue(queueNumeros, longitud, input);
		mostrar(queueNumeros);
		promedio(queueNumeros, longitud);
	}
}
