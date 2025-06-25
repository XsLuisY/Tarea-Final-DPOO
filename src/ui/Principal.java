package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import Reportes.Reporte_1;
import clases.MICONS;

public class Principal extends JFrame {
	
	private static Principal principal;
	private MICONS micons;

	private JPanel contentPane;

	private JMenuBar barraSuperior;
	private JMenu gestion;
	private JMenuItem mnGestionarViviendas;
	private JMenuItem mntmGestionarOficinas;
	private JMenu reportes;
	private JMenuItem mntmDistribucinPorcentual;
	private JMenuItem mntmViviendasConMayor;
	private JMenuItem mntmElementoAfectadoMs;
	private JMenuItem mntmCubicacionesConMayor; 
	private JMenuItem mntmCerrarSesion; 
	private JButton btnHacerLevantamiento;
	private JMenuItem mntmCerrarPrograma;

	//Singleton
	public static Principal getPrincipal(){
		if(principal==null)
			principal=new Principal();
		return principal;
	}
	
	//Constructor
	private Principal() {
		micons=MICONS.getMICONS();	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);

		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
	}
	
	//Atributos
	public JPanel getContentPane(){
		if(contentPane==null){			
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getBtnHacerLevantamiento());	
		}
		return contentPane;
	}

	public JMenuBar getBarraSuperior(){
		if(barraSuperior==null){
			barraSuperior=new JMenuBar();
			barraSuperior.setForeground(Color.ORANGE);
			barraSuperior.setBackground(Color.DARK_GRAY);
			barraSuperior.add(getGestion());
			barraSuperior.add(getReportes());
			barraSuperior.add(getMntmCerrarSesion());			
			barraSuperior.add(getMntmCerrarPrograma());
		}
		return barraSuperior;
	} 

	public JMenuItem getMntmCerrarPrograma(){
		if(mntmCerrarPrograma==null){
			mntmCerrarPrograma= new JMenuItem("Cerrar Programa");
			mntmCerrarPrograma.setBackground(Color.DARK_GRAY);
			mntmCerrarPrograma.setForeground(Color.ORANGE);
			mntmCerrarPrograma.setHorizontalAlignment(SwingConstants.LEFT);
			mntmCerrarPrograma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmCerrarPrograma;
	}

	public JMenu getGestion(){
		if(gestion==null){
			gestion = new JMenu("Gesti\u00F3n");
			gestion.setBackground(Color.DARK_GRAY);
			gestion.setForeground(Color.ORANGE);
			gestion.add(getMnGestionarViviendas());
			gestion.add(getMntmGestionarOficinas());
		}
		return gestion;
	}
	public JMenuItem getMnGestionarViviendas(){
		if(mnGestionarViviendas==null){
			mnGestionarViviendas= new JMenuItem("Gestionar Viviendas");
			mnGestionarViviendas.setBackground(Color.DARK_GRAY);
			mnGestionarViviendas.setForeground(Color.ORANGE);
			mnGestionarViviendas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					GestionViviendas.getGestionViviendas().setVisible(true);
				}
			});
		}
		return mnGestionarViviendas;
	}
	public JMenuItem getMntmGestionarOficinas(){
		if(mntmGestionarOficinas==null){
			mntmGestionarOficinas = new JMenuItem("Gestionar Oficinas de Tr\u00E1mites");
			mntmGestionarOficinas.setBackground(Color.DARK_GRAY);
			mntmGestionarOficinas.setForeground(Color.ORANGE);
			mntmGestionarOficinas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionOficinaTramites.getGestionOficinaTramites().setVisible(true);
				}
			});
		}
		return mntmGestionarOficinas;
	}

	public JMenu getReportes(){
		if(reportes==null){
			reportes = new JMenu("Reportes");
			reportes.setBackground(Color.DARK_GRAY);
			reportes.setHorizontalAlignment(SwingConstants.CENTER);
			reportes.setForeground(Color.ORANGE);
			reportes.add(getMntmDistribucinPorcentual());
			reportes.add(getMntmViviendasConMayor());
			reportes.add(getMntmElementoAfectadoMs());
			reportes.add(getMntmCubicacionesConMayor());
		}
		return reportes;
	}
	public JMenuItem getMntmDistribucinPorcentual(){ 
		if(mntmDistribucinPorcentual==null){
			mntmDistribucinPorcentual = new JMenuItem("Distribuci\u00F3n porcentual de da\u00F1os en viviendas (Tipo I-IV)");
			mntmDistribucinPorcentual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Reporte_1.getReporte_1(micons.buscarAfectacionTipologiaConstructiva()).setVisible(true);
				}
			});
			mntmDistribucinPorcentual.setForeground(Color.ORANGE);
			mntmDistribucinPorcentual.setBackground(Color.DARK_GRAY);
			
		}
		return  mntmDistribucinPorcentual;
	}
	public JMenuItem getMntmViviendasConMayor(){
		if(mntmViviendasConMayor==null){
			mntmViviendasConMayor = new JMenuItem("Viviendas con mayor n\u00FAmero de habitantes vulnerables");
			mntmViviendasConMayor.setForeground(Color.ORANGE);
			mntmViviendasConMayor.setBackground(Color.DARK_GRAY);
		}
		return mntmViviendasConMayor;
	}
	public JMenuItem getMntmElementoAfectadoMs(){
		if(mntmElementoAfectadoMs==null){
			mntmElementoAfectadoMs= new JMenuItem("Elemento afectado m\u00E1s frecuente (techo/pared)");
			mntmElementoAfectadoMs.setForeground(Color.ORANGE);
			mntmElementoAfectadoMs.setBackground(Color.DARK_GRAY);			
		}
		return mntmElementoAfectadoMs;
	}


	public JMenuItem getMntmCubicacionesConMayor(){
		if(mntmCubicacionesConMayor == null){
			mntmCubicacionesConMayor = new JMenuItem("Cubicaciones con mayor costo por material");
			mntmCubicacionesConMayor.setForeground(Color.ORANGE);
			mntmCubicacionesConMayor.setBackground(Color.DARK_GRAY);			
		}
		return mntmCubicacionesConMayor;
	}
	public JMenuItem getMntmCerrarSesion(){
		if(mntmCerrarSesion ==null){
			mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
			mntmCerrarSesion.setBackground(Color.DARK_GRAY);
			mntmCerrarSesion.setForeground(Color.ORANGE);
			mntmCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
			mntmCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					Login login =Login.getLogin();
					login.setVisible(true);
				}
			});
		}
		return mntmCerrarSesion;
	}
	public JButton getBtnHacerLevantamiento(){
		if(btnHacerLevantamiento==null){
			btnHacerLevantamiento= new JButton("Hacer Levantamiento");
			btnHacerLevantamiento.setBackground(Color.DARK_GRAY);
			btnHacerLevantamiento.setForeground(Color.ORANGE);
			btnHacerLevantamiento.setBounds(364, 266, 170, 23);			
		}
		return btnHacerLevantamiento;
	}
}