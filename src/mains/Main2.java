/*package mains;

import java.util.ArrayList;
import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Patron;
import modelo.Juego;
import modelo.ReglaConway;

/*
 * 
 * 
 * for(Coordenada c : celdas.KeySet())
 *				tablero.get(c);
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
package mains;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Patron;
import modelo.ReglaConway;
import modelo.Tablero;

/**
@author drizo
 **/
public class Main2 {

	public static void main(String[] args) {
		// creamos un patrÃ³n
		Tablero tableroPatron = new Tablero(new Coordenada(3,3));
		tableroPatron.setCelda(new Coordenada(0,0), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(2,0), EstadoCelda.MUERTA);

		tableroPatron.setCelda(new Coordenada(0,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(1,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(2,1), EstadoCelda.VIVA);

		tableroPatron.setCelda(new Coordenada(0,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(1,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(2,2), EstadoCelda.VIVA);
		Patron patron = new Patron("Glider", tableroPatron);	

		// creamos otro patrÃ³n
		Tablero tableroPatron2 = new Tablero(new Coordenada(2,2));
		tableroPatron2.setCelda(new Coordenada(0,0), EstadoCelda.VIVA);
		tableroPatron2.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);

		tableroPatron2.setCelda(new Coordenada(0,1), EstadoCelda.VIVA);
		tableroPatron2.setCelda(new Coordenada(1,1), EstadoCelda.VIVA);

		Patron patron2 = new Patron("Bloque", tableroPatron2);		
		
		// otro mÃ¡s
		Tablero tableroPatron3 = new Tablero(new Coordenada(3,1));
		tableroPatron3.setCelda(new Coordenada(0,0), EstadoCelda.VIVA);
		tableroPatron3.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);
		tableroPatron3.setCelda(new Coordenada(2,0), EstadoCelda.VIVA);

		Patron patron3 = new Patron("Parpadeador", tableroPatron3);	
		
		
		// lo cargamos en un tablero y jugamos
		Tablero t = new Tablero(new Coordenada(10,5));
		ReglaConway r = new ReglaConway();
		Juego juego = new Juego(t, r);
		juego.cargaPatron(patron, new Coordenada(0,0));
		juego.cargaPatron(patron2, new Coordenada(10,5)); // aquÃ­ no se deberÃ­a cargar
		juego.cargaPatron(patron2, new Coordenada(8,3)); // aquÃ­ sÃ­
		juego.cargaPatron(patron3, new Coordenada(7,0));

		System.out.println("Patrones usados:");
		ArrayList<Patron> patrones = juego.getPatrones();
		for (Patron p: patrones) {
			System.out.println(p.toString());
		}
		System.out.println("Juego:");
		for (int i=0; i<5; i++) {
			System.out.println(juego.getTablero().toString());
			juego.actualiza();
		}
		System.out.println(juego.getTablero().toString());
		
		
	}


	/*public static void main(String[] args) {
		//creamos un patron
		Tablero tableroPatron = new Tablero(new Coordenada(3,3));
		tableroPatron.setCelda(new Coordenada(0,0), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(2,0), EstadoCelda.MUERTA);

		tableroPatron.setCelda(new Coordenada(0,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(1,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(2,1), EstadoCelda.VIVA);

		tableroPatron.setCelda(new Coordenada(0,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(1,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(2,2), EstadoCelda.VIVA);
		//tableroPatron.mostrarHashMap();
		//System.out.println(tableroPatron.toString());
		Patron patron = new Patron("Glider", tableroPatron);
		System.out.println(patron.toString());
		//System.out.println(patron.getPosiciones());
		Tablero tableroprueba= new Tablero(new Coordenada(10,5));
		System.out.println(tableroprueba.toString());
		tableroprueba.CargaPatron(patron,new Coordenada(3,1));
		System.out.println(tableroprueba.toString());
		System.out.println(tableroprueba.getPosicionesVecinasCCW(new Coordenada(0,1)));
		
		
		System.out.println(tableroprueba.toString());

		// creamos otro patrón
		Tablero tableroPatron2 = new Tablero(new Coordenada(2,2));
		tableroPatron2.setCelda(new Coordenada(0,0), EstadoCelda.VIVA);
		tableroPatron2.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);

		tableroPatron2.setCelda(new Coordenada(0,1), EstadoCelda.VIVA);
		tableroPatron2.setCelda(new Coordenada(1,1), EstadoCelda.VIVA);
		
		//System.out.println(tableroPatron2.toString());

		Patron patron2 = new Patron("Bloque", tableroPatron2);		
		System.out.println(patron2.toString());
		tableroprueba.CargaPatron(patron2, new Coordenada(7,4));
		System.out.println(tableroprueba.toString());
		
		
		
		// otro más
		Tablero tableroPatron3 = new Tablero(new Coordenada(3,1));
		tableroPatron3.setCelda(new Coordenada(0,0), EstadoCelda.VIVA);
		tableroPatron3.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);
		tableroPatron3.setCelda(new Coordenada(2,0), EstadoCelda.VIVA);

		//System.out.println(tableroPatron3.toString());
		Patron patron3 = new Patron("Parpadeador", tableroPatron3);
		System.out.println(patron3.toString());
	
	}*/
	
	
}
