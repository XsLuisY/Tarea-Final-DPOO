package runner;

import java.awt.EventQueue;

import clases.MICONS;
import clases.OficinaTramites;
import ui.Login;


public class Runner {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			private MICONS micons;

			public void run() {
				try {		
					micons=MICONS.getMICONS();		
					micons.inicializarViviendas();
					micons.inicializarOficinaTramites();
					for(OficinaTramites o: micons.getOficinaTramites())
						o.inicializarMateriales();					
					micons.inicializarPlantillaArroyoNaranjo();
					Login frame = Login.getLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
