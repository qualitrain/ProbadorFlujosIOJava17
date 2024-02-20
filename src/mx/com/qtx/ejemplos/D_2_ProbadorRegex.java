package mx.com.qtx.ejemplos;

import mx.com.qtx.util.ValidadorCampos;

public class D_2_ProbadorRegex {
	public static void main(String[] args){
		
		D_2_ProbadorRegex.hacerPruebasPatronInicioConBlancos();
		D_2_ProbadorRegex.hacerPruebasPatronUsuario();
		D_2_ProbadorRegex.hacerPruebasPatronEmail();
		
		
	}
	public static void hacerPruebasPatronEmail(){
		System.out.println();
		System.out.println("----------------------------- Pruebas patron de E mail ---------------------------");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz@disneyworld.com.ru");
		D_2_ProbadorRegex.probarPatronEmail("alex@disneyworld.com.ru");
		D_2_ProbadorRegex.probarPatronEmail("1_alex@disneyworld.com.ru");
		D_2_ProbadorRegex.probarPatronEmail("ale@disneyworld.com.ru");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz.rojas@disneyworld.com.ru");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz.rojas#disneyworld.com.ru");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz.rojas@disneyworld.com");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz.rojas@disneyworld");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz.rojas@disneyworld.c");
		D_2_ProbadorRegex.probarPatronEmail("alex.cruz.rojas@disneyworld.commx");
		System.out.println("----------------------------------------------------------------------------------");

	}

	public static void hacerPruebasPatronUsuario(){
		System.out.println();
		System.out.println("----------------------------- Pruebas patron de usuario -------------------------");
		D_2_ProbadorRegex.probarPatronUsuario("   alex");
		D_2_ProbadorRegex.probarPatronUsuario("alexito");
		D_2_ProbadorRegex.probarPatronUsuario("ale/xito");
		D_2_ProbadorRegex.probarPatronUsuario("Alexito");
		D_2_ProbadorRegex.probarPatronUsuario("ale_xito");
		D_2_ProbadorRegex.probarPatronUsuario("ale");
		D_2_ProbadorRegex.probarPatronUsuario("alexito_cruz_rojas");
		D_2_ProbadorRegex.probarPatronUsuario("alexito_cruz_ro");
		D_2_ProbadorRegex.probarPatronUsuario("123456789012345");
		System.out.println("----------------------------------------------------------------------------------");

	}
	public static void hacerPruebasPatronInicioConBlancos(){
		System.out.println();
		System.out.println("-------------------- Pruebas patron de inicio con blancos ------------------------");
		D_2_ProbadorRegex.probarPatronInicioConBlancos("      Hola a todos con varios espacios al principio");
		D_2_ProbadorRegex.probarPatronInicioConBlancos(" Hola a todos con 1 espacio al principio");
		D_2_ProbadorRegex.probarPatronInicioConBlancos(" \t\nHola a todos con tabulador y salto de linea");
		D_2_ProbadorRegex.probarPatronInicioConBlancos("Hola a todos sin blancos al inicio");
		D_2_ProbadorRegex.probarPatronInicioConBlancos("");
		D_2_ProbadorRegex.probarPatronInicioConBlancos("   ");
		D_2_ProbadorRegex.probarPatronInicioConBlancos("   Hola");
		System.out.println("----------------------------------------------------------------------------------");

	}
	public static void probarPatronInicioConBlancos(String cadena){
		if(ValidadorCampos.cadenaIniciandoConBlancos(cadena))
			System.out.println("La cadena ->"
					+ cadena+"<- coincide con el patron de inicio con blancos("
							+ValidadorCampos.REGEX_CAD_INICIA_C_BLANCOS +")");
		else
			System.out.println("La cadena ->"
					+ cadena+"<- NO coincide con el patron de inicio con blancos("
							+ValidadorCampos.REGEX_CAD_INICIA_C_BLANCOS +")");
	}
	public static void probarPatronUsuario(String cadena){
		if(ValidadorCampos.cadenaFormatoUsuaro(cadena))
			System.out.println("La cadena ->"
					+ cadena+"<- coincide con el patron de usuario("
							+ValidadorCampos.REGEX_USUARIO +")");
		else
			System.out.println("La cadena ->"
					+ cadena+"<- NO coincide con el patron de usuario("
							+ValidadorCampos.REGEX_USUARIO +")");
	}
	public static void probarPatronEmail(String cadena){
		if(ValidadorCampos.cadenaFormatoEmail(cadena))
			System.out.println("La cadena ->"
					+ cadena+"<- coincide con el patron de Email("
							+ValidadorCampos.REGEX_EMAIL_A +")");
		else
			System.out.println("La cadena ->"
					+ cadena+"<- NO coincide con el patron de Email("
							+ValidadorCampos.REGEX_EMAIL_A +")");
	}
}
