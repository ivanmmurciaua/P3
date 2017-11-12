package modelo;
import modelo.excepciones.*;

/**
 * The Class Coordenada.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public abstract class Coordenada {
	
	/**
	 * Instantiates a new coordenada.
	 */
	public Coordenada() {}
	
	/**
	 * Suma.
	 *
	 * @param c the c
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public abstract Coordenada suma(Coordenada c) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos;

}