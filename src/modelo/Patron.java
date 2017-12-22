package modelo;

import java.util.Collection;
import modelo.excepciones.*;

/**
 * The Class Patron.
 * 
 * @author Iván Mañús Murcia 48729799K
 * @param <TipoCoordenada> el tipo generico que extiende a Coordenada
 */
public class Patron<TipoCoordenada extends Coordenada> {
	
	/** The nombre. */
	private String nombre;
	
	/** The tablero. */
	Tablero<TipoCoordenada> tablero;

	/**
	 * Instantiates a new patron.
	 *
	 * @param nombre the nombre
	 * @param tablero the tablero
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Patron(String nombre,Tablero<TipoCoordenada> tablero) throws ExcepcionArgumentosIncorrectos{
		if(nombre==null||tablero==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			this.nombre=nombre;
			this.tablero=tablero;		
		}
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {return nombre;}
	
	/**
	 * Gets the celda.
	 *
	 * @param coor the coor
	 * @return the celda
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(TipoCoordenada coor) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero {
		if(coor==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		return tablero.getCelda(coor);
	}
	
	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection<TipoCoordenada> getPosiciones(){
		return tablero.getPosiciones();
	}
	
	/**
	 * toString Patron
	 *
	 * @return the string
	 */
	public String toString() {
		String cadena="";
		cadena=cadena+this.nombre+"\n";
		cadena=cadena+tablero.toString();
		return cadena;
	}

}