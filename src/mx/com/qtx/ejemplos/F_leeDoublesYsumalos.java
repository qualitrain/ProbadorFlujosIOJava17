package mx.com.qtx.ejemplos;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class F_leeDoublesYsumalos {
	public static void main(String[] args)throws IOException {
		// Ejemplo de lectura de un archivo con numeros de punto flotante
		String nombreArchivoEntrada = "numeros.txt";
        double suma = 0;

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nombreArchivoEntrada)))){
            scanner.useLocale(Locale.US);

            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    suma += scanner.nextDouble();
                } 
                else {
                    scanner.next();
                }   
            }
        } 
        catch(Exception ex) {
        	System.out.println("Error:" + ex.getClass().getName() + " [" + ex.getMessage() + "]");
        } 

        System.out.println(suma);
	}

}
