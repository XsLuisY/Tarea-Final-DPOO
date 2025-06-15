package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	private CardLayout cardLayout;
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
					frame.setLocationRelativeTo(null);
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu gestion = new JMenu("Gesti\u00F3n");
		gestion.setBackground(Color.DARK_GRAY);
		gestion.setForeground(Color.ORANGE);
		menuBar.add(gestion);
		
		JMenuItem mntmCrearLevantamiento = new JMenuItem("Crear Levantamiento");
		mntmCrearLevantamiento.setHorizontalAlignment(SwingConstants.RIGHT);
		gestion.add(mntmCrearLevantamiento);
		
		JMenuItem mnGestionarViviendas = new JMenuItem("Gestionar Viviendas");
		mnGestionarViviendas.setHorizontalAlignment(SwingConstants.RIGHT);
		gestion.add(mnGestionarViviendas);
		
		JMenu gestionOficinaTramites = new JMenu("Gestionar Oficinas de Tramites");
		gestionOficinaTramites.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionOficinaTramites.setForeground(Color.DARK_GRAY);
		gestion.add(gestionOficinaTramites);
		
		JMenuItem crearOficinaTramites = new JMenuItem("Crear Oficina de Tramites");
		crearOficinaTramites.setHorizontalAlignment(SwingConstants.RIGHT);
		crearOficinaTramites.setForeground(Color.ORANGE);
		crearOficinaTramites.setBackground(Color.DARK_GRAY);
		gestionOficinaTramites.add(crearOficinaTramites);
		
		JMenuItem buscarOficinaTramites = new JMenuItem("Buscar Oficina de Tramites");
		buscarOficinaTramites.setBackground(Color.DARK_GRAY);
		buscarOficinaTramites.setForeground(Color.ORANGE);
		buscarOficinaTramites.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionOficinaTramites.add(buscarOficinaTramites);
		
		JMenuItem actualizarOficinaTramites = new JMenuItem("Modificar Oficina de Tramites");
		actualizarOficinaTramites.setForeground(Color.ORANGE);
		actualizarOficinaTramites.setBackground(Color.DARK_GRAY);
		actualizarOficinaTramites.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionOficinaTramites.add(actualizarOficinaTramites);
		
		JMenuItem mntmEliminarOficinaDe = new JMenuItem("Eliminar Oficina de Tramites");
		mntmEliminarOficinaDe.setForeground(Color.ORANGE);
		mntmEliminarOficinaDe.setBackground(Color.DARK_GRAY);
		mntmEliminarOficinaDe.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionOficinaTramites.add(mntmEliminarOficinaDe);
		
		JMenu gestionFichaTecnicaDO = new JMenu("Gestionar Ficha T\u00E9cnica de Da\u00F1os Ocacionados (FTDO)");
		gestionFichaTecnicaDO.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionFichaTecnicaDO.setForeground(Color.DARK_GRAY);
		gestion.add(gestionFichaTecnicaDO);
		
		JMenuItem mntmCrearFtdo = new JMenuItem("Crear FTDO");
		mntmCrearFtdo.setBackground(Color.DARK_GRAY);
		mntmCrearFtdo.setForeground(Color.ORANGE);
		mntmCrearFtdo.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionFichaTecnicaDO.add(mntmCrearFtdo);
		
		JMenuItem mntmBuscarFtdo = new JMenuItem("Buscar FTDO");
		mntmBuscarFtdo.setBackground(Color.DARK_GRAY);
		mntmBuscarFtdo.setForeground(Color.ORANGE);
		mntmBuscarFtdo.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionFichaTecnicaDO.add(mntmBuscarFtdo);
		
		JMenuItem mntmModificarFtdo = new JMenuItem("Modificar FTDO");
		mntmModificarFtdo.setBackground(Color.DARK_GRAY);
		mntmModificarFtdo.setForeground(Color.ORANGE);
		mntmModificarFtdo.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionFichaTecnicaDO.add(mntmModificarFtdo);
		
		JMenuItem mntmEliminarFtdo = new JMenuItem("Eliminar FTDO");
		mntmEliminarFtdo.setBackground(Color.DARK_GRAY);
		mntmEliminarFtdo.setForeground(Color.ORANGE);
		mntmEliminarFtdo.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionFichaTecnicaDO.add(mntmEliminarFtdo);
		
		JMenu gestionCubicacion = new JMenu("Gestionar Cubicaciones");
		gestionCubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionCubicacion.setForeground(Color.DARK_GRAY);
		gestion.add(gestionCubicacion);
		
		JMenuItem mntmCrearCubicacin = new JMenuItem("Crear Cubicaci\u00F3n");
		mntmCrearCubicacin.setBackground(Color.DARK_GRAY);
		mntmCrearCubicacin.setForeground(Color.ORANGE);
		mntmCrearCubicacin.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionCubicacion.add(mntmCrearCubicacin);
		
		JMenuItem buscarCubicacion = new JMenuItem("Bucar Cubicaci\u00F3n");
		buscarCubicacion.setBackground(Color.DARK_GRAY);
		buscarCubicacion.setForeground(Color.ORANGE);
		buscarCubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionCubicacion.add(buscarCubicacion);
		
		JMenuItem mntmModificarCubicacin = new JMenuItem("Modificar Cubicaci\u00F3n");
		mntmModificarCubicacin.setBackground(Color.DARK_GRAY);
		mntmModificarCubicacin.setForeground(Color.ORANGE);
		mntmModificarCubicacin.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionCubicacion.add(mntmModificarCubicacin);
		
		JMenuItem mntmEliminarCubicacin = new JMenuItem("Eliminar Cubicaci\u00F3n");
		mntmEliminarCubicacin.setBackground(Color.DARK_GRAY);
		mntmEliminarCubicacin.setForeground(Color.ORANGE);
		mntmEliminarCubicacin.setHorizontalAlignment(SwingConstants.RIGHT);
		gestionCubicacion.add(mntmEliminarCubicacin);
		
		JMenu mnGestionarPlanillas = new JMenu("Gestionar Plantillas");
		mnGestionarPlanillas.setHorizontalAlignment(SwingConstants.RIGHT);
		mnGestionarPlanillas.setForeground(Color.DARK_GRAY);
		gestion.add(mnGestionarPlanillas);
		
		JMenuItem mntmCrearPlanilla = new JMenuItem("Crear Plantilla");
		mntmCrearPlanilla.setForeground(Color.ORANGE);
		mntmCrearPlanilla.setBackground(Color.DARK_GRAY);
		mntmCrearPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		mnGestionarPlanillas.add(mntmCrearPlanilla);
		
		JMenuItem mntmBuscarPlanilla = new JMenuItem("Buscar Plantilla");
		mntmBuscarPlanilla.setForeground(Color.ORANGE);
		mntmBuscarPlanilla.setBackground(Color.DARK_GRAY);
		mntmBuscarPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		mnGestionarPlanillas.add(mntmBuscarPlanilla);
		
		JMenuItem mntmModificarPlanilla = new JMenuItem("Modificar Plantilla");
		mntmModificarPlanilla.setForeground(Color.ORANGE);
		mntmModificarPlanilla.setBackground(Color.DARK_GRAY);
		mntmModificarPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		mnGestionarPlanillas.add(mntmModificarPlanilla);
		
		JMenuItem mntmEliminarPlanilla = new JMenuItem("Eliminar Plantilla");
		mntmEliminarPlanilla.setForeground(Color.ORANGE);
		mntmEliminarPlanilla.setBackground(Color.DARK_GRAY);
		mntmEliminarPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		mnGestionarPlanillas.add(mntmEliminarPlanilla);
		
		JMenu reportes = new JMenu("Reportes");
		reportes.setBackground(Color.DARK_GRAY);
		reportes.setHorizontalAlignment(SwingConstants.CENTER);
		reportes.setForeground(Color.ORANGE);
		menuBar.add(reportes);
		
		JMenuItem mntmDistribucinPorcentualDe = new JMenuItem("Distribuci\u00F3n porcentual de da\u00F1os en viviendas (Tipo I-IV)");
		mntmDistribucinPorcentualDe.setForeground(Color.ORANGE);
		mntmDistribucinPorcentualDe.setBackground(Color.DARK_GRAY);
		reportes.add(mntmDistribucinPorcentualDe);
		
		JMenuItem mntmViviendasConMayor = new JMenuItem("Viviendas con mayor n\u00FAmero de habitantes vulnerables");
		mntmViviendasConMayor.setForeground(Color.ORANGE);
		mntmViviendasConMayor.setBackground(Color.DARK_GRAY);
		reportes.add(mntmViviendasConMayor);
		
		JMenuItem mntmElementoAfectadoMs = new JMenuItem("Elemento afectado m\u00E1s frecuente (techo/pared)");
		mntmElementoAfectadoMs.setForeground(Color.ORANGE);
		mntmElementoAfectadoMs.setBackground(Color.DARK_GRAY);
		reportes.add(mntmElementoAfectadoMs);
		
		JMenuItem mntmCubicacionesConMayor = new JMenuItem("Cubicaciones con mayor costo por material");
		mntmCubicacionesConMayor.setForeground(Color.ORANGE);
		mntmCubicacionesConMayor.setBackground(Color.DARK_GRAY);
		reportes.add(mntmCubicacionesConMayor);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
