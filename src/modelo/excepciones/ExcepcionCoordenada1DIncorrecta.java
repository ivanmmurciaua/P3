package modelo.excepciones;

/**
 * The Class ExcepcionCoordenada1DIncorrecta.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** The x. */
	private int x;
	
	/**
	 * Instantiates a new excepcion coordenada 1 D incorrecta.
	 *
	 * @param x the x
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x=x;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return "ExcepcionCoordenada1D";
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}
}
