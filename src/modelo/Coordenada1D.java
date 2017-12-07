package modelo;
import modelo.excepciones.*;

/**
 * The Class Coordenada1D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */

public class Coordenada1D extends Coordenada {
	
	/** The x. */
	int x;
	
	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @param c the c
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada1D(int c) throws ExcepcionCoordenada1DIncorrecta{
		if(c<0) {
			throw new ExcepcionCoordenada1DIncorrecta(c);
		}
		else {
			this.x=c;
		}
	}
	
	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @param otra the otra
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada1D(Coordenada1D otra) throws ExcepcionArgumentosIncorrectos{
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			this.x=otra.x;
		}
	}
	
	
	/**
	 * Suma
	 *
	 * @param otra the otra
	 * @param coor the coor
	 * @return the Coordenada1D
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada1D suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos{
		if(otra==null) {
				throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			return new Coordenada1D(this.x+((Coordenada1D)otra).x);
		}
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {return this.x;}
	
	/**
	 * toString Coordenada1D
	 *
	 * @return the string
	 */
	public String toString() {
		return "("+x+")";
	}
	
	/**
	 * Get the result.
	 *
	 * @return the result
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}
	
	/**
	 * Check if equals.
	 *
	 * @param obj the obj
	 * @return the boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}
}
