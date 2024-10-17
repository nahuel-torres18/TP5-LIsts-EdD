package ejercicio_2;

import java.time.LocalDate;

public class Alumno {
	private int lu;
	private String nombre;
	private int dni;
	private LocalDate fechaNacimiento;
	private String correoElectronico;
	private LocalDate fechaIngreso;
	
	public Alumno() {
		
	}

	public Alumno(int lu, String nombre, int dni, LocalDate fechaNacimiento, String correoElectronico, LocalDate fechaIngreso) {
		this.lu = lu;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.correoElectronico = correoElectronico;
		this.fechaIngreso = fechaIngreso;
	}

	public int getLu() {
		return lu;
	}

	public void setLu(int lu) {
		this.lu = lu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Alumno [lu=" + lu + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
				+ ", correoElectronico=" + correoElectronico + ", fechaIngreso=" + fechaIngreso + "]";
	}
}
