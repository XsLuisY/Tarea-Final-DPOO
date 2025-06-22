package ui;


import interfaces.GestionAfectaciones;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;

import clases.FichaTecnicaDO;

// ----------------------------------LISTO------------------------------------------
public class CrearAfectacion extends JFrame{

	private static final long serialVersionUID = 1L;
	private GestionAfectaciones gestion;
	private JPanel contentPane;
	private JPanel panelAfectaciones;
	private JTextField textFieldMaterialPredominante;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JComboBox<String> comboBoxTipoAfectacion;
	private JLabel lblTipoAfectacion;
	private JLabel labelMaterialPredominante;
	private JButton btnAgregar;
	private JComboBox<String> comboBoxEsDerrumbeTotal;
	private JLabel lblGravedad;
	private FichaTecnicaDO ficha;

	public CrearAfectacion(GestionAfectaciones gestion, FichaTecnicaDO ficha) {
		setTitle("Agregar afectaci\u00F3n");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 170);		
		this.ficha = ficha;
		this.gestion=gestion;
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
			panelAfectaciones.add(getComboBoxTipoAfectacion());
			panelAfectaciones.add(getLblTipoAfectacion());
			panelAfectaciones.add(getLabelMaterialPredominante());
			panelAfectaciones.add(getTextFieldMaterialPredominante());
			panelAfectaciones.add(getBtnAgregar());
			panelAfectaciones.add(getComboBoxEsDerrumbeTotal());
			panelAfectaciones.add(getLblGravedad());
		}
		return panelAfectaciones;
	}

	public JComboBox<String> getComboBoxTipoAfectacion(){
		if(comboBoxTipoAfectacion==null){
			comboBoxTipoAfectacion= new JComboBox<String>();
			comboBoxTipoAfectacion.setModel(new DefaultComboBoxModel<String>(new String[] {"Pared", "Pared de carga", "Techo"}));
			comboBoxTipoAfectacion.setBounds(139, 11, 115, 20);
		}
		return comboBoxTipoAfectacion;
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
	public JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setForeground(Color.ORANGE);
			btnAgregar.setBackground(Color.DARK_GRAY);
			btnAgregar.setBounds(165, 73, 89, 23);

			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object seleccionTipo = getComboBoxTipoAfectacion().getSelectedItem();
					Object seleccionGravedad = getComboBoxEsDerrumbeTotal().getSelectedItem();
					String material = getTextFieldMaterialPredominante().getText();
					boolean add = false;

					if (seleccionTipo == null || seleccionTipo.toString().trim().isEmpty()) {
						JOptionPane.showMessageDialog(CrearAfectacion.this, "Debes seleccionar un tipo de afectación.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else if (seleccionGravedad == null) {
						JOptionPane.showMessageDialog(CrearAfectacion.this, "Debes seleccionar la gravedad del derrumbe.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else if (material == null || material.trim().isEmpty()) {
						JOptionPane.showMessageDialog(CrearAfectacion.this, "Debes ingresar el material predominante.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else {
						try {
							String tipo = seleccionTipo.toString();
							String materialLimpio = material.trim();
							boolean esDerrumbeTotal = seleccionGravedad.toString().equals("Total");

							add = ficha.addAfectacion(tipo, materialLimpio, esDerrumbeTotal);

							if (add) {
								JOptionPane.showMessageDialog(CrearAfectacion.this, "Afectación agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								gestion.actualizarTableAfectaciones(ficha.getAfectaciones());
								dispose();
							} else {
								JOptionPane.showMessageDialog(CrearAfectacion.this, "No se pudo agregar la afectación.", "Advertencia", JOptionPane.WARNING_MESSAGE);
							}
						} catch (IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(CrearAfectacion.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return btnAgregar;
	}
	public JComboBox<String> getComboBoxEsDerrumbeTotal() {
		if (comboBoxEsDerrumbeTotal == null) {
			comboBoxEsDerrumbeTotal = new JComboBox<String>();
			comboBoxEsDerrumbeTotal.setModel(new DefaultComboBoxModel<String>(new String[] {"Parcial", "Total"}));
			comboBoxEsDerrumbeTotal.setForeground(new Color(0, 0, 0));
			comboBoxEsDerrumbeTotal.setBounds(95, 66, 60, 20);

		}
		return comboBoxEsDerrumbeTotal;
	}
	public JLabel getLblGravedad() {
		if (lblGravedad == null) {
			lblGravedad = new JLabel("Gravedad:");
			lblGravedad.setBounds(10, 66, 75, 20);
		}
		return lblGravedad;
	}

}