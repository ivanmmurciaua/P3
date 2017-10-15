package modelo;

/**
 * The Class Coordenada.
 */
public class Coordenada {
	
	/** The y. */
	private int x,y;
	
	/** The numero coordenadas. */
	private static int NUMERO_COORDENADAS=0;
	
	/**
	 * Instantiates a new coordenada.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Coordenada(int x,int y) {
		this.x=x;
		this.y=y;
		NUMERO_COORDENADAS++;
	}
	

	/**
	 * Instantiates a new coordenada.
	 *
	 * @param otra the otra
	 */
	public Coordenada(Coordenada otra) {
		this.x=otra.x;
		this.y=otra.y;
		NUMERO_COORDENADAS++;
	}
	
	/**
	 * Gets the numero coordenadas.
	 *
	 * @return the numero coordenadas
	 */
	public static int getNumeroCoordenadas() {return NUMERO_COORDENADAS;}
	
	/**
	 * Suma.
	 *
	 * @param otra the otra
	 * @return the coordenada
	 */
	public Coordenada suma(Coordenada otra) {
		return new Coordenada(this.x+otra.x,this.y+otra.y);
	};
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
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

