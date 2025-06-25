package Reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.Color;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Reporte_3 extends JFrame {

	private static Reporte_3 reporte_3;
	private Map<String, Integer> totalPorAfectacion;

	private JPanel contentPane;
	private JTextPane txtpnElementoConstructivoMs;
	private JLabel lblPared;
	private JLabel lblTecho;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;

	//Singleton 
	public static Reporte_3 getReporte_3(Map<String, Integer> totalPorAfectacion){
		if(reporte_3==null)
			reporte_3=new Reporte_3(totalPorAfectacion);
		return reporte_3;
	}
	
	//Constructor
	private Reporte_3(Map<String, Integer> totalPorAfectacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 180);
		setJMenuBar(getMenuBar_1());
		setContentPane(getContentPane());
		this.totalPorAfectacion=totalPorAfectacion;
	}

	//Atributos 
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getTxtpnElementoConstructivoMs());
			contentPane.add(getLblPared());
			contentPane.add(getLblTecho());
		}
		return contentPane;
	}
	
	public JTextPane getTxtpnElementoConstructivoMs() {
		if (txtpnElementoConstructivoMs == null) {
			txtpnElementoConstructivoMs = new JTextPane();
			txtpnElementoConstructivoMs.setForeground(Color.ORANGE);
			txtpnElementoConstructivoMs.setBackground(Color.DARK_GRAY);
			txtpnElementoConstructivoMs.setText("Elementos constructivos afectados en el conjunto de viviendas evaluadas:\r\n");
			txtpnElementoConstructivoMs.setBounds(10, 11, 104, 95);
		}
		return txtpnElementoConstructivoMs;
	}
	public JLabel getLblPared() {
		if (lblPared == null) {
			lblPared = new JLabel("Pared: "+totalPorAfectacion.get("AfectacionPared").toString());
			lblPared.setBounds(124, 30, 80, 14);
		}
		return lblPared;
	}
	public JLabel getLblTecho() {
		if (lblTecho == null) {
			lblTecho = new JLabel("Techo: "+totalPorAfectacion.get("AfectacionTecho").toString());
			lblTecho.setBounds(124, 70, 80, 14);
		}
		return lblTecho;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.DARK_GRAY);
			menuBar.setForeground(Color.ORANGE);
			menuBar.add(getMntmRegresar());
		}
		return menuBar;
	}
	public JMenuItem getMntmRegresar() {
		if (mntmRegresar == null) {
			mntmRegresar = new JMenuItem("Regresar");
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
		}
		return mntmRegresar;
	}
}
