package modelo.excepciones;
import modelo.*;

/**
 * The Class ExcepcionPosicionFueraTablero.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ExcepcionPosicionFueraTablero extends Exception {
	
	/** The dimensiones. */
	private Coordenada dimensiones;
	
	/** The coordenada. */
	private Coordenada coordenada;
	
	/**
	 * Instantiates a new excepcion posicion fuera tablero.
	 *
	 * @param coor the coor
	 * @param dims the dims
	 */
	public ExcepcionPosicionFueraTablero(Coordenada coor, Coordenada dims) {
		this.coordenada=coor;
		this.dimensiones=dims;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return "Posicion fuera de tablero";
	}
	
	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {
		return this.dimensiones;
	}
	
	/**
	 * Gets the coordenada.
	 *
	 * @return the coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
	

}
