package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class GeneradorFicheroPlano implements IGeneradorFichero {
	
	public GeneradorFicheroPlano() {}

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
		for (int i = 0; i < iteraciones; i++) {
			juego.actualiza();
			if(juego.getTablero() instanceof Imprimible) {
				writer.print(((Imprimible) juego.getTablero()).generaCadena());
			}else {
				throw new ExcepcionGeneracion("No es instanceof Imprimible");
			}
			
		}
		writer.close();
		
	}

}
