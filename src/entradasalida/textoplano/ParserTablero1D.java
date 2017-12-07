package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class ParserTablero1D implements IParserTablero{
	
	public ParserTablero1D(){}
	
	protected boolean compruebaCadena(String s, boolean eleg) throws ExcepcionLectura, ExcepcionEjecucion,ExcepcionArgumentosIncorrectos {
		boolean ok=false;
		if(s==null) {throw new ExcepcionArgumentosIncorrectos();}
		if(s=="") {throw new ExcepcionLectura("Vacio");};
		
		if(!eleg) {  //Para Tablero1D
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) == '*' || s.charAt(i) == ' ') {
					ok=true;
				}
				else {
					throw new ExcepcionLectura("Char raro");
				}
			}
		}else {  //Para Tablero2D
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) == '*' || s.charAt(i) == ' ' || s.charAt(i) == '\n') {
					ok=true;
				}
				else {
					throw new ExcepcionLectura("Char raro");
				}
			}
		}
		return ok;
		
	}

	@Override
	public Tablero leeTablero(String s) throws ExcepcionLectura, ExcepcionEjecucion,ExcepcionArgumentosIncorrectos{
		
		if(compruebaCadena(s,false)) {
			Tablero1D t1;
			try {
				t1 = new Tablero1D(s.length());
			} catch (ExcepcionCoordenadaIncorrecta e1) {
				throw new ExcepcionEjecucion(e1);
			}
			
			for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*') {
						try {
							t1.setCelda(new Coordenada1D(i),EstadoCelda.VIVA);
						} catch (ExcepcionCoordenada1DIncorrecta | ExcepcionPosicionFueraTablero e) {
							throw new ExcepcionEjecucion(e);
						}
					}	
					else {
						try {
							t1.setCelda(new Coordenada1D(i), EstadoCelda.MUERTA);
						} catch (ExcepcionCoordenada1DIncorrecta | ExcepcionPosicionFueraTablero e) {
							throw new ExcepcionEjecucion(e);
						}
					}
				}
			
			return t1;
		}
		else {return null;}
	}
		

}


