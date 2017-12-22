package modelo.d1;
import java.util.HashMap;
import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.Tablero;
import modelo.excepciones.*;
import java.util.ArrayList;

/**
 * The Class Tablero1D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class Tablero1D extends Tablero<Coordenada1D> implements Imprimible {
	
	/**
	 * Instantiates a new tablero 1 D.
	 *
	 * @param ancho the ancho
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public Tablero1D(int ancho) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion{
		super(new Coordenada1D(ancho));
		this.celdas = new HashMap<Coordenada1D,EstadoCelda>();
		iniHashMap(celdas,false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() throws ExcepcionEjecucion {
		String cadena="";
		cadena=cadena+"|";
		for(int i=0;i<((Coordenada1D) dimensiones).getX();i++)
			     try {
					if(celdas.get(new Coordenada1D(i))==EstadoCelda.MUERTA) {
						 cadena=cadena+" ";
					 }else {
						 cadena=cadena+"*";
					 }
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			cadena=cadena+"|\n";
			return cadena;
		}
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Coordenada1D> getPosicionesVecinasCCW(Coordenada1D posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada1D> vecinas = new ArrayList<Coordenada1D>();
		if(posicion==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(!celdas.containsKey(posicion)){
			throw new ExcepcionPosicionFueraTablero(dimensiones,posicion);
		}
		else {
			if(posicion.getX()-1 >=0) {
				try {
					vecinas.add(new Coordenada1D(posicion.getX()-1));
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			if(posicion.getX()+1 <dimensiones.getX()) {
				try {
					vecinas.add(new Coordenada1D(posicion.getX()+1));
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			return vecinas;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generaCadena() {
		String cadena="";
		cadena=cadena+"|";
		for(int i=0;i<dimensiones.getX();i++)
			     try {
					if(celdas.get(new Coordenada1D(i))==EstadoCelda.MUERTA) {
						 cadena=cadena+" ";
					 }else {
						 cadena=cadena+"*";
					 }
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			cadena=cadena+"|\n";
			return cadena;
	}
	
	

}
