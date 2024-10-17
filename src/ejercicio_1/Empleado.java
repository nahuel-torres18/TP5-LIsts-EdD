package ejercicio_1;

import java.time.LocalDate;

public class Empleado {
	private int numeroLegajo;
	private int dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String correo;
	
	public Empleado() {
		
	}

	public Empleado(int numeroLegajo, int dni, String nombre, LocalDate fechaNacimiento, String correo) {
		this.numeroLegajo = numeroLegajo;
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
	}

	public int getNumeroLegajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(int numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Empleado [numeroLegajo=" + numeroLegajo + ", dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", correo=" + correo + "]";
	}
}