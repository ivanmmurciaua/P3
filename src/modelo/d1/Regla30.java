package modelo.d1;

import java.util.ArrayList;
import modelo.EstadoCelda;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Regla30.
 * @author Iván Mañús Murcia 48729799K
 */
public class Regla30 extends Regla<Coordenada1D> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero<Coordenada1D> tab, Coordenada1D coor) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
		
		EstadoCelda resultado = null;
		
		if(tab == null || coor == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(!(((Tablero1D)tab).contiene(coor))) {
			throw new ExcepcionPosicionFueraTablero(tab.getDimensiones(), coor);
		}
		ArrayList<Coordenada1D> vecinas = tab.getPosicionesVecinasCCW(coor);
		 if(vecinas.size() == 1) {
			 resultado = EstadoCelda.MUERTA;
		 }
		 else {

			 EstadoCelda I = ((Tablero1D)tab).getCelda(vecinas.get(0));
			 EstadoCelda C = ((Tablero1D)tab).getCelda(coor); 
			 EstadoCelda D = ((Tablero1D)tab).getCelda(vecinas.get(1));
			 
			 
			 if(I == EstadoCelda.VIVA && C == EstadoCelda.VIVA  && D == EstadoCelda.VIVA ) {
				 resultado = EstadoCelda.MUERTA;
			 }
			 else {
				 if(I == EstadoCelda.VIVA && C == EstadoCelda.VIVA  && D == EstadoCelda.MUERTA ) {
					 resultado = EstadoCelda.MUERTA;
				 }
				 else {
					 if(I == EstadoCelda.VIVA && C == EstadoCelda.MUERTA && D == EstadoCelda.VIVA ) {
						 resultado = EstadoCelda.MUERTA;
					 }
					 else {
						 if(I == EstadoCelda.MUERTA && C == EstadoCelda.MUERTA  && D == EstadoCelda.MUERTA ) {
							 resultado = EstadoCelda.MUERTA;
						 }
						 else {
							 resultado = EstadoCelda.VIVA;
						 }
					 }
				 }
					
			 }
		 }
		return resultado;
	}

}
