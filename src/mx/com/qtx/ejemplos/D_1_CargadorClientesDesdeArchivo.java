package mx.com.qtx.ejemplos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import mx.com.qtx.entidades.Cliente;

public class D_1_CargadorClientesDesdeArchivo {
	// Esta expresion regular hara que se lean cadenas SIN eliminar espacios iniciales ni caracteres de fin de linea
	private static final String EXPR_DELIM_COMA_SIMPLE = ",";
	
	// Esta expresion regular declara que el terminador esta formado por cero o mas blancos, seguidos de una coma
	// y TRAS la coma siguen cero o mas blancos
	private static final String EXPR_DELIM_COMA_CON_BLANCOS_GENERICOS = "\\s*,\\s*";
	
	private String nombreArchivo;
	
	public D_1_CargadorClientesDesdeArchivo(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	public List<Cliente> cargaClientes(){
		ArrayList<Cliente> clientesLeidos = new ArrayList<Cliente>();
		try(Scanner lector = new Scanner(new BufferedReader(new FileReader(this.nombreArchivo)))){
//			lector.useDelimiter(EXPR_DELIM_COMA_SIMPLE);
			lector.useDelimiter(EXPR_DELIM_COMA_CON_BLANCOS_GENERICOS);

			System.out.println("Delimitador registrado:"+lector.delimiter().pattern());
			while(true){
				Cliente clienteI = this.leeCliente(lector);
				if(clienteI == null)
					break;
				clientesLeidos.add(clienteI);
			}
		} 
		catch (FileNotFoundException fnfEx) {
        	System.out.println("No existe archivo: [" + fnfEx.getMessage());
        	return null;
		}
		return clientesLeidos;
		
	}
	
	private Cliente leeCliente(Scanner lector) {
		Cliente clienteLeido=null;
		try{
			String nombre = lector.next();
			System.out.println("nombre->"+nombre+"<-");
			String direccion = lector.next();
			System.out.println("direccion->"+direccion+"<-");
			String cadEdad = lector.next();
			System.out.println("cadEdad->"+cadEdad+"<-");
			clienteLeido = new Cliente(nombre, direccion, Integer.parseInt(cadEdad));
		}
		catch(NumberFormatException ex){
			System.out.println("Error de formato en conversion de edad:");
			System.out.println("Causa origen: "+ex.getMessage());
			return null;
		}
		catch(NoSuchElementException ex){
			System.out.println("Fin de Archivo");
			return null;
		}
		return clienteLeido;
	}

	public static void main(String[] args) {
		D_1_CargadorClientesDesdeArchivo cargadorCtes = new D_1_CargadorClientesDesdeArchivo("clientes.txt");
		List<Cliente> clientes = cargadorCtes.cargaClientes();
		for(Cliente cteI:clientes)
			System.out.println(cteI);
	}

}
