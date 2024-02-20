package mx.com.qtx.ejemplos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Set;

public class B_DemoCaracteresYCharset {
	public static final int NO_EXISTE_ARCHIVO = -1;
	public static final int ERROR_GENERICO_ES = -99;
	public static final int EOF = -1;
	
	public static void main(String[] args) {
		/*
		explorarCharsetsDisponibles();
		explorarCharsets_codificacionVsDecodificacion();
		probarCopiaCharSetDistintos();
		probarCopiaChasetDefault();
		*/
		probarCopiaCharSetDistintos_Java10();
	}

	public static void explorarCharsets_codificacionVsDecodificacion() {
		 System.out.println("\n------------- Demo codificación y decodificación de caracteres -------------");
		Charset charset_Iso8859_1 = Charset.forName("ISO-8859-1");
		Charset charset_Utf8 = Charset.forName("UTF-8");
		
		String letras="ABCDEFGHIJKLOMNOPQRSTUVWXYZÁÉÍÓÚÑ";		
		
		for(int i=0; i<letras.length(); i++) {
			String caracterI = letras.charAt(i) + "";
			
			System.out.printf("Charset:%11s, caracter desde String(UTF-16):%s, ", charset_Iso8859_1, caracterI);
			byte[] bytesCodificados = codificarCaracterDesdeString(charset_Iso8859_1, caracterI);		 	
            mostrarBytes(bytesCodificados);
            System.out.printf("bytes decodificados con %11s:[%s]\n", charset_Iso8859_1, decodificarBytes(charset_Iso8859_1, bytesCodificados));
            System.out.printf("bytes decodificados con %11s:[%s]\n", charset_Utf8, decodificarBytes(charset_Utf8, bytesCodificados));
            System.out.println();
            
            System.out.printf("Charset:%11s, caracter desde String(UTF-16):%s, ", charset_Utf8, caracterI);
			bytesCodificados = codificarCaracterDesdeString(charset_Utf8, caracterI);		 	
            mostrarBytes(bytesCodificados);
            System.out.printf("bytes decodificados con %11s:[%s]\n", charset_Utf8, decodificarBytes(charset_Utf8, bytesCodificados));
            System.out.printf("bytes decodificados con %11s:[%s]\n", charset_Iso8859_1, decodificarBytes(charset_Iso8859_1, bytesCodificados));
            
            System.out.println("------------------------------------------------------------------------");
		}
	}
	
	public static void explorarCharsetsDisponibles() {
		 System.out.println("\n------------- Charset por defecto y otros Charsets disponibles -------------");
		 Charset charsetDefault = Charset.defaultCharset();
		 System.out.println("El Charset por defecto es " + charsetDefault);

		 Set<String> grupoAliases = charsetDefault.aliases();
		 System.out.println("Los aliases o sinónimos de " 
		         + charsetDefault.displayName() + " son:");
		 for(String aliasI : grupoAliases){
			 System.out.println(aliasI);
		 }
		 
		 System.out.println("\n Hay " + Charset.availableCharsets().size()
		 		+ " Charsets disponibles y son:");		 
		 for(String charsetI : Charset.availableCharsets().keySet()){
			 System.out.println("----" + charsetI + "----");
			 System.out.println("  Sus aliases o sinónimos son:");
			 for(String aliasI : Charset.availableCharsets().get(charsetI).aliases()){
				 System.out.println("\t"+ aliasI);
			 }
		 }
	}

	private static byte[] codificarCaracterDesdeString(Charset charsetDestino, String caracter) {
		byte[] bytesCodificados = charsetDestino.encode(caracter)
				                                .array();
		
		return bytesCodificados;
	}

	private static String decodificarBytes(Charset charsetOrigen, byte[] bytesCodificados) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytesCodificados);
		CharBuffer charBuffer = charsetOrigen.decode(byteBuffer);
		String cad = charBuffer.toString();  // Conversión a UTF-16
		return cad;
	}
	
	private static void mostrarBytes(byte[] bytesCodificados) {
		System.out.print("bytes:[");
		for(byte byteI:bytesCodificados) {
			int valCaracter = byteI & 0xff; //Apaga el bit de signo los de complemento-2
			System.out.print(valCaracter + " ");
		}
		System.out.println("]");
	}

	public static void probarCopiaCharSetDistintos() {
		System.out.println("\n------------- Probar copia de un Charset a otro -------------");
		String nombreArcEntrada = "patitoUtf8.txt";
		String nombreSalida = "patitoIso8859_1_b.txt";
		
		
		String nombreCharsetActivo = Charset.defaultCharset().displayName();
		System.out.println("Charset activo:" + nombreCharsetActivo);
		
		Charset charsetIso8859_1 = Charset.forName("ISO-8859-1");
		Charset charsetUtf8 = Charset.forName("UTF-8");
		
		long nCharsCopiados = copiarArchivoCharXChar(nombreArcEntrada,charsetUtf8, nombreSalida, charsetIso8859_1);
		if(nCharsCopiados > 0) {
			System.out.println("Fin exitoso. Se copiaron " + nCharsCopiados + " caracteres de " 
						+ nombreArcEntrada + " a " + nombreSalida);
		}
	}
	
	public static void probarCopiaCharSetDistintos_Java10() {
		System.out.println("\n------------- Probar copia de un Charset a otro, con transfer-------------");
		String nombreArcEntrada = "patitoUtf8.txt";
		String nombreSalida = "patitoIso8859_1_b.txt";
		
		
		String nombreCharsetActivo = Charset.defaultCharset().displayName();
		System.out.println("Charset activo:" + nombreCharsetActivo);
		
		Charset charsetIso8859_1 = Charset.forName("ISO-8859-1");
		Charset charsetUtf8 = Charset.forName("UTF-8");
		
		
		
		long nCharsCopiados = copiarArchivoCharXCharJava10(nombreArcEntrada,charsetUtf8, nombreSalida, charsetIso8859_1);
		if(nCharsCopiados > 0) {
			System.out.println("Fin exitoso. Se copiaron " + nCharsCopiados + " caracteres de " 
						+ nombreArcEntrada + " a " + nombreSalida);
		}
	}

	private static long copiarArchivoCharXCharJava10(String nomArcFte, Charset charsetFte, String nomArcDest,
			                                         Charset charsetDest) {
		long nCaracteresCopiados = 0;
		
		try( FileReader arcEntrada = new FileReader(nomArcFte, charsetFte); 
		     FileWriter arcSalida = new FileWriter(nomArcDest, charsetDest)	){	
			nCaracteresCopiados = arcEntrada.transferTo(arcSalida);
		} 
		catch (FileNotFoundException e) {
			System.out.println("No existe archivo [" + e.getMessage() + "]");
			return NO_EXISTE_ARCHIVO;
		} 
		catch (Exception e) {
			System.out.println("Error de E/S [" + e.getClass().getName() + ":"
			        + e.getMessage() 
					+ Util.getCausa(e) + "]");
				return ERROR_GENERICO_ES;
		}	
		return nCaracteresCopiados;
	}	
	
	public static void probarCopiaChasetDefault() {
		System.out.println("\n------------- Probar copia de un archivo a otro con el mismo Charset -------------");
		String nombreArcEntrada = "patitoUtf8.txt";
		String nombreSalida = "textoSalidaUtf8.txt";
		
		String nombreCharsetActivo = Charset.defaultCharset().displayName();
		System.out.println("Charset activo:" + nombreCharsetActivo);
		
		long nCharsCopiados = copiarArchivoCharXChar(nombreArcEntrada, nombreSalida);
		if(nCharsCopiados > 0) {
			System.out.println("Fin exitoso. Se copiaron " + nCharsCopiados + " caracteres de " 
						+ nombreArcEntrada + " a " + nombreSalida);
		}
	}
		
	private static long copiarArchivoCharXChar(String nombreArcEntrada, String nombreSalida) {
		Charset charsetLocal = Charset.defaultCharset();
		return copiarArchivoCharXChar(nombreArcEntrada,charsetLocal,nombreSalida,charsetLocal);
	}

	public static long copiarArchivoCharXChar(String nomArcFte, Charset charsetFte, 
			                                  String nomArcDest, Charset charsetDest) {
		long nCaracteresCopiados = 0;
		
		try( FileReader arcEntrada = new FileReader(nomArcFte, charsetFte); 
		     FileWriter arcSalida = new FileWriter(nomArcDest, charsetDest)	){	
			int c;			
        	while(true){
        		c = arcEntrada.read();
        		if (c == EOF)
        			break;
        		arcSalida.write(c);
        		nCaracteresCopiados++;
        	}			
		} 
		catch (FileNotFoundException e) {
			System.out.println("No existe archivo [" + e.getMessage() + "]");
			return NO_EXISTE_ARCHIVO;
		} 
		catch (IOException e) {
			System.out.println("Error de E/S [" + e.getClass().getName() + ":"
			        + e.getMessage() 
					+ Util.getCausa(e) + "]");
				return ERROR_GENERICO_ES;
		}	
		return nCaracteresCopiados;
	}
	
	
}
