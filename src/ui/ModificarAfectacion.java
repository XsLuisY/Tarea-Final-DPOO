package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;

import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

import javax.swing.JMenuBar;

import clases.MICONS;

public class ModificarAfectacion extends JFrame {

	private MICONS micons;
	private final ButtonGroup buttonGroupEsDeCarga = new ButtonGroup();
	private String[] tipoDerrumbe={"Pared", "Techo"};

	private JPanel contentPane;
	private JPanel panelAfectaciones;
	private JTextField textFieldMaterialPredominante;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JComboBox comboBox;
	private JLabel lblTipoAfectacion;
	private JLabel labelMaterialPredominante;
	private JButton btnAgregar;


	public ModificarAfectacion() {
		setTitle("Agregar afectaci\u00F3n");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 170);
		micons=MICONS.getMICONS();	
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
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
	public JMenuBar getBarraSuperior(){
		if (barraSuperior==null){
			barraSuperior = new JMenuBar();
			barraSuperior.add(getMntmRegresar());
			setJMenuBar(barraSuperior);
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
	public JPanel getPanelAfectaciones(){
		if (panelAfectaciones==null){
			panelAfectaciones = new JPanel();
			panelAfectaciones.setBackground(Color.ORANGE);
			panelAfectaciones.setBounds(0, 0, 264, 107);
			panelAfectaciones.setLayout(null);
			panelAfectaciones.add(getComboBox());
			panelAfectaciones.add(getLblTipoAfectacion());
			panelAfectaciones.add(getLabelMaterialPredominante());
			panelAfectaciones.add(getTextFieldMaterialPredominante());
			panelAfectaciones.add(getBtnAgregar());
		}
		return panelAfectaciones;
	}

	public JComboBox getComboBox(){
		if(comboBox==null){
			comboBox= new JComboBox(tipoDerrumbe);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pared", "Pared de carga", "Techo"}));
			comboBox.setBounds(139, 11, 115, 20);
		}
		return comboBox;
	}
	public JLabel getLblTipoAfectacion(){
		if(lblTipoAfectacion==null){
			lblTipoAfectacion = new JLabel("Tipo de afectaci\u00F3n:");
			lblTipoAfectacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblTipoAfectacion.setBounds(0, 13, 138, 17);
		}
		return lblTipoAfectacion;
	}
	public JLabel getLabelMaterialPredominante(){
		if(labelMaterialPredominante ==null){
			labelMaterialPredominante = new JLabel("Material predominante:");
			labelMaterialPredominante.setHorizontalAlignment(SwingConstants.CENTER);
			labelMaterialPredominante.setBounds(0, 41, 140, 14);
		}
		return labelMaterialPredominante;
	}
	public JTextField getTextFieldMaterialPredominante(){
		if(textFieldMaterialPredominante==null){
			textFieldMaterialPredominante = new JTextField();
			textFieldMaterialPredominante.setBounds(139, 42, 115, 17);			
			textFieldMaterialPredominante.setColumns(10);
		}
		return textFieldMaterialPredominante;
	}
	public JButton getBtnAgregar(){
		if(btnAgregar==null){
			btnAgregar = new JButton("Modificar");
			btnAgregar.setForeground(Color.ORANGE);
			btnAgregar.setBackground(Color.DARK_GRAY);
			btnAgregar.setBounds(165, 73, 89, 23);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnAgregar;
	}
}
