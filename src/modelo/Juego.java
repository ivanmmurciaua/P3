package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import modelo.excepciones.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Juego.
 *
 * @author Iván Mañús Murcia 48729799K
 * @param <TipoCoordenada> el tipo generico que extiende a Coordenada
 */
public class Juego<TipoCoordenada extends Coordenada> {
	
	
	/** The regla. */
	private Regla<TipoCoordenada> regla;
	
	
	/** The tablero. */
	private Tablero<TipoCoordenada> tablero; 
	
	
	/** The patrones usados. */
	private ArrayList<Patron<TipoCoordenada>> patronesUsados=new ArrayList<Patron<TipoCoordenada>>();

	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Juego(Tablero<TipoCoordenada> tablero,Regla<TipoCoordenada> regla) throws ExcepcionArgumentosIncorrectos{
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
	public void cargaPatron(Patron<TipoCoordenada> pat, TipoCoordenada coor) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion,ExcepcionPosicionFueraTablero{
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
		Collection<TipoCoordenada> posicionesactuales;
		EstadoCelda nuevo=EstadoCelda.MUERTA;
		HashMap<TipoCoordenada,EstadoCelda> asiresulta = new HashMap<TipoCoordenada,EstadoCelda>();
		posicionesactuales=tablero.getPosiciones();
		
		for(TipoCoordenada c : posicionesactuales) {
			try {
				nuevo=regla.calculaSiguienteEstadoCelda(tablero, c);
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}
			asiresulta.put(c, nuevo);
		}
		
		for(TipoCoordenada c : asiresulta.keySet()) {                //el keySet sirve para iterar por coordenadas
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
	public Tablero<TipoCoordenada> getTablero() {return tablero;}
	
	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron<TipoCoordenada>> getPatrones(){return patronesUsados;}
}
	