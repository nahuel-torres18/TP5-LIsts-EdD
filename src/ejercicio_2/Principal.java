package ejercicio_2;

import java.time.LocalDate;
import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void agregaAlumnoAlPrincipio(DoubleLinkedList<Alumno> listaAlumnos, Scanner input) {
		Alumno alumno = new Alumno(Helper.validarEntero(input, "Ingrese el numero de libreta universitaria: "),
								   Helper.leerCadena(input, "Ingrese el nombre del alumno: "),
								   Helper.validarDNI(input, "Ingrese el DNI del alumno: "),
								   LocalDate.of(Helper.validarEntero(input, "Ingrese el año de nacimiento: "), Helper.validarEntero(input, "Ingrese el mes de nacimiento: "), Helper.validarEntero(input, "Ingrese el dia de nacimiento: ")),
								   Helper.leerCadena(input, "Ingrese el correo electronico: "),
								   LocalDate.of(Helper.validarEntero(input, "Ingrese el año de ingreso: "), Helper.validarEntero(input, "Ingrese el mes de ingreso: "), Helper.validarEntero(input, "Ingrese el dia de ingreso: ")));
		listaAlumnos.addFirst(alumno);
		System.out.println("CONTADOR: "+listaAlumnos.size());
	}
	
	public static void agregarAlumnoAlFinal(DoubleLinkedList<Alumno> listaAlumnos, Scanner input) {
		Alumno alumno = new Alumno(Helper.validarEntero(input, "Ingrese el numero de libreta universitaria: "),
				   Helper.leerCadena(input, "Ingrese el nombre del alumno: "),
				   Helper.validarDNI(input, "Ingrese el DNI del alumno: "),
				   LocalDate.of(Helper.validarEntero(input, "Ingrese el año de nacimiento: "), Helper.validarEntero(input, "Ingrese el mes de nacimiento: "), Helper.validarEntero(input, "Ingrese el dia de nacimiento: ")),
				   Helper.leerCadena(input, "Ingrese el correo electronico: "),
				   LocalDate.of(Helper.validarEntero(input, "Ingrese el año de ingreso: "), Helper.validarEntero(input, "Ingrese el mes de ingreso: "), Helper.validarEntero(input, "Ingrese el dia de ingreso: ")));
		listaAlumnos.addLast(alumno);
		System.out.println("CONTADOR: "+listaAlumnos.size());
	}
	
	public static void agregarAlumnoEnPosicion(DoubleLinkedList<Alumno> listaAlumnos, Scanner input) {
		Alumno alumno = new Alumno(Helper.validarEntero(input, "Ingrese el numero de libreta universitaria: "),
				   Helper.leerCadena(input, "Ingrese el nombre del alumno: "),
				   Helper.validarDNI(input, "Ingrese el DNI del alumno: "),
				   LocalDate.of(Helper.validarEntero(input, "Ingrese el año de nacimiento: "), Helper.validarEntero(input, "Ingrese el mes de nacimiento: "), Helper.validarEntero(input, "Ingrese el dia de nacimiento: ")),
				   Helper.leerCadena(input, "Ingrese el correo electronico: "),
				   LocalDate.of(Helper.validarEntero(input, "Ingrese el año de ingreso: "), Helper.validarEntero(input, "Ingrese el mes de ingreso: "), Helper.validarEntero(input, "Ingrese el dia de ingreso: ")));
		int posicion = Helper.validarEntero(input, "Ingrese la posicion donde desea agregar al alumno: ");
		listaAlumnos.insertarEnPosicion(alumno, posicion);
		System.out.println("CONTADOR: "+listaAlumnos.size());
	}
	
	public static void mostrar(DoubleLinkedList<Alumno> listaAlumnos) {
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno);
		}
	}
	
	public static void menu(Scanner input) {
		boolean verdad = true;
		DoubleLinkedList<Alumno> listaAlumnos = new DoubleLinkedList<Alumno>();
		while (verdad) {
			System.out.println("--- MENU DE OPCIONES ---");
			System.out.println("1. Insertar alumno al principio de la lista");
			System.out.println("2. Insertar alumno al final de la lista");
			System.out.println("3. Insertar alumno en un posicion en especifico");
			System.out.println("4. Mostrar lista de alumnos");
			System.out.println("5. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					agregaAlumnoAlPrincipio(listaAlumnos, input);
					break;
				case 2:
					agregarAlumnoAlFinal(listaAlumnos, input);
					break;
				case 3:
					agregarAlumnoEnPosicion(listaAlumnos, input);
					break;
				case 4:
					mostrar(listaAlumnos);
					break;
				case 5:
					System.out.println("--- FIN DEL PROGRAMA ---");
					verdad = false;
					break;
				default:
					System.out.println("--- OPCION NO VALIDA ---");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
	}
}
