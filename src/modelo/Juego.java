package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * The Class Juego.
 */
public class Juego {
	
	/** The regla. */
	private ReglaConway regla;
	
	/** The tablero. */
	private Tablero tablero; 
	
	/** The patrones usados. */
	private ArrayList<Patron> patronesUsados=new ArrayList<Patron>();
	
	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 */
	public Juego(Tablero tablero,ReglaConway regla) {
		this.tablero=tablero;
		this.regla=regla;
	}
	
	/**
	 * Carga patron.
	 *
	 * @param pat the pat
	 * @param coor the coor
	 */
	public void cargaPatron(Patron pat, Coordenada coor) {
		new ArrayList<Patron>();
		if(tablero.cargaPatron(pat, coor)) {
			patronesUsados.add(pat);
		}
		else {
			System.err.println("Error cargando plantilla "+pat.getNombre()+" en ("+coor.getX()+","+coor.getY()+")");
		}
	}
	
	/**
	 * Actualiza.
	 */
	public void actualiza(){
		Collection<Coordenada> posicionesactuales;
		EstadoCelda nuevo=EstadoCelda.MUERTA;
		HashMap<Coordenada,EstadoCelda> asiresulta = new HashMap<Coordenada,EstadoCelda>();
		posicionesactuales=tablero.getPosiciones();
		
		for(Coordenada c : posicionesactuales) {
			nuevo=regla.calculaSiguienteEstadoCelda(tablero, c);
			asiresulta.put(c, nuevo);
		}
		
		for(Coordenada c : asiresulta.keySet()) {                //el keySet sirve para iterar por coordenadas
			tablero.setCelda(c, asiresulta.get(c));
		}
	}
	
	/**
	 * Gets the tablero.
	 *
	 * @return the tablero
	 */
	public Tablero getTablero() {return this.tablero;}
	
	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron> getPatrones(){return this.patronesUsados;}
}
	