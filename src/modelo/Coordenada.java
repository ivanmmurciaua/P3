package modelo;

/**
 * 
 * @author Iván Mañús Murcia 48729799K
 *
 */

public class Coordenada {
	/**
	 * inicializamos x e y
	 */
	private int x,y;
	/**
	 * NUMERO_COORDENADAS
	 */
	private static int NUMERO_COORDENADAS=0;
	/**
	 * Constructor Coordenada
	 * @param x
	 * @param y
	 */
	public Coordenada(int x,int y) {
		this.x=x;
		this.y=y;
		NUMERO_COORDENADAS++;
	}
	/**
	 * Crea otra coordenada
	 * @param otra
	 */
	public Coordenada(Coordenada otra) {
		this.x=otra.x;
		this.y=otra.y;
		NUMERO_COORDENADAS++;
	}
	/**
	 * 
	 * @return NUMERO_COORDENADAS
	 */
	public static int getNumeroCoordenadas() {return NUMERO_COORDENADAS;}
	/**
	 * No se
	 * @param otra
	 * @return
	 */
	public Coordenada suma(Coordenada otra) {
		return new Coordenada(this.x+otra.x,this.y+otra.y);
	};
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	/**
	 * @return the x devuelve x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y devuelve y
	 */
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

