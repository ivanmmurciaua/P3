package entradasalida.imagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero{
	
	public GeneradorGifAnimadoTablero2D() {}

	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(file==null||juego==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(iteraciones<0) {throw new ExcepcionGeneracion("Iteraciones menores a 0");}
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
				gifa.addFotograma(fotograma);
				juego.actualiza();
			}
		}
		gifa.guardaFichero(file);
	}

}
