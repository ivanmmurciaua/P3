package modelo.excepciones;

public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	private int x;
	public ExcepcionCoordenada1DIncorrecta(int x) {}
	public String getMessage() {
		return "ExcepcionCoordenada1D";
	}
	public int getX() {
		return this.x;
	}
}
