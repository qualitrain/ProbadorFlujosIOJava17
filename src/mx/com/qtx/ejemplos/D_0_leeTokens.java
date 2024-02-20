package mx.com.qtx.ejemplos;

import java.io.*;
import java.util.Scanner;
public class D_0_leeTokens {

	public static void main(String[] args)  throws IOException  {
		// Ejemplo de lectura de tokens desde un archivo y despliegue en la salida estandar
			String nombreArchivoEntrada = "patitoUtf8.txt";

	        try (Scanner scanner = new Scanner(
	        		                   new BufferedReader( 
	        		                	   new FileReader(nombreArchivoEntrada) ) )){
	            while (scanner.hasNext()) {
	                System.out.println(scanner.next());
	            }
	        }
	        catch(FileNotFoundException fnfEx) {
	        	System.out.println("No existe archivo: [" + fnfEx.getMessage());
	        }
	}

}
