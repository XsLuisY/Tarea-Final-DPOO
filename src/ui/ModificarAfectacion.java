package ui;


import interfaces.AsignableAfectaciones;

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

import clases.Afectacion;
import clases.AfectacionPared;
import clases.AfectacionTecho;
import clases.FichaTecnicaDO;

// ----------------------------------LISTO------------------------------------------
public class ModificarAfectacion extends JFrame{
	private static ModificarAfectacion modificarAfectacion;
	private static final long serialVersionUID = 1L;

	private AsignableAfectaciones gestion;
	private FichaTecnicaDO ficha;
	private Afectacion afectacion;

	private JPanel contentPane;
	private JPanel panelAfectaciones;

	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JComboBox<String> comboBoxTipoAfectacion;
	private JComboBox<String> comboBoxEsDerrumbeTotal;
	private JLabel lblTipoAfectacion;
	private JLabel labelMaterialPredominante;
	private JLabel lblGravedad;

	private JTextField textFieldMaterialPredominante;

	private JButton btnModificar;

	//Singleton
	public static ModificarAfectacion getModificarAfectacion(AsignableAfectaciones gestion, FichaTecnicaDO ficha, Afectacion afectacion){
		if(modificarAfectacion==null
				|| !modificarAfectacion.gestion.equals(gestion)
				|| !modificarAfectacion.ficha.equals(ficha)
				|| !modificarAfectacion.afectacion.equals(afectacion))
			modificarAfectacion= new ModificarAfectacion(gestion,ficha,afectacion);
		return modificarAfectacion;
	}

	//Constructor
	private ModificarAfectacion(AsignableAfectaciones gestion, FichaTecnicaDO ficha, Afectacion afectacion) {
		setTitle("Modificar afectación");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 170);		
		this.ficha = ficha;
		this.gestion=gestion;
		this.afectacion=afectacion;

		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());

		rellenarFormulario();
	}

	//Atributos
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
		if (panelAfectaciones==null){
			panelAfectaciones = new JPanel();
			panelAfectaciones.setBackground(Color.ORANGE);
			panelAfectaciones.setBounds(0, 0, 264, 107);
			panelAfectaciones.setLayout(null);
			panelAfectaciones.add(getComboBoxTipoAfectacion());
			panelAfectaciones.add(getLblTipoAfectacion());
			panelAfectaciones.add(getLabelMaterialPredominante());
			panelAfectaciones.add(getTextFieldMaterialPredominante());
			panelAfectaciones.add(getBtnModificar());
			panelAfectaciones.add(getComboBoxEsDerrumbeTotal());
			panelAfectaciones.add(getLblGravedad());
		}
		return panelAfectaciones;
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
					regresar();
				}
			});			
		}
		return mntmRegresar;
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
	public JLabel getLblGravedad() {
		if (lblGravedad == null) {
			lblGravedad = new JLabel("Gravedad:");
			lblGravedad.setBounds(10, 66, 75, 20);
		}
		return lblGravedad;
	}

	public JTextField getTextFieldMaterialPredominante(){
		if(textFieldMaterialPredominante==null){
			textFieldMaterialPredominante = new JTextField();
			textFieldMaterialPredominante.setBounds(139, 42, 115, 17);			
			textFieldMaterialPredominante.setColumns(10);
		}
		return textFieldMaterialPredominante;
	}

	public JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar");
			btnModificar.setForeground(Color.ORANGE);
			btnModificar.setBackground(Color.DARK_GRAY);
			btnModificar.setBounds(165, 73, 89, 23);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modMaterial();
				}
			});
		}
		return btnModificar;
	}

	//Metodos

	private void rellenarFormulario() {
		getTextFieldMaterialPredominante().setText(afectacion.getMaterialPredominante());
		getComboBoxEsDerrumbeTotal().setSelectedItem(afectacion.getEsDerrumbeTotal() ? "Total" : "Parcial");
		getComboBoxTipoAfectacion().setEnabled(false);
		if (afectacion instanceof AfectacionTecho) {
			getComboBoxTipoAfectacion().setSelectedItem("Techo");
		} else 
			getComboBoxTipoAfectacion().setSelectedItem(((AfectacionPared)afectacion).getEsDeCarga() ? "Pared de carga" : "Pared");
	}
	private void limpiarCampos() {

		getTextFieldMaterialPredominante().setText("");	 
		getComboBoxTipoAfectacion().setSelectedIndex(0);	
		getComboBoxEsDerrumbeTotal().setSelectedIndex(0);
	}
	public void modMaterial(){
		Object seleccionTipo = getComboBoxTipoAfectacion().getSelectedItem();
		Object seleccionGravedad = getComboBoxEsDerrumbeTotal().getSelectedItem();
		String material = getTextFieldMaterialPredominante().getText();

		if (seleccionTipo == null || seleccionTipo.toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(modificarAfectacion, "Debes seleccionar un tipo de afectación.", "Validación", JOptionPane.WARNING_MESSAGE);
		} else if (seleccionGravedad == null) {
			JOptionPane.showMessageDialog(modificarAfectacion, "Debes seleccionar la gravedad del derrumbe.", "Validación", JOptionPane.WARNING_MESSAGE);
		} else if (material == null || material.trim().isEmpty()) {
			JOptionPane.showMessageDialog(modificarAfectacion, "Debes ingresar el material predominante.", "Validación", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				String tipo = seleccionTipo.toString();
				String materialLimpio = material.trim();
				boolean esDerrumbeTotal = seleccionGravedad.toString().equals("Total");

				afectacion.setMaterialPredominante(materialLimpio);
				afectacion.setEsDerrumbeTotal(esDerrumbeTotal);

				if (afectacion instanceof AfectacionPared) {
					AfectacionPared pared = (AfectacionPared) afectacion;
					pared.setEsDeCarga(tipo.equals("Pared de carga"));
				}						
				JOptionPane.showMessageDialog(modificarAfectacion, "Afectación modificada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				gestion.actualizarTableAfectaciones(ficha.getAfectaciones());			
				dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(modificarAfectacion, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void regresar(){
		limpiarCampos();
		dispose();
	}













}









