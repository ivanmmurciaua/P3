package entradasalida.imagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import gifs.*;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class GeneradorGIFTablero1D implements IGeneradorFichero {
	
	public GeneradorGIFTablero1D() {}

	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(file==null||juego==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(iteraciones<0) {throw new ExcepcionGeneracion("Iteraciones menores a 0");}
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e1) {
			throw new ExcepcionGeneracion(e1);
		}
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
		writer.print(gif);
		writer.close();
	}
				
}
