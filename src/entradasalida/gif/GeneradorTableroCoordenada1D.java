package entradasalida.gif;

import java.io.File;
import gifs.*;
import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.*;
import modelo.d1.Coordenada1D;
import modelo.d1.ExcepcionCoordenada1DIncorrecta;
import modelo.d1.Tablero1D;
import modelo.excepciones.*;

/**
 * The Class GeneradorGIFTablero1D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class GeneradorTableroCoordenada1D implements IGeneradorFichero {
	
	/**
	 * Instantiates a new generador GIF tablero 1 D.
	 */
	public GeneradorTableroCoordenada1D() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void generaFichero(File file, Juego<?> juego, int iteraciones) throws ExcepcionGeneracion {
		if(file==null||juego==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(iteraciones<=0) {throw new ExcepcionGeneracion("Iteraciones menores a 0");}
		Tablero1D tablero=(Tablero1D)juego.getTablero();
		Coordenada1D anchura=(Coordenada1D)tablero.getDimensiones();
		ImagenGIF gif=new ImagenGIF(anchura.getX(),iteraciones);
		for(int y=0;y<iteraciones;y++) {
			try {
				for(int x=0;x<anchura.getX();x++) {
					if(tablero.getCelda(new Coordenada1D(x))==EstadoCelda.VIVA) {
							gif.pintaCuadrado(x, y);
					}
				}
				}catch (ExcepcionArgumentosIncorrectos | ExcepcionCoordenada1DIncorrecta | ExcepcionPosicionFueraTablero e) {
						throw new ExcepcionEjecucion(e);
				}
			juego.actualiza();
		}
		gif.guardaFichero(file);
	}
				
}
