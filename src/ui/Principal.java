package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu gestion = new JMenu("Gesti\u00F3n");
		menuBar.add(gestion);
		
		JMenu gestionOficinaTramites = new JMenu("Gestionar Oficinas de Tramites");
		gestion.add(gestionOficinaTramites);
		
		JMenuItem crearOficinaTramites = new JMenuItem("Crear Oficina de Tramites");
		gestionOficinaTramites.add(crearOficinaTramites);
		
		JMenuItem buscarOficinaTramites = new JMenuItem("Buscar Oficina de Tramites");
		gestionOficinaTramites.add(buscarOficinaTramites);
		
		JMenuItem actualizarOficinaTramites = new JMenuItem("Modificar Oficina de Tramites");
		gestionOficinaTramites.add(actualizarOficinaTramites);
		
		JMenuItem mntmEliminarOficinaDe = new JMenuItem("Eliminar Oficina de Tramites");
		gestionOficinaTramites.add(mntmEliminarOficinaDe);
		
		JMenu gestionFichaTecnicaDO = new JMenu("Gestionar Ficha T\u00E9cnica de Da\u00F1os Ocacionados (FTDO)");
		gestion.add(gestionFichaTecnicaDO);
		
		JMenuItem mntmBuscarFtdo = new JMenuItem("Buscar FTDO");
		gestionFichaTecnicaDO.add(mntmBuscarFtdo);
		
		JMenu gestionCubicacion = new JMenu("Gestionar Cubicaciones");
		gestion.add(gestionCubicacion);
		
		JMenuItem buscarCubicacion = new JMenuItem("Bucar Cubicaci\u00F3n");
		gestionCubicacion.add(buscarCubicacion);
		
		JMenu reportes = new JMenu("Reportes");
		menuBar.add(reportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
