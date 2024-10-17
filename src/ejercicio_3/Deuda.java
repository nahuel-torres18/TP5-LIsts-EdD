package ejercicio_3;

import java.time.LocalDate;

public class Deuda {
	private int codigo;
	private String descripcion;
	private String nombreAcredor;
	private LocalDate fechaDeuda;
	private int montoPagar;
	
	public Deuda(int codigo, String descripcion, String nombreAcredor, LocalDate fechaDeuda, int montoPagar) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombreAcredor = nombreAcredor;
		this.fechaDeuda = fechaDeuda;
		this.montoPagar = montoPagar;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreAcredor() {
		return nombreAcredor;
	}

	public void setNombreAcredor(String nombreAcredor) {
		this.nombreAcredor = nombreAcredor;
	}

	public LocalDate getFechaDeuda() {
		return fechaDeuda;
	}

	public void setFechaDeuda(LocalDate fechaDeuda) {
		this.fechaDeuda = fechaDeuda;
	}

	public int getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(int montoPagar) {
		this.montoPagar = montoPagar;
	}

	@Override
	public String toString() {
		return "Deuda [codigo=" + codigo + ", descripcion=" + descripcion + ", nombreAcredor=" + nombreAcredor
				+ ", fechaDeuda=" + fechaDeuda + ", montoPagar=" + montoPagar + "]";
	}
}
