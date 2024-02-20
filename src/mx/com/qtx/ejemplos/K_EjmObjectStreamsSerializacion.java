package mx.com.qtx.ejemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import mx.com.qtx.entidades.Articulo;
import mx.com.qtx.entidades.DetalleVenta;
import mx.com.qtx.entidades.Venta;

public class K_EjmObjectStreamsSerializacion {
	
	public static void serializarObjetoVenta(String nombreArchivo, Venta unaVenta)throws IOException{
		
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(
            				                      new BufferedOutputStream ( 
            					                      new FileOutputStream(nombreArchivo)))){
            flujoSalida.writeObject(unaVenta);
        }
        catch(Exception ex) {
        	System.out.println("Error:" + ex.getClass().getName() + " [" + ex.getMessage() + "]");
        }
	}
	
	public static Venta desSerializarObjetoVenta(String nombreArchivo){
		Venta unaVenta = null;
		try (ObjectInputStream flujoEntrada = new ObjectInputStream(
							new BufferedInputStream (
									new FileInputStream (nombreArchivo)))){
			unaVenta = (Venta)flujoEntrada.readObject();
			return unaVenta;
		}
        catch(Exception ex) {
        	System.out.println("Error:" + ex.getClass().getName() + " [" + ex.getMessage() + "]");
        	return null;
        }
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Primero "arma" un venta para despues serializarla y deserializarla
		
		Venta unaVenta = getVenta();
    	unaVenta.mostrarVenta();
    	
    	System.out.println("Serializando...");
    	K_EjmObjectStreamsSerializacion.serializarObjetoVenta("ventas.dat",unaVenta);

    	System.out.println("Deserializando...");
    	Venta ventaRecuperada = K_EjmObjectStreamsSerializacion.desSerializarObjetoVenta("ventas.dat");
    	ventaRecuperada.mostrarVenta();

	}

	private static Venta getVenta() {
		Venta unaVenta = new Venta(235L,new Date(),25);
		
    	ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    	listaArticulos.add(new Articulo("1-1","Carburador",5,455.60));
    	listaArticulos.add(new Articulo("1-2","Bujia",67,35.15));
    	listaArticulos.add(new Articulo("X-34RG","Junta",34,5.0));
    	listaArticulos.add(new Articulo("Y-12","Abrazadera",0,233.40));
    	listaArticulos.add(new Articulo("1-99","Flecha direccion",3,788.99));
    	
    	int numDetalle = 1;
    	for(Articulo art:listaArticulos){
    		int cantidad = (numDetalle%3)+1; // Una cantidad hipotetica de 1 a 3
    		unaVenta.agregarDetalleVenta(new DetalleVenta(numDetalle++,cantidad, art.getPrecio(),art ));
    	}
		return unaVenta;
	}

}
