package mx.com.qtx.ejemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.util.Properties;

public class M_EjmSalvaYCargaProperties {

	/**
	 * Este ejemplo genera archivos properties en un flujo de bytes, otros de caracteres y en XML
	 * y luego recupera esas propiedades a partir de uno de los archivos
	 */
	public static void main(String[] args) throws Exception {
		FileOutputStream archivoStream = new FileOutputStream("datosOS.properties");
		FileWriter archivoWriter = new FileWriter("datosWriter.properties");
		FileOutputStream archivoXML = new FileOutputStream("datosOS.xml");
		
		Properties misPropiedades = new Properties();
		
		misPropiedades.setProperty("nombre", "Alejandro Cruz Rojas");
		misPropiedades.setProperty("direccion", "Av Insurgentes 4563, col Florida");
		misPropiedades.setProperty("telefono", "04455-56581111");
		
		misPropiedades.store(archivoStream , "Datos ejemplo con un OutputStream");
		misPropiedades.store(archivoWriter, "Datos ejemplo con un Writer");
		misPropiedades.storeToXML(archivoXML, "Datos ejemplo en XML");
		
		archivoStream.close();
		archivoWriter.close();
		archivoXML.close();
		
		FileInputStream archivoStreamEntrada = new FileInputStream("datosOS.properties");
		Properties propiedadesCargadas = new Properties();
		propiedadesCargadas.load(archivoStreamEntrada);
		
		propiedadesCargadas.list(System.out);
		
		archivoStreamEntrada.close();
		
		System.out.println("Fin");

	}

}
