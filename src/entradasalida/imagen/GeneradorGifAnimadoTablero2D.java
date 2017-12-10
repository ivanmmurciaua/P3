package entradasalida.imagen;

import java.io.File;
import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.*;
import modelo.excepciones.*;

/**
 * The Class GeneradorGifAnimadoTablero2D.
 * 
 *  @author Iván Mañús Murcia 48729799K
 */
public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero{
	
	/**
	 * Instantiates a new generador gif animado tablero 2 D.
	 */
	public GeneradorGifAnimadoTablero2D() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(file==null||juego==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(iteraciones<=0) {throw new ExcepcionGeneracion("Iteraciones menores a 0");}
		TableroCeldasCuadradas t= (TableroCeldasCuadradas)juego.getTablero();
		Coordenada2D coor=(Coordenada2D)t.getDimensiones();
		int anchura=coor.getX();
		int alto=coor.getY();
		ImagenGIFAnimado gifa=new ImagenGIFAnimado(100);
		for(int i=0;i<iteraciones;i++) {
			ImagenGIF fotograma= new ImagenGIF(anchura,alto);
			for(int x=0;x<anchura;x++) {
				for(int y=0;y<alto;y++) {
					try {
						if(t.getCelda(new Coordenada2D(x,y))==EstadoCelda.VIVA) {
							fotograma.pintaCuadrado(x, y);
						}
					} catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
					}
				}
			}
			gifa.addFotograma(fotograma);
			juego.actualiza();
		}
		gifa.guardaFichero(file);
	}

}
