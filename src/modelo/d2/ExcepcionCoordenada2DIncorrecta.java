package modelo.d2;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class ExcepcionCoordenada2DIncorrecta.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/**
	 * Instantiates a new excepcion coordenada 2 D incorrecta.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return "ExcepcionCoordenada2D";
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	

}
