package modelo;
import modelo.excepciones.*;

/**
 * The Class Regla.
 * 
 * @author Iván Mañús Murcia 48729799K
 * @param <TipoCoordenada> el tipo generico que extiende a Coordenada
 */
public abstract class Regla<TipoCoordenada extends Coordenada> {
	
	/**
	 * Instantiates a new regla.
	 */
	public Regla() {}
	
	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tab the tab
	 * @param coor the coor
	 * @return the estado celda
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero<TipoCoordenada> tab, TipoCoordenada coor) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero;

}
