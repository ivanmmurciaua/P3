package entradasalida.excepciones;

/**
 * The Class ExcepcionLectura.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ExcepcionLectura extends Exception {
	
	/**
	 * Instantiates a new excepcion lectura.
	 */
	public ExcepcionLectura(){super();}
	
	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param s the s
	 */
	public ExcepcionLectura(String s) {super(s);}
	
	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param t the t
	 */
	public ExcepcionLectura(Throwable t) {super(t);}

}
