package modelo.excepciones;
import modelo.*;

public class ExcepcionPosicionFueraTablero extends Exception {
	
	private Coordenada dimensiones;
	private Coordenada coordenada;
	public ExcepcionPosicionFueraTablero(Coordenada coor, Coordenada dims) {
		this.coordenada=coor;
		this.dimensiones=dims;
	}
	public String getMessage() {
		return "Posicion fuera de tablero";
	}
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	

}
