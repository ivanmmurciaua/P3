package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

/**
 * The Interface IParserTablero.
 * 
 *  @author Iván Mañús Murcia 48729799K
 */
public interface IParserTablero {
	
	/**
	 * Lee tablero.
	 *
	 * @param s the string
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public Tablero<?> leeTablero(String s) throws ExcepcionLectura;
}
