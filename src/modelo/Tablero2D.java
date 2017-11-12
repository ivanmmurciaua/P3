package modelo;
import java.util.HashMap;
import modelo.excepciones.*;

/**
 * The Class Tablero2D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public abstract class Tablero2D extends Tablero {
	
	/**
	 * Instantiates a new tablero 2 D.
	 *
	 * @param ancho the ancho
	 * @param alto the alto
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta,ExcepcionEjecucion {
		super(new Coordenada2D(ancho,alto));
		this.celdas = new HashMap<Coordenada,EstadoCelda>();
    	iniHashMap(this.celdas,true);
	}
}
