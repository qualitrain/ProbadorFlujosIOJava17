package mx.com.qtx.entidades;

import java.io.Serializable;

public class DetalleVenta implements Serializable{
	private int numDetalle;
	private int cantidad;
	private double precioAplicado;
	private Articulo articuloVendido;

	private static final long serialVersionUID = 1L;

	public DetalleVenta(int numDetalle, int cantidad, double precioAplicado,
		 Articulo articuloVendido) {
		super();
		this.numDetalle = numDetalle;
		this.cantidad = cantidad;
		this.precioAplicado = precioAplicado;
		this.articuloVendido = articuloVendido;
	}

	public int getNumDetalle() {
		return numDetalle;
	}

	public void setNumDetalle(int numDetalle) {
		this.numDetalle = numDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioAplicado() {
		return precioAplicado;
	}

	public void setPrecioAplicado(double precioAplicado) {
		this.precioAplicado = precioAplicado;
	}

	public Articulo getArticuloVendido() {
		return articuloVendido;
	}

	public void setArticuloVendido(Articulo articuloVendido) {
		this.articuloVendido = articuloVendido;
	}

	@Override
	public String toString() {
		return "DetallaVenta [numDetalle=" + numDetalle + ", cantidad="
				+ cantidad + ", precioAplicado=" + precioAplicado
				+ ", articuloVendido=" + articuloVendido + "]";
	}
	
}
