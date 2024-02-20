package mx.com.qtx.ejemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import mx.com.qtx.entidades.Articulo;

public class J_EjmDataStreams { // Este ejemplo muetra como escribir y leer archivos de datos
	                            // a traves del uso de DataOutputStream y DataInputStream

	public static void generarArchivoDeDatos(String nombreArchivo, 
    									     ArrayList<Articulo> listaArticulos){
		
        try (DataOutputStream flujoDatosDeSalida = new DataOutputStream(new
                BufferedOutputStream(new FileOutputStream(nombreArchivo)))){
        	
        	for(Articulo art:listaArticulos){
        		flujoDatosDeSalida.writeUTF(art.getClave());
        		flujoDatosDeSalida.writeUTF(art.getDescripcion());
        		flujoDatosDeSalida.writeInt(art.getCantidadExistencia());
        		flujoDatosDeSalida.writeDouble(art.getPrecio());
        	}
        }
        catch(Exception ex) {
        	System.out.println("Error:" + ex.getClass().getName() + " [" + ex.getMessage() + "]");
        } 
    }
    
    public static ArrayList<Articulo> leerArchivoDeDatos(String nombreArchivo){
    	ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    	
        try (DataInputStream flujoDatosEntrada = new DataInputStream(new
                BufferedInputStream(new FileInputStream(nombreArchivo)))) {
         	while(true){
        		String claveArt = flujoDatosEntrada.readUTF();
        		String descripcionArt = flujoDatosEntrada.readUTF();
        		int cantidadExistenciaArt = flujoDatosEntrada.readInt();
        		double precioArt = flujoDatosEntrada.readDouble();
        		
        		listaArticulos.add(new Articulo(claveArt,descripcionArt,cantidadExistenciaArt,precioArt));
        	}
        }
        catch (EOFException e) {
        	return listaArticulos;
        }
        catch(Exception ex) {
        	System.out.println("Error:" + ex.getClass().getName() + " [" + ex.getMessage() + "]");
        	return null;
        } 
   	
    }
    
    public static void main(String[] args) throws IOException {

    	ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    	listaArticulos.add(new Articulo("1-1","Carburador",5,455.60));
    	listaArticulos.add(new Articulo("1-2","Bujia",67,35.15));
    	listaArticulos.add(new Articulo("X-34RG","Junta",34,5.0));
    	listaArticulos.add(new Articulo("Y-12","Abrazadera",0,233.40));
    	listaArticulos.add(new Articulo("1-99","Flecha direcci�n",3,788.99));
    	
    	generarArchivoDeDatos("articulos.dat", listaArticulos);
    	ArrayList<Articulo> articulosLeidos = leerArchivoDeDatos("articulos.dat");
    	for(Articulo art:articulosLeidos){
    		System.out.println(art);
    	}
    }
 
}
