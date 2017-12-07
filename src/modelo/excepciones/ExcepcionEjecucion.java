package modelo.excepciones;

/**
 * The Class ExcepcionEjecucion.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ExcepcionEjecucion extends RuntimeException {
	
	/**
	 * Instantiates a new excepcion ejecucion.
	 *
	 * @param mensaje the mensaje
	 */
	public ExcepcionEjecucion (String mensaje) {
		super(mensaje);
	}
	
	/**
	 * Instantiates a new excepcion ejecucion.
	 *
	 * @param causa the causa
	 */
	public ExcepcionEjecucion (Throwable causa) {
		super(causa);
	}

}
