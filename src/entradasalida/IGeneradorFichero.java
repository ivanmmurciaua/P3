package entradasalida;

import java.io.File;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

/**
 * The Interface IGeneradorFichero.
 * 
 *  @author Iván Mañús Murcia 48729799K
 */
public interface IGeneradorFichero {
	
	/**
	 * Genera fichero.
	 *
	 * @param f the file
	 * @param j the game
	 * @param n the iterations
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public void generaFichero(File f, Juego<?> j, int n) throws ExcepcionGeneracion;
}
