package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import modelo.excepciones.*;

/**
 * The Class Juego.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class Juego {
	
	
	/** The regla. */
	private Regla regla;
	
	
	/** The tablero. */
	private Tablero tablero; 
	
	
	/** The patrones usados. */
	private ArrayList<Patron> patronesUsados=new ArrayList<Patron>();

	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Juego(Tablero tablero,Regla regla) throws ExcepcionArgumentosIncorrectos{
		if(tablero==null||regla==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			this.tablero=tablero;
			this.regla=regla;	
		}
	}
	

	/**
	 * Carga patron.
	 *
	 * @param pat the pat
	 * @param coor the coor
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void cargaPatron(Patron pat, Coordenada coor) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion,ExcepcionPosicionFueraTablero{
		if(pat==null||coor==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			tablero.cargaPatron(pat, coor);
			patronesUsados.add(pat);
		}
		
	}

	/**
	 * Actualiza.
	 *
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public void actualiza() throws ExcepcionEjecucion{
		Collection<Coordenada> posicionesactuales;
		EstadoCelda nuevo=EstadoCelda.MUERTA;
		HashMap<Coordenada,EstadoCelda> asiresulta = new HashMap<Coordenada,EstadoCelda>();
		posicionesactuales=tablero.getPosiciones();
		
		for(Coordenada c : posicionesactuales) {
			try {
				nuevo=regla.calculaSiguienteEstadoCelda(tablero, c);
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}
			asiresulta.put(c, nuevo);
		}
		
		for(Coordenada c : asiresulta.keySet()) {                //el keySet sirve para iterar por coordenadas
			try {
				tablero.setCelda(c, asiresulta.get(c));
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}
		}
	}
	
	/**
	 * Gets the tablero.
	 *
	 * @return the tablero
	 */
	public Tablero getTablero() {return tablero;}
	
	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron> getPatrones(){return patronesUsados;}
}
	