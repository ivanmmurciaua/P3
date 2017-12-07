package modelo;
import modelo.excepciones.*;
import java.util.ArrayList;


/**
 * The Class TableroCeldasCuadradas.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class TableroCeldasCuadradas extends Tablero2D implements Imprimible {
	
	/**
	 * Instantiates a new tablero celdas cuadradas.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public TableroCeldasCuadradas(int x, int y) throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {super(x,y);}
	
	/**
	 * toString TabCeldasCuadradas
	 *
	 * @return the string
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	@Override
	public String toString() throws ExcepcionEjecucion {
		String cadena="";
		cadena=cadena+"+";
		for(int i=0;i<((Coordenada2D) dimensiones).getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		for(int j=0;j<((Coordenada2D) dimensiones).getY();j++) {
			cadena=cadena+"|";
			for(int i=0;i<((Coordenada2D) dimensiones).getX();i++) {
			     try {
					if(celdas.get(new Coordenada2D(i,j)).equals(EstadoCelda.MUERTA)) {
						 cadena=cadena+" ";
					 }else {
						 cadena=cadena+"*";
					 }
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			cadena=cadena+"|\n";
		}
		cadena=cadena+"+";
		for(int i=0;i<((Coordenada2D) dimensiones).getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		return cadena;
	}
	
	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param coor the coor
	 * @return the posiciones vecinas CCW
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada coor) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion, ExcepcionPosicionFueraTablero{
		ArrayList<Coordenada> vecinas=new ArrayList<Coordenada>();
		if(coor==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX()-1, ((Coordenada2D) coor).getY()-1))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX() - 1, ((Coordenada2D) coor).getY() - 1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX()-1, ((Coordenada2D) coor).getY()))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX()-1, ((Coordenada2D) coor).getY()));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX()-1, ((Coordenada2D) coor).getY()+1))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX()-1, ((Coordenada2D) coor).getY()+1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX(), ((Coordenada2D) coor).getY()+1))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX(), ((Coordenada2D) coor).getY()+1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX()+1, ((Coordenada2D) coor).getY()+1))){
						vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX()+1, ((Coordenada2D) coor).getY()+1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX()+1, ((Coordenada2D) coor).getY()))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX()+1, ((Coordenada2D) coor).getY()));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX()+1, ((Coordenada2D) coor).getY()-1))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX()+1, ((Coordenada2D) coor).getY()-1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(((Coordenada2D) coor).getX(), ((Coordenada2D) coor).getY()-1))){
					vecinas.add(new Coordenada2D(((Coordenada2D) coor).getX(), ((Coordenada2D) coor).getY()-1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}	
		}
		return vecinas;
	}

	@Override
	public String generaCadena() {
		String cadena="";
		cadena=cadena+"+";
		for(int i=0;i<((Coordenada2D) dimensiones).getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		for(int j=0;j<((Coordenada2D) dimensiones).getY();j++) {
			cadena=cadena+"|";
			for(int i=0;i<((Coordenada2D) dimensiones).getX();i++) {
			     try {
					if(celdas.get(new Coordenada2D(i,j)).equals(EstadoCelda.MUERTA)) {
						 cadena=cadena+" ";
					 }else {
						 cadena=cadena+"*";
					 }
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			cadena=cadena+"|\n";
		}
		cadena=cadena+"+";
		for(int i=0;i<((Coordenada2D) dimensiones).getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		return cadena;
	}
	
	
	
	
	
}

	


