package mx.com.qtx.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Venta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long numVenta;
	private Date fechaVenta; 
	private int diasVencimiento;
	private ArrayList<DetalleVenta> detallesVenta;
	
	public Venta(long numVenta, Date fechaVenta, int diasVencimiento) {
		super();
		this.numVenta = numVenta;
		this.fechaVenta = fechaVenta;
		this.diasVencimiento = diasVencimiento;
		this.detallesVenta = new ArrayList<DetalleVenta>();
	}
	public void agregarDetalleVenta(DetalleVenta detVenta){
		this.detallesVenta.add(detVenta);
	}
	public long getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(long numVenta) {
		this.numVenta = numVenta;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public int getDiasVencimiento() {
		return diasVencimiento;
	}
	public void setDiasVencimiento(int diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}
	@Override
	public String toString() {
		return "Venta [numVenta=" + numVenta + ", fechaVenta=" + fechaVenta
				+ ", diasVencimiento=" + diasVencimiento + ", detallesVenta="
				+ detallesVenta + "]";
	}
	public void mostrarVenta() {
		double totalVenta = 0;
		System.out.println("Venta numero:"+this.numVenta+", fecha:"+this.fechaVenta+", dias vencimiento:"+this.diasVencimiento);
		for (DetalleVenta detVta:this.detallesVenta){
			double totalDetalle = detVta.getCantidad()*detVta.getPrecioAplicado();
			totalVenta+=totalDetalle;
			System.out.println(detVta.getNumDetalle()+".- "+detVta.getCantidad()+" "+detVta.getArticuloVendido().getDescripcion()+
					"("+detVta.getArticuloVendido().getClave()+") a $"+detVta.getPrecioAplicado()+" = $"+totalDetalle);
		}
		System.out.println("==================================================================");
		System.out.println("                                         Total: "+ totalVenta);
	}

}
