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
