package mx.com.qtx.ejemplos;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import mx.com.qtx.util.SistemaJVM;

public class N_ProbadorPropiedadesSystem {

	public static void main(String[] args) {
		SistemaJVM.mostrarVariablesDeAmbiente();
		
		SistemaJVM.mostrarPropiedadesJVM();
		
		String cadTimeZone = SistemaJVM.getUserTimezone();
		System.out.println("Zona de tiempo configurada en la JVM->"+cadTimeZone+"<-");
		
		SistemaJVM.mostrarTimeZoneYLocaleDefault();
		
		ZoneId idTimeZone = ZonedDateTime.now().getZone();
		
		// Versión vieja: Se mantiene para permitir compatibilidad hacia atrás
		TimeZone timeZone = TimeZone.getTimeZone(idTimeZone.getId());
		
		System.out.println("Zona de tiempo---------");
		System.out.println("ID->"+timeZone.getID()+"<-");
		System.out.println("Display Name->"+timeZone.getDisplayName()+"<-");
		
	}
	
	

}
