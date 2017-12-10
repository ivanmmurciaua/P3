package modelo;
import java.util.HashMap;
import modelo.excepciones.*;
import java.util.ArrayList;

/**
 * The Class Tablero1D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class Tablero1D extends Tablero implements Imprimible {
	
	/**
	 * Instantiates a new tablero 1 D.
	 *
	 * @param ancho the ancho
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public Tablero1D(int ancho) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion{
		super(new Coordenada1D(ancho));
		this.celdas = new HashMap<Coordenada,EstadoCelda>();
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
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		if(posicion==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(!celdas.containsKey(posicion)){
			throw new ExcepcionPosicionFueraTablero(dimensiones,posicion);
		}
		else {
			if(((Coordenada1D) posicion).getX()-1 >=0) {
				try {
					vecinas.add(new Coordenada1D(((Coordenada1D) posicion).getX()-1));
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			if(((Coordenada1D) posicion).getX()+1 <((Coordenada1D)dimensiones).getX()) {
				try {
					vecinas.add(new Coordenada1D(((Coordenada1D) posicion).getX()+1));
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
	
	

}
