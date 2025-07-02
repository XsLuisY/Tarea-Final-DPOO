package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import clases.MICONS;

import javax.swing.JTextPane;

import reportes.Reporte_1;
import reportes.Reporte_2;
import reportes.Reporte_3;
import reportes.Reporte_4;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

public class Principal extends JFrame {

	private static Principal principal;
	private MICONS micons;
	private ImageIcon fondo = new ImageIcon(getClass().getResource("/images/fondo.jpeg"));
	private JPanel contentPane;

	private JMenuBar barraSuperior;
	private JMenu gestion;
	private JMenuItem mnGestionarViviendas;
	private JMenuItem mntmGestionarOficinas;
	private JMenu reportes;
	private JMenuItem mntmRepote_1;
	private JMenuItem mntmRepote_2;
	private JMenuItem mntmRepote_3;
	private JMenuItem mntmRepote_4; 
	private JMenuItem mntmCerrarSesion; 
	private JMenuItem mntmCerrarPrograma;
	private JMenuItem mntmBuscar;

	//Singleton
	public static Principal getPrincipal(){
		if(principal==null)
			principal=new Principal();
		return principal;
	}

	//Constructor
	private Principal() {

		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//	setUndecorated(true);
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
			barraSuperior.add(getMntmBuscar());
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
					gestionarViviendas();
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
					gestionarOficinaTramites();
				}
			});
		}
		return mntmGestionarOficinas;
	}

	public JMenu getReportes(){
		if(reportes==null){
			reportes = new JMenu("Reportes");
			reportes.setBackground(Color.DARK_GRAY);
			reportes.setForeground(Color.ORANGE);
			reportes.add(getMntmRepote_1());
			reportes.add(getMntmRepote_2());
			reportes.add(getMntmRepote_3());
			reportes.add(getMntmRepote_4());
		}
		return reportes;
	}
	public JMenuItem getMntmRepote_1(){ 
		if(mntmRepote_1==null){
			mntmRepote_1 = new JMenuItem("Distribuci\u00F3n porcentual de da\u00F1os en viviendas (Tipo I-IV)");
			mntmRepote_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reporte_1();
				}
			});
			mntmRepote_1.setForeground(Color.ORANGE);
			mntmRepote_1.setBackground(Color.DARK_GRAY);

		}
		return  mntmRepote_1;
	}
	public JMenuItem getMntmRepote_2(){
		if(mntmRepote_2==null){
			mntmRepote_2 = new JMenuItem("Viviendas con mayor n\u00FAmero de habitantes vulnerables");
			mntmRepote_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reporte_2();
				}
			});
			mntmRepote_2.setForeground(Color.ORANGE);
			mntmRepote_2.setBackground(Color.DARK_GRAY);
		}
		return mntmRepote_2;
	}
	public JMenuItem getMntmRepote_3(){
		if(mntmRepote_3==null){
			mntmRepote_3= new JMenuItem("Elemento afectado m\u00E1s frecuente (techo/pared)");
			mntmRepote_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reporte_3();
				}
			});
			mntmRepote_3.setForeground(Color.ORANGE);
			mntmRepote_3.setBackground(Color.DARK_GRAY);			
		}
		return mntmRepote_3;
	}
	public JMenuItem getMntmRepote_4(){
		if(mntmRepote_4 == null){
			mntmRepote_4 = new JMenuItem("Cubicaciones con mayor costo por material");
			mntmRepote_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reporte_4();
				}
			});
			mntmRepote_4.setForeground(Color.ORANGE);
			mntmRepote_4.setBackground(Color.DARK_GRAY);			
		}
		return mntmRepote_4;
	}
	public JMenuItem getMntmCerrarSesion(){
		if(mntmCerrarSesion ==null){
			mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
			mntmCerrarSesion.setBackground(Color.DARK_GRAY);
			mntmCerrarSesion.setForeground(Color.ORANGE);
			mntmCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cerrarSesion();
				}
			});
		}
		return mntmCerrarSesion;
	}
	public JMenuItem getMntmBuscar() {
		if (mntmBuscar == null) {
			mntmBuscar = new JMenuItem("Buscar");
			mntmBuscar.setBackground(Color.DARK_GRAY);
			mntmBuscar.setForeground(Color.ORANGE);
			mntmBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Buscar.getBuscar().setVisible(true);
				}
			});

		}
		return mntmBuscar;
	}

	//Metodos
	public void gestionarViviendas(){
		GestionViviendas.getGestionViviendas().setVisible(true);
		//	GestionViviendas.getGestionViviendas().setLocationRelativeTo(Principal.getPrincipal());
		//getBarraSuperior().setVisible(false); 	//TODO Poner en el resto de interfaces
	}
	public void gestionarOficinaTramites(){
		GestionOficinaTramites.getGestionOficinaTramites().setVisible(true);
	}

	public void reporte_1(){
	  try{
		Reporte_1.getReporte_1(micons.buscarAfectacionTipologiaConstructiva()).setVisible(true);
	  } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "No hay datos suficientes para generar el reporte.\n" + e.getMessage(),
            "Error al generar reporte",
            JOptionPane.ERROR_MESSAGE);
    }
	}
	public void reporte_2(){
	  try{
		Reporte_2.getReporte_2(micons.buscarViviendasMasVulnerables()).setVisible(true);
	  } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "No hay datos suficientes para generar el reporte.\n" + e.getMessage(),
            "Error al generar reporte",
            JOptionPane.ERROR_MESSAGE);
    }
	}
	public void reporte_3(){
	  try{
		Reporte_3.getReporte_3(micons.mostrarCantElementoAfectado()).setVisible(true);
	  } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "No hay datos suficientes para generar el reporte.\n" + e.getMessage(),
            "Error al generar reporte",
            JOptionPane.ERROR_MESSAGE);
    }
	}
	public void reporte_4(){
	  try{
		Reporte_4.getReporte_4(micons.mostrarMaterialMasCaro()).setVisible(true);
	  } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "No hay datos suficientes para generar el reporte.\n" + e.getMessage(),
            "Error al generar reporte",
            JOptionPane.ERROR_MESSAGE);
    }
	}

	public void cerrarSesion(){
		Login.getLogin().setVisible(true);
		dispose();
	}


}



