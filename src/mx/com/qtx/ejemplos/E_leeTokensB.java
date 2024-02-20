package mx.com.qtx.ejemplos;

import java.util.Scanner;
public class E_leeTokensB { //Ejemplo de lectura de tokens desde la entrada est�ndar

	public static void main(String[] args) {

        try(Scanner  scanner = new Scanner(System.in) ) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        catch(Exception ex) {
        	System.out.println("Error:" + ex.getClass().getName() + " [" + ex.getMessage() + "]");
        }
	}

}
