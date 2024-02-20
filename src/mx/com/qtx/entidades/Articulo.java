package mx.com.qtx.entidades;

import java.io.Serializable;

public class Articulo implements Serializable{
	private String clave;
	private String descripcion;
	private int cantidadExistencia;
	private double precio;

	private static final long serialVersionUID = 1L;

	public Articulo(String clave, String descripcion, int cantidadExistencia,
			double precio) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.cantidadExistencia = cantidadExistencia;
		this.precio = precio;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidadExistencia() {
		return cantidadExistencia;
	}
	public void setCantidadExistencia(int cantidadExistencia) {
		this.cantidadExistencia = cantidadExistencia;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulo [clave=" + clave + ", descripcion=" + descripcion
				+ ", cantidadExistencia=" + cantidadExistencia + ", precio="
				+ precio + "]";
	}
	
}
