package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.*;
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
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		if(tablero==null||extension==null) {throw new ExcepcionArgumentosIncorrectos();}
		IGeneradorFichero fin;
		if(extension.equals("txt")) {
			fin= new GeneradorFicheroPlano();		
		}
		else if(extension.equals("gif")) {
			try {
				if(tablero.getDimensiones().getClass().getName()=="modelo.Coordenada1D") {
					fin= new GeneradorGIFTablero1D();
				}
				else{
					fin= new GeneradorGifAnimadoTablero2D();
				}	
			}catch(Exception e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else {
			throw new ExcepcionGeneracion("No es ni txt ni gif");
		}
		return fin;
	}
	
	/**
	 * Crea regla.
	 *
	 * @param tablero the tablero
	 * @return the regla
	 */
	public static Regla creaRegla(Tablero tablero) {
		if(tablero==null) {throw new ExcepcionArgumentosIncorrectos();}
		Regla r=null;
		try {
			if(tablero.getDimensiones().getClass().getName()=="modelo.Coordenada1D") {
				r= new Regla30();
			}
			else {
				r=new ReglaConway();
			}
			
		} catch (Exception e) {
			throw new ExcepcionEjecucion(e);
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
		Tablero t=null;
		if(dimensiones==null) {throw new ExcepcionArgumentosIncorrectos();}
		
		try {
			if(dimensiones.getClass().getName()=="modelo.Coordenada1D") {
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
