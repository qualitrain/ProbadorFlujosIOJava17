package mx.com.qtx.ejemplos;

public class Util {
	public static String getCausa(Exception e) {
		if (e.getCause() == null)
			return "";
		return " causado por " + e.getCause().getClass().getName() 
				               + ":" + e.getCause().getMessage() ;
	}


}
