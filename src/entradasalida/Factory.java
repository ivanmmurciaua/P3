package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.gif.GeneradorTableroCoordenada1D;
import entradasalida.gif.GeneradorTableroCoordenada2D;
import entradasalida.txt.GeneradorFicheroPlano;
import modelo.*;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.Tablero2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;;

/**
 * The Class Factory.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class Factory {
	
	/**
	 * Instantiates a new factory.
	 */
	public Factory() {}
	
	/**
	 * Crea generador fichero.
	 *
	 * @param tablero the tablero
	 * @param extension the extension
	 * @return the i generador fichero
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public static IGeneradorFichero creaGeneradorFichero(Tablero<?> tablero, String extension) throws ExcepcionGeneracion {
		if(tablero==null||extension==null) {throw new ExcepcionArgumentosIncorrectos();}
		IGeneradorFichero fin=null;
		String clase="entradasalida."+ extension + ".GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName();
		try {
			fin=(IGeneradorFichero)Class.forName(clase).newInstance();
		}
		catch(ClassNotFoundException e) {throw new ExcepcionGeneracion(clase);}
		catch(InstantiationException | IllegalAccessException e) {throw new ExcepcionGeneracion(e);}
		return fin;
	}
	
	/**
	 * Crea regla.
	 *
	 * @param tablero the tablero
	 * @return the regla
	 */
	public static Regla creaRegla(Tablero<?> tablero) {
		if(tablero==null) {throw new ExcepcionArgumentosIncorrectos();}
		Regla<?> r=null;
			if(tablero instanceof Tablero1D) {
				r= new Regla30();
			}
			else if(tablero instanceof Tablero2D){
				r=new ReglaConway();
			}
			else {
				throw new ExcepcionEjecucion("No");
			}
			
		
		return r;
		
	}
	
	/**
	 * Crea tablero.
	 *
	 * @param dimensiones the dimensiones
	 * @return the tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public static Tablero creaTablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta{
		Tablero<?> t=null;
		if(dimensiones==null) {throw new ExcepcionArgumentosIncorrectos();}
		
		try {
			if(dimensiones instanceof Coordenada1D) {
				t= new Tablero1D(((Coordenada1D)dimensiones).getX());
			}
			else {
				t= new TableroCeldasCuadradas(((Coordenada2D)dimensiones).getX(),((Coordenada2D)dimensiones).getY());
			}
		} catch (Exception e) {
			throw new ExcepcionEjecucion(e);
		}
		return t;
	}
}
