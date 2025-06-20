package ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JMenuItem;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;

import clases.MICONS;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CrearMaterial extends JFrame {
	private MICONS micons;
	private JPanel contentPane;

	private JTextField textFieldNombre;
	private JTextField textField;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JPanel panelAfectaciones;
	private JButton btnAgregar;
	private JLabel lblMaterial;
	private JLabel lblUnidadDeMedida;
	private JComboBox comboBox;
	private JLabel lblPrecioUnitario;

	public CrearMaterial() {
		setTitle("Agregar material");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 190);
		micons=MICONS.getMICONS();	
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
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return mntmRegresar;
	}
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getPanelAfectaciones());
		}
		return contentPane;
	}
	public JPanel getPanelAfectaciones(){
		if(panelAfectaciones==null){
			panelAfectaciones=new JPanel();
			panelAfectaciones.setBackground(Color.ORANGE);
			panelAfectaciones.setBounds(0, 0, 264, 127);
			panelAfectaciones.setLayout(null);
			panelAfectaciones.add(getTextFieldNombre());
			panelAfectaciones.add(getBtnAgregar());
			panelAfectaciones.add(getLblMaterial());
			panelAfectaciones.add(getLblUnidadDeMedida());
			panelAfectaciones.add(getComboBox());
			panelAfectaciones.add(getLblPrecioUnitario());
		}
		return panelAfectaciones;
	}
	public JTextField getTextFieldNombre(){
		if(textFieldNombre==null){ 
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(96, 11, 158, 20);
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	public JButton getBtnAgregar(){
		if(btnAgregar ==null){
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnAgregar.setForeground(Color.ORANGE);
			btnAgregar.setBackground(Color.DARK_GRAY);
			btnAgregar.setBounds(165, 93, 89, 23);
		}
		return btnAgregar;
	}
	public JLabel getLblMaterial(){
		if(lblMaterial==null){
			lblMaterial = new JLabel("Material:");
			lblMaterial.setBounds(10, 14, 76, 14);
		}
		return lblMaterial;
	}
	public JLabel getLblUnidadDeMedida(){
		if(lblUnidadDeMedida ==null){
			lblUnidadDeMedida = new JLabel("Unidad de medida:");
			lblUnidadDeMedida.setBounds(10, 39, 120, 14);
		}
		return lblUnidadDeMedida ;
	}
	public JComboBox getComboBox(){
		if(comboBox==null){
			comboBox  = new JComboBox();
			comboBox.setBounds(140, 36, 114, 20);
		}
		return comboBox;
	}
	public JLabel getLblPrecioUnitario(){ 
		if(lblPrecioUnitario==null){
			lblPrecioUnitario = DefaultComponentFactory.getInstance().createLabel("Precio unitario:");
			lblPrecioUnitario.setBounds(10, 64, 92, 14);
		}
		return lblPrecioUnitario;
	}
	public JTextField getTextField(){
		if(textField==null){			
			textField = new JTextField();
			textField.setBounds(140, 61, 114, 20);
			panelAfectaciones.add(textField);
			textField.setColumns(10);
		}
		return textField;
	}
}