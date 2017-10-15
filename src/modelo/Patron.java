package modelo;

import java.util.Collection;

/**
 * The Class Patron.
 */
public class Patron {
	
	/** The nombre. */
	private String nombre;
	
	/** The tablero. */
	Tablero tablero;
	
	/**
	 * Instantiates a new patron.
	 *
	 * @param nombre the nombre
	 * @param tablero the tablero
	 */
	public Patron(String nombre,Tablero tablero) {
		this.nombre=nombre;
		this.tablero=tablero;		
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
	 */
	public EstadoCelda getCelda(Coordenada coor) {
		return tablero.getCelda(coor);
	}
	
	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection<Coordenada> getPosiciones(){
		return tablero.getPosiciones();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String cadena="";
		cadena=cadena+this.nombre+"\n";
		cadena=cadena+tablero.toString();
		return cadena;
	}

}