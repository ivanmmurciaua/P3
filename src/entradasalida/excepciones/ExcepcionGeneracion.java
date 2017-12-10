package entradasalida.excepciones;

/**
 * The Class ExcepcionGeneracion.
 * 
 *  @author Iván Mañús Murcia 48729799K
 */
public class ExcepcionGeneracion extends Exception {
	
	/**
	 * Instantiates a new excepcion generacion.
	 */
	public ExcepcionGeneracion(){super();}
	
	/**
	 * Instantiates a new excepcion generacion.
	 *
	 * @param s the string
	 */
	public ExcepcionGeneracion(String s) {super(s);}
	
	/**
	 * Instantiates a new excepcion generacion.
	 *
	 * @param t the obj throwable
	 */
	public ExcepcionGeneracion(Throwable t) {super(t);}
}
