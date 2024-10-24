package ejercicio_8;

import ejercicio_1.Helper;
import java.util.Scanner;

public class Principal {
	
	public static void cargarPila(Stack<Character> pilaCaracteres,String palabra) {
		for (int i = 0; i < palabra.length(); i++) {
			pilaCaracteres.push(palabra.charAt(i));
		}
	}
	
	public static boolean esPalindromo(Stack<Character> pilaCaracteres,String palabra) {
		boolean esPalindromo = true;
		int posicion = 0;
		while (!pilaCaracteres.isEmpty()) {
			char caracter = pilaCaracteres.pop();
			if (palabra.charAt(posicion) == caracter) {
				posicion++;
			} else {
				esPalindromo = false;
				break;
			}
		}
		return esPalindromo;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack<Character> pilaCaracteres = new Stack<Character>();
		
		String palabra = Helper.leerCadena(input, "Ingrese una palabra que sea capicua: ");
		cargarPila(pilaCaracteres, palabra);
		if (esPalindromo(pilaCaracteres, palabra)) {
			System.out.println("La palabra " + palabra + " si es un palindromo");
		} else {
			System.out.println("La palabra " + palabra + " no es un palindromo");
		}
	}

}
