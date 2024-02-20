package mx.com.qtx.util;

import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

public class SistemaJVM {
	
	public static void mostrarVariablesDeAmbiente(){
    	System.out.println("Variables de ambiente:---------------------------");
    	System.getenv().forEach((k,v)->System.out.printf("%-31s:[%s]\n",k,v));
    	System.out.println();
	}
	
	public static void mostrarPropiedadesJVM(){
    	System.out.println("Propiedades System ==========================");
    	Properties propiedades = System.getProperties();
    	propiedades.list(System.out);
       	System.out.println();
	}
	
	public static String getUserTimezone(){
		return System.getProperty("user.timezone");
	}
	public static void setUserTimezone(String timeZone){
		System.setProperty("user.timezone", timeZone);
	}
	public static String getUserCountry(){
		return System.getProperty("user.country");
	}
	public static void setUserCountry(String country){
		System.setProperty("user.country", country);
	}
	public static String getUserLanguage(){
		return System.getProperty("user.language");
	}
	public static void setUserLanguage(String userLanguage){
		System.setProperty("user.language", userLanguage);
	}
	
	public static void mostrarTimeZoneYLocaleDefault(){
		System.out.println("\nDefaults:--------------------------");
		TimeZone timeZoneDefault = TimeZone.getDefault();
		Locale localeDefault = Locale.getDefault();
		System.out.println("TimeZone->"+timeZoneDefault.getID()
				+" ("+timeZoneDefault.getDisplayName(Locale.US)+")");
		
		System.out.println("Localidad(Locale)->"+localeDefault.getDisplayName());
		System.out.println("--------------------------------------");
	}
	
	public static void mostrarPropiedadesSysLocalidad(){
		System.out.println("\nPropiedades sobre localidad --------");
		System.out.println("user.Language:"+SistemaJVM.getUserLanguage());
		System.out.println("user.Country:"+SistemaJVM.getUserCountry());
		System.out.println("--------------------------------------");
	}
	
}
