package entradasalida;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.txt.ParserTablero1D;
import entradasalida.txt.ParserTablero2D;

/**
 * The Class ParserTableros.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ParserTableros {
	
	/**
	 * Instantiates a new parser tableros.
	 */
	public ParserTableros() {}
	
	/**
	 * Lee tablero.
	 *
	 * @param s the string
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public static Tablero<?> leeTablero(String s) throws ExcepcionLectura, ExcepcionEjecucion,ExcepcionArgumentosIncorrectos {
		if(s==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(s=="") {
			throw new ExcepcionLectura("Vacio");
		}
		boolean d2=false;
		Tablero<?> t=null;
		IParserTablero ipt;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='\n') {
				d2=true;
			}
		}
		if(d2) {
			ipt= new ParserTablero2D();
			t=ipt.leeTablero(s);
		}
		else {
			ipt= new ParserTablero1D();
			t=ipt.leeTablero(s);
		}
		return t;
	}

}
