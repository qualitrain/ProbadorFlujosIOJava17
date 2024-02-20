package mx.com.qtx.ejemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class A_copiaBytes {
	public static final int NO_EXISTE_ARCHIVO = -1;
	public static final int ERROR_GENERICO_ES = -99;
	public static final int EOF = -1;

	public static void main(String[] args) {
		String nombreArcEntrada = "5278144-lg.jpg";
		String nombreSalida = "salida.jpg";
		long nBytesCopiados = copiarArchivoByteXByte(nombreArcEntrada, nombreSalida);
		if(nBytesCopiados > 0) {
			System.out.println("Fin exitoso. Se copiaron " + nBytesCopiados + " bytes de " 
						+ nombreArcEntrada + " a " + nombreSalida);
		}
	}
	
	public static long copiarArchivoByteXByte(String nomArcFte, String nomArcDest) {
		long nBytesCopiados = 0;
		
		try( FileInputStream arcEntrada = new FileInputStream(nomArcFte); 
		     FileOutputStream arcSalida = new FileOutputStream(nomArcDest)	){			
			int c;			
			while (true){
				c=arcEntrada.read();
				if(c==EOF)
					break;
				arcSalida.write(c);
				nBytesCopiados++;
			}			
		} 
		catch (FileNotFoundException e) {
			System.out.println("No existe archivo [" + e.getMessage() + "]");
			return NO_EXISTE_ARCHIVO;
		} 
		catch (IOException e) {
			System.out.println("Error de E/S [" + e.getClass().getName() + ":"
		        + e.getMessage() 
				+  Util.getCausa(e) + "]");
			return ERROR_GENERICO_ES;
		}
		
		return nBytesCopiados;
	}

}
