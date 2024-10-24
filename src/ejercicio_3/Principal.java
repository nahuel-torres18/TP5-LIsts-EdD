package ejercicio_3;

import java.time.LocalDate;
import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void agregarDeuda(DoubleLinkedList<Deuda> listaDeudad, Scanner input) {
		Deuda deudas = new Deuda(Helper.validarEntero(input, "Ingrese el codigo: "), 
				Helper.leerCadena(input, "Ingrese la descripcion: "), 
				Helper.leerCadena(input, "Ingrese el nombre del acreedor: "), 
				LocalDate.of(Helper.validarEntero(input, "Ingrese el año de la deuda: "), Helper.validarEntero(input, "Ingrese el mes de la deuda: "), Helper.validarEntero(input, "Ingrese el dia de la deuda: ")), 
				Helper.validarEntero(input, "Ingrese el monto a pagar: "));
		listaDeudad.addLast(deudas);
	}
	
	public static boolean eliminarDeudaPorCodigo(DoubleLinkedList<Deuda> listaDeudas, Scanner input) {
		int codigo = Helper.validarEntero(input, "Ingrese el codigo de la deuda que quiere eliminar: ");
		return listaDeudas.eliminarPorCodigo(codigo);
	}
	
	public static boolean eliminarDeudaPorNombreAcredor(DoubleLinkedList<Deuda> listaDeudas, Scanner input) {
		String nombre = Helper.leerCadena(input, "Ingrese el nombre del acredor de la deuda a eliminar: ");
		return listaDeudas.eliminarPorNombreAcredor(nombre);
	}
	
	public static void mostrar(DoubleLinkedList<Deuda> listaDeudas) {
		for (Deuda deuda : listaDeudas) {
			System.out.println(deuda);
		}
	}
	
	public static void menu(Scanner input) {
		boolean verdad = true;
		DoubleLinkedList<Deuda> listaDeudad = new DoubleLinkedList<Deuda>();
		while (verdad) {
			System.out.println("1. Agregar deuda");
			System.out.println("2. Eliminar deuda por codigo");
			System.out.println("3. Eliminar deuda por nombre de acreedor");
			System.out.println("4. Mostrar lista de deudas");
			System.out.println("5. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					agregarDeuda(listaDeudad, input);
					break;
				case 2:
					if (eliminarDeudaPorCodigo(listaDeudad, input)) {
						System.out.println("Se elimino la deuda correctamente");
					} else {
						System.out.println("La deudad no existe o se ingreso mal el codigo");
					}
					break;
				case 3:
					if (eliminarDeudaPorNombreAcredor(listaDeudad, input)) {
						System.out.println("Se elimino la deuda correctamente");
					} else {
						System.out.println("La deuda no existe o se ingreso mal el nombre del acredor");
					}
					break;
				case 4:
					mostrar(listaDeudad);
					break;
				case 5:
					verdad = false;
					System.out.println("--- FIN DEL PROGRAMA ---");
					break;
				default:
					System.out.println("--- OPCION FUERA DE RANGO ---");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
	}
}
