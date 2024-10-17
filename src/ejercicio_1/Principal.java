package ejercicio_1;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
	
	public static void menu(Scanner input) {
		SimpleLinkedList<Empleado> lista = new SimpleLinkedList<>();
		boolean verdad = true;
		while (verdad) {
			System.out.println("---- MENU DE OPCIONES ----");
			System.out.println("1. Agregar un Empleado");
			System.out.println("2. Eliminar un Empleado");
			System.out.println("3. Buscar un Empleado");
			System.out.println("4. Mostrar los Empleados");
			System.out.println("5. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcio: ");
			switch (opcion) {
				case 1:
					lista.addFirst(new Empleado(Helper.validarEntero(input, "Ingrese el numero de legajo: "), 
							Helper.validarDNI(input, "Ingrese el DNI: "),
							Helper.leerCadena(input, "Ingrese su nombre: "),
							LocalDate.of(Helper.validarEntero(input, "Ingrese el año de nacimiento: "), Helper.validarEntero(input, "Ingrese mes de nacimiento: "), Helper.validarEntero(input, "Ingrese su fecha de nacimiento: ")),
							Helper.leerCadena(input, "Ingrese su correo electronico: ")));
					break;
				case 2:
					int numeroLegajo = Helper.validarEntero(input, "Ingrese el numero de legajo del empleado que quiere eliminar: ");
					if (lista.eliminarEmpleado(numeroLegajo)) {
						System.out.println("SE ENCONTRO AL EMPLEADO Y SE LO ELIMINO EXITOSAMENTE");
					}else {
						System.out.println("LA LISTA ESTA VACIA O NO SE ENCONTRO AL EMPLEADO");
					}
					break;
				case 3:
					if (buscarEmpleado(lista, input)) {
						System.out.println("EL EMPLEADO FIGURA EN LA LISTA");
					} else {
						System.out.println("EL EMPLEADO NO ESTA EN LA LISTA");
					}
					break;
				case 4:
					lista.mostrar();
					break;
				case 5:
					System.out.println("--- FIN DEL PROGRAMA ---");
					verdad = false;
					break;
				default:
					System.out.println("--- OPCION FUERA DE RANGO ---");
					break;
			}
		}
	}
	
	public static boolean buscarEmpleado(SimpleLinkedList<Empleado> lista, Scanner input) {
		int legajo = Helper.validarEntero(input, "Ingrese el numero de legajo del empleado que esta bucando: ");
		for (Empleado empleado : lista) {
			if (empleado.getNumeroLegajo() == legajo) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
	}
}
