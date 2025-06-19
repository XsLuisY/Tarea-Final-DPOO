package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import clases.MICONS;

public class CrearMueble extends JFrame {
	private MICONS micons;
	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JTextField textFieldNombre;
	private JLabel lblCantidadAfectada;
	private JLabel lblMueble;
	private JSpinner spinnerCantidad; 
	private JButton buttonAgregar;


	public CrearMueble(MICONS micons) {
		setType(Type.UTILITY);
		setTitle("Agregar mueble");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 170);
		this.micons=micons;
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
	}
	
	public JMenuBar getBarraSuperior(){ 
		if(barraSuperior==null){
			barraSuperior = new JMenuBar();
			barraSuperior.add(getMntmRegresar());
		}
		return barraSuperior;
	}
	public JMenuItem getMntmRegresar(){
		if(mntmRegresar==null){
			mntmRegresar = new JMenuItem("Regresar");
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getLblCantidadAfectada());
			contentPane.add(getLblMueble());
			contentPane.add(getTextFieldNombre());
			contentPane.add(getSpinnerCantidad());
			contentPane.add(getButtonAgregar());
		}
		return contentPane;
	}
	public JLabel getLblCantidadAfectada(){
		if(lblCantidadAfectada==null){
			lblCantidadAfectada = new JLabel("Cantidad\r\n:");
			lblCantidadAfectada.setHorizontalAlignment(SwingConstants.LEFT);
			lblCantidadAfectada.setToolTipText("");
			lblCantidadAfectada.setBounds(10, 42, 76, 17);
		}
		return lblCantidadAfectada;
	}
	public JLabel getLblMueble(){
		if(lblMueble==null){
			lblMueble = new JLabel("Mueble:");
			lblMueble.setHorizontalAlignment(SwingConstants.LEFT);
			lblMueble.setBounds(10, 14, 76, 17);
		}
		return lblMueble;
	}
	public JTextField getTextFieldNombre(){
		if(textFieldNombre ==null){
			textFieldNombre = new JTextField();
			textFieldNombre.setColumns(10);
			textFieldNombre.setBounds(96, 12, 158, 20);
		}
		return textFieldNombre ;
	}
	public JSpinner getSpinnerCantidad(){
		if(spinnerCantidad==null){
			spinnerCantidad = new JSpinner();
			spinnerCantidad.setBounds(96, 40, 50, 20);		
		}
		return spinnerCantidad;
	}		
	public JButton getButtonAgregar(){
		if(buttonAgregar==null){
			buttonAgregar = new JButton("Agregar");
			buttonAgregar.setBackground(Color.DARK_GRAY);
			buttonAgregar.setForeground(Color.ORANGE);
			buttonAgregar.setBounds(165, 73, 89, 23);
		}
		return buttonAgregar;
	}
}
