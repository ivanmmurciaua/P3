package modelo;
import modelo.EstadoCelda;
import java.util.*;

/**
 * The Class Tablero.
 *
 * @author Iván Mañús Murcia 48729799K
 */

public class Tablero {
	
	
	/**
	 * Muestra error posicion invalida.
	 *
	 * @param coor the coor
	 */
	private void muestraErrorPosicionInvalida(Coordenada coor){
		System.err.println("Error: La celda ("+coor.getX()+","+coor.getY()+") no existe");
	}
	
	/*public void mostrarHashMap() {
		// Recorremos el hashMap y mostramos por pantalla el par valor y clave
		Iterator it = this.celdas.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    System.out.println(e.getKey() + " " + e.getValue());
		}
	}*/
		
	
    /** The dimensiones. */
	private Coordenada dimensiones;
	
	/** The celdas. */
	private HashMap <Coordenada,EstadoCelda> celdas;
	
	/**
	 * Ini hash map.
	 *
	 * @param fas the fas
	 */
	private void iniHashMap(HashMap <Coordenada,EstadoCelda> fas) {
		for(int i=0;i<this.dimensiones.getX();i++) {
    		for(int j=0;j<this.dimensiones.getY();j++) {
    			fas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
    		}
    	}
	}
	   
	/**
	 * Instantiates a new tablero.
	 *
	 * @param dims the dims
	 */
	public Tablero(Coordenada dims) {
    	this.dimensiones= new Coordenada(dims);
    	this.celdas = new HashMap<Coordenada,EstadoCelda>();
    	iniHashMap(this.celdas);
    	
    }
	
	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {
    	return this.dimensiones;
    }
    
    /**
     * Gets the posiciones.
     *
     * @return the posiciones
     */
    public Collection<Coordenada> getPosiciones(){
    	return this.celdas.keySet();
    }
    
    /**
     * Gets the celda.
     *
     * @param dims the dims
     * @return the celda
     */
    public EstadoCelda getCelda(Coordenada dims) {
    	EstadoCelda state=null;
    	if(this.celdas.containsKey(dims)) {
    		state=this.celdas.get(dims);
    	}
    	else {
    		muestraErrorPosicionInvalida(dims);
    	}
    	return state;
    }
    
    /**
     * Sets the celda.
     *
     * @param dims the dims
     * @param estat the estat
     */
    public void setCelda(Coordenada dims, EstadoCelda estat){
    	if(this.celdas.containsKey(dims)) {
    		this.celdas.put(dims, estat);
    	}
    	else {
    		muestraErrorPosicionInvalida(dims);
    	}
    }
    
    /**
     * Contiene.
     *
     * @param coor the coor
     * @return true, if successful
     */
    public boolean contiene(Coordenada coor) {
    	return this.celdas.containsKey(coor);
    }

    /*private Coordenada transformaCoordenadas(Coordenada coord) {
    	return new Coordenada(coord.getX()-1,coord.getY()-1);
    }*/
    
   /**
     * Carga patron.
     *
     * @param pat the pat
     * @param coordenadaInicial the coordenada inicial
     * @return true, if successful
     */
    public boolean cargaPatron(Patron pat, Coordenada coordenadaInicial) {
	   Coordenada paco;
	   //Coordenada nueva;
	   boolean nocabe=false;
	   HashMap <Coordenada,EstadoCelda> buenas;
	   buenas= new HashMap<Coordenada,EstadoCelda>();
	   iniHashMap(buenas);
	   buenas=this.celdas;
	   
	   //System.out.println(getDimensiones());          //CoordenadasDelNuevoTablero
	   
	   for(Coordenada c : pat.getPosiciones()) {
		   if(!nocabe) {
		   paco=c.suma(coordenadaInicial);
		   //nueva=transformaCoordenadas(paco);
		   //System.out.println(nueva);
		   //System.out.println(c.suma(coordenadaInicial));  //Coordenada final
		   if(paco.getX()>getDimensiones().getX() || paco.getY()>getDimensiones().getY()) {
			   muestraErrorPosicionInvalida(paco);
			   nocabe=true;
		   }
		   else {
			   //System.out.println(nueva);
			   //System.out.println(pat.getCelda(c));
			   buenas.put(paco, pat.getCelda(c));
		   }
		   //System.out.println(pat.getCelda(c));           //Estado de la celda...yanose..vaya lio llevo hermano
		   //System.out.println("\n");
		   }
	   }
	   if(!nocabe) {
		   this.celdas=buenas;
		   return true;
		   }
	   else {
		   return false;
	   }
		   
	   //System.out.println(pat.getCelda());
		   
	   }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String cadena="";
		cadena=cadena+"+";
		for(int i=0;i<dimensiones.getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		for(int j=0;j<dimensiones.getY();j++) {
			cadena=cadena+"|";
			for(int i=0;i<dimensiones.getX();i++) {
			     if(celdas.get(new Coordenada(i,j)).equals(EstadoCelda.MUERTA)) {
			    	 cadena=cadena+" ";
			     }else {
			    	 cadena=cadena+"*";
			     }
			}
			cadena=cadena+"|\n";
		}
		cadena=cadena+"+";
		for(int i=0;i<dimensiones.getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		return cadena;
	}
	
	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param coor the coor
	 * @return the posiciones vecinas CCW
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada coor){
		ArrayList<Coordenada> vecinas=new ArrayList<Coordenada>();
		
		if(this.celdas.containsKey(new Coordenada(coor.getX()-1, coor.getY()-1))){
			vecinas.add(new Coordenada(coor.getX() - 1, coor.getY() - 1));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX()-1, coor.getY()))){
			vecinas.add(new Coordenada(coor.getX()-1, coor.getY()));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX()-1, coor.getY()+1))){
			vecinas.add(new Coordenada(coor.getX()-1, coor.getY()+1));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX(), coor.getY()+1))){
			vecinas.add(new Coordenada(coor.getX(), coor.getY()+1));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX()+1, coor.getY()+1))){
				vecinas.add(new Coordenada(coor.getX()+1, coor.getY()+1));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX()+1, coor.getY()))){
			vecinas.add(new Coordenada(coor.getX()+1, coor.getY()));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX()+1, coor.getY()-1))){
			vecinas.add(new Coordenada(coor.getX()+1, coor.getY()-1));
		}
		if(this.celdas.containsKey(new Coordenada(coor.getX(), coor.getY()-1))){
			vecinas.add(new Coordenada(coor.getX(), coor.getY()-1));
		}
		return vecinas;
	}
		 
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		if (dimensiones == null) {
			if (other.dimensiones != null)
				return false;
		} else if (!dimensiones.equals(other.dimensiones))
			return false;
		return true;
	}
}