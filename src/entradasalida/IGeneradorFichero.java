package entradasalida;

import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

public interface IGeneradorFichero {
	public void generaFichero(File f, Juego j, int n) throws ExcepcionGeneracion;
}
