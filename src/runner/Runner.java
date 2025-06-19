package runner;

import java.awt.EventQueue;

import ui.Login;
import clases.MICONS;

public class Runner {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MICONS micons = new MICONS();														
					Login frame = new Login(micons);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
