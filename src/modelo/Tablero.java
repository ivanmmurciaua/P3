package modelo;
import modelo.EstadoCelda;
import modelo.d1.Coordenada1D;
import modelo.d2.Coordenada2D;
import modelo.excepciones.*;

import java.util.*;

/**
 * The Class Tablero.
 *
 * @author Iván Mañús Murcia 48729799K
 * @param <TipoCoordenada> el tipo generico que extiende a Coordenada
 */

public abstract class Tablero<TipoCoordenada extends Coordenada> {
	
	
	/*public void mostrarHashMap() {
		// Recorremos el hashMap y mostramos por pantalla el par valor y clave
		Iterator it = this.celdas.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    System.out.println(e.getKey() + " " + e.getValue());
		}
	}*/
	
	/**
	 * Ini hash map.
	 *
	 * @param celdas2 the Hashmap
	 * @param interruptor the interruptor
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	protected void iniHashMap(HashMap<TipoCoordenada, EstadoCelda> celdas2, boolean interruptor) throws ExcepcionEjecucion {
		if(interruptor) {
			for(int i=0;i<((Coordenada2D) this.dimensiones).getX();i++) {
	    		for(int j=0;j<((Coordenada2D) this.dimensiones).getY();j++) {
	    			try {
	    				celdas2.put((TipoCoordenada) new Coordenada2D(i,j), EstadoCelda.MUERTA);
	    			}
	    			catch(ExcepcionCoordenadaIncorrecta e) {
	    				throw new ExcepcionEjecucion(e);
	    			}
	    			
	    		}
	    	}	
		}
		else {
			for(int i=0;i<((Coordenada1D) this.dimensiones).getX();i++) {
				try {
					celdas2.put((TipoCoordenada) new Coordenada1D(i), EstadoCelda.MUERTA);
				}catch(ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
		
	}
		
	/** The dimensiones. */
	protected TipoCoordenada dimensiones;

	/** The celdas. */
	protected HashMap <TipoCoordenada,EstadoCelda> celdas;
	
	/**
	 * Instantiates a new tablero.
	 *
	 * @param dims the dims
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Tablero(TipoCoordenada dims) throws ExcepcionArgumentosIncorrectos{
    	if(dims==null) {
    		throw new ExcepcionArgumentosIncorrectos();
    	}else {
    		this.dimensiones= dims;
    	}    	
    }

	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public TipoCoordenada getDimensiones() {
    	return this.dimensiones;
    }

    /**
     * Gets the posiciones.
     *
     * @return the posiciones
     */
    public Collection<TipoCoordenada> getPosiciones(){
    	return this.celdas.keySet();
    }

    /**
     * Gets the celda.
     *
     * @param dims the dims
     * @return the celda
     * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
     * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
     */
    public EstadoCelda getCelda(TipoCoordenada dims) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero {
    	EstadoCelda state=null;
    	if(dims==null) {
    		throw new ExcepcionArgumentosIncorrectos();
    	}
    	else {
    		if(this.celdas.containsKey(dims)) {
        		state=this.celdas.get(dims);
        	}
        	else {
        		throw new ExcepcionPosicionFueraTablero(dims,dimensiones);
        	}	
    	}
    	return state;
    }
    
    /**
     * Sets the celda.
     *
     * @param dims the dims
     * @param estat the estat
     * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
     * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
     */
    public void setCelda(TipoCoordenada dims, EstadoCelda estat) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero{
    	if(dims==null||estat==null) {
    		throw new ExcepcionArgumentosIncorrectos();
    	}
    	else {
    		if(this.celdas.containsKey(dims)) {
        		this.celdas.put(dims, estat);
        	}
        	else {
        		throw new ExcepcionPosicionFueraTablero(dims,dimensiones);
        	}	
    	}
    }
    
    /**
     * Contiene.
     *
     * @param coor the coor
     * @return true, if successful
     * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
     */
    public boolean contiene(TipoCoordenada coor) throws ExcepcionArgumentosIncorrectos{
    	if(coor==null) {
    		throw new ExcepcionArgumentosIncorrectos();
    	}
    	return this.celdas.containsKey(coor);
    }
    
    /**
     * Check if is inside
     *
     * @param cp the cp
     * @param c the c
     * @param ci the ci
     * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
     */
    private void uyEstaDentro(Collection<TipoCoordenada> cp, TipoCoordenada c, TipoCoordenada ci) throws ExcepcionPosicionFueraTablero{
    	for(TipoCoordenada actual : cp){
			try {
				c = (TipoCoordenada) actual.suma(ci);
			}
			catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
			if(!celdas.containsKey(c)){
				throw new ExcepcionPosicionFueraTablero(c,dimensiones);
			}
		}
    }
    
    /**
     * Carga patron.
     *
     * @param patron the patron
     * @param coordenadaInicial the TipoCoordenada inicial
     * @throws ExcepcionEjecucion the excepcion ejecucion
     * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
     * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
     */
    public void cargaPatron(Patron<TipoCoordenada> patron, TipoCoordenada coordenadaInicial) throws ExcepcionEjecucion, ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos{
		Collection<TipoCoordenada> cp;
		TipoCoordenada fin = null;
		EstadoCelda valor;
		
		if(patron == null || coordenadaInicial == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(!celdas.containsKey(coordenadaInicial)) {
			throw new ExcepcionPosicionFueraTablero(coordenadaInicial,dimensiones);
		}
		
		cp = patron.getPosiciones();
		
		if(cp != null) {	
			
			uyEstaDentro(cp,fin,coordenadaInicial);
			

			for(TipoCoordenada pos : cp){
				try {
					fin = (TipoCoordenada) pos.suma(coordenadaInicial);
				}
				catch(ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
				try {
					valor = patron.getCelda(pos);
					celdas.put(fin, valor);
				}
				catch(ExcepcionPosicionFueraTablero e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			
		}
	
	}

    
	
	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param posicion the posicion
	 * @return the posiciones vecinas CCW
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public abstract ArrayList<TipoCoordenada> getPosicionesVecinasCCW(TipoCoordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero,ExcepcionEjecucion;
		 
}