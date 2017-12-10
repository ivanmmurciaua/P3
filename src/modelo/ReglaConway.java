package modelo;

import modelo.excepciones.*;

//import java.util.ArrayList;

/**
 * The Class ReglaConway.
 * 
 * @author Iván Mañús Murcia 48729799K
 */
public class ReglaConway extends Regla {
	
	/**
	 * Instantiates a new regla conway.
	 */
	public ReglaConway() {}
	
	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tab the tab
	 * @param coor the coor
	 * @return the estado celda
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada coor) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero{
		if(tab==null||coor==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
			int vecvivas=0;
			Coordenada elegida;
			EstadoCelda inicial=tab.getCelda(coor);
			EstadoCelda res=EstadoCelda.MUERTA;
			for(int i=0;i<tab.getPosicionesVecinasCCW(coor).size();i++) {
				elegida=tab.getPosicionesVecinasCCW(coor).get(i);
				if(tab.getCelda(elegida)==EstadoCelda.VIVA) {
					vecvivas++;
				}
			}
			if(inicial==EstadoCelda.VIVA) {
				if(vecvivas==2||vecvivas==3) {
					res=EstadoCelda.VIVA;
				}
				/*else {
					res=EstadoCelda.MUERTA;
				}*/
			}
			else {
				if(vecvivas==3) {
					res=EstadoCelda.VIVA;
				}			
			}
			return res;
	}
}
