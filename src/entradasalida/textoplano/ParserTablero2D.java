package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.*;

/**
 * The Class ParserTablero2D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ParserTablero2D implements IParserTablero{
	
	/**
	 * Instantiates a new parser tablero 2 D.
	 */
	public ParserTablero2D(){}
	
	/**
	 * Longitud distinta.
	 *
	 * @param stringgg the stringgg
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	private void longitudDistinta(String[] stringgg) throws ExcepcionLectura {
		int aux=stringgg[0].length();
		for(int i=0;i<stringgg.length;i++) {
			if(aux!=stringgg[i].length()) {
				throw new ExcepcionLectura("Tamaño distinto");
			}
		}
	}

	/* (non-Javadoc)
	 * @see entradasalida.IParserTablero#leeTablero(java.lang.String)
	 */
	@Override
	public Tablero leeTablero(String s) throws ExcepcionLectura, ExcepcionEjecucion,ExcepcionArgumentosIncorrectos {
		ParserTablero1D pt1=new ParserTablero1D();
		TableroCeldasCuadradas t2;
		if(pt1.compruebaCadena(s, true)) {
			String[] stringgg=s.split("\n");    //Dividimos en arrays de strings
			longitudDistinta(stringgg);
			try {
				t2 = new TableroCeldasCuadradas(stringgg[0].length(),stringgg.length);
			} catch (ExcepcionCoordenadaIncorrecta e1) {
				throw new ExcepcionEjecucion(e1);
			}
			for(int alto=0;alto<stringgg.length;alto++) {
				for(int ancho=0;ancho<stringgg[alto].length();ancho++) {
					if(stringgg[alto].charAt(ancho)=='*') {
						try {
							t2.setCelda(new Coordenada2D(ancho,alto), EstadoCelda.VIVA);
						} catch (ExcepcionCoordenadaIncorrecta | ExcepcionPosicionFueraTablero e) {
							throw new ExcepcionEjecucion(e);
						}
					}
					else {
						try {
							t2.setCelda(new Coordenada2D(ancho,alto), EstadoCelda.MUERTA);
						} catch (ExcepcionCoordenadaIncorrecta | ExcepcionPosicionFueraTablero e) {
							throw new ExcepcionEjecucion(e);
						}
					}
				}
			}
			return t2;
		}else {return null;}
	}

}
