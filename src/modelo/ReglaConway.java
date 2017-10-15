package modelo;

//import java.util.ArrayList;

/**
 * The Class ReglaConway.
 */
public class ReglaConway {
	
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
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada coor){
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