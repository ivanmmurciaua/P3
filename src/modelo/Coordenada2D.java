package modelo;
import modelo.excepciones.*;

/**
 * The Class Coordenada2D.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class Coordenada2D extends Coordenada{
	
	/** The x. */
	private int x;
	

	/** The y. */
	private int y;
	

	/**
	 * Instantiates a new coordenada 2 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta {
		if(x<0 || y<0) {
			throw new ExcepcionCoordenada2DIncorrecta(x,y);
		}
		else {
			this.x=x;
			this.y=y;	
		}
	}
	

	/**
	 * Instantiates a new coordenada 2 D.
	 *
	 * @param otra the otra
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada2D(Coordenada2D otra) throws ExcepcionArgumentosIncorrectos{
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			this.x=otra.x;
			this.y=otra.y;
				
		}
	}
	

	/**
	 * Suma
	 *
	 * @param otra the otra
	 * @return the Coordenada1D
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada2D suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos{
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			
			return new Coordenada2D(this.x+((Coordenada2D)otra).x,this.y+((Coordenada2D)otra).y);
		}
	}
	

	/**
	 * toString Coordenada2D
	 *
	 * @return the string
	 */
	public String toString() {
		return "("+x+","+y+")";
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Get the result.
	 *
	 * @return the result
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	/**
	 * Check if equals.
	 *
	 * @param obj the obj
	 * @return the boolean
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada2D other = (Coordenada2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}


