package entradasalida;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import entradasalida.excepciones.ExcepcionLectura;

public class ParserTableros {
	public ParserTableros() {}
	
	public static Tablero leeTablero(String s) throws ExcepcionLectura, ExcepcionEjecucion,ExcepcionArgumentosIncorrectos {
		if(s==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(s=="") {
			throw new ExcepcionLectura("Vacio");
		}
		boolean d2=false;
		Tablero t=null;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='n') {
				d2=true;
			}
		}
		if(d2) {
			ParserTablero2D t1= new ParserTablero2D();
			t=t1.leeTablero(s);
		}
		else {
			ParserTablero1D t1= new ParserTablero1D();
			t=t1.leeTablero(s);
		}
		return t;
	}

}
