package entradasalida;

import modelo.Coordenada;
import modelo.Regla;
import modelo.Tablero;

public class Factory {
	public Factory() {}
	public static IGeneradorFichero creaGeneradorFichero(Tablero t, String s) {
		return null;}
	public static Regla creaRegla(Tablero t) {
		return null;}
	public static Tablero creaTablero(Coordenada c) {
		return null;}
}
