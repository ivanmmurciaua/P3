package modelo.d2;
import modelo.EstadoCelda;
import modelo.Imprimible;
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
	 * {@inheritDoc}
	 */
	@Override
	public String toString() throws ExcepcionEjecucion {
		String cadena="";
		cadena=cadena+"+";
		for(int i=0;i<dimensiones.getX();i++)
			cadena=cadena+"-";
		cadena=cadena+"+\n";
		for(int j=0;j<dimensiones.getY();j++) {
			cadena=cadena+"|";
			for(int i=0;i<dimensiones.getX();i++) {
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
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Coordenada2D> getPosicionesVecinasCCW(Coordenada2D coor) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion, ExcepcionPosicionFueraTablero{
		ArrayList<Coordenada2D> vecinas=new ArrayList<Coordenada2D>();
		if(coor==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX()-1, coor.getY()-1))){
					vecinas.add(new Coordenada2D(coor.getX() - 1, coor.getY() - 1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX()-1, coor.getY()))){
					vecinas.add(new Coordenada2D(coor.getX()-1, coor.getY()));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX()-1, coor.getY()+1))){
					vecinas.add(new Coordenada2D(coor.getX()-1, coor.getY()+1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX(), coor.getY()+1))){
					vecinas.add(new Coordenada2D(coor.getX(), coor.getY()+1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX()+1, coor.getY()+1))){
						vecinas.add(new Coordenada2D(coor.getX()+1, coor.getY()+1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX()+1, coor.getY()))){
					vecinas.add(new Coordenada2D(coor.getX()+1, coor.getY()));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX()+1, coor.getY()-1))){
					vecinas.add(new Coordenada2D(coor.getX()+1, coor.getY()-1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(this.celdas.containsKey(new Coordenada2D(coor.getX(), coor.getY()-1))){
					vecinas.add(new Coordenada2D(coor.getX(), coor.getY()-1));
				}
			} catch (ExcepcionCoordenadaIncorrecta e) {
				// TODO Auto-generated catch block
				
			}	
		}
		return vecinas;
	}
	
	/**
	 * {@inheritDoc}
	 */
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

	


