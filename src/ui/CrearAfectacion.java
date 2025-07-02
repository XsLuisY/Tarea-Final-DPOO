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

import clases.FichaTecnicaDO;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

// ----------------------------------LISTO------------------------------------------
public class CrearAfectacion extends JFrame{

	private static final long serialVersionUID = 1L;
	private static CrearAfectacion crearAfectacion=null;

	private AsignableAfectaciones gestion;
	private FichaTecnicaDO ficha;

	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JPanel contentPane;
	private JPanel panelAfectaciones;

	private JComboBox<String> comboBoxTipoAfectacion;
	private JComboBox<String> comboBoxEsDerrumbeTotal;

	private JLabel lblTipoAfectacion;
	private JLabel labelMaterialPredominante;
	private JLabel lblGravedad;

	private JTextField textFieldMaterialPredominante;

	private JButton btnAgregar;

	
	//Constructor
	public CrearAfectacion(AsignableAfectaciones gestion, FichaTecnicaDO ficha) {
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		setTitle("Agregar afectaci\u00F3n");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 170);		
		this.ficha = ficha;
		this.gestion=gestion;
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), getPanelAfectaciones(), getComboBoxTipoAfectacion(), getLblTipoAfectacion(), getLabelMaterialPredominante(), getTextFieldMaterialPredominante(), getBtnAgregar(), getComboBoxEsDerrumbeTotal(), getLblGravedad(), getBarraSuperior(), getMntmRegresar()}));
	}

	//Atributos
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

	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBorder(null);
			contentPane.setLayout(null);
			contentPane.add(getPanelAfectaciones());
		}
		return contentPane;
	}
	public JPanel getPanelAfectaciones(){
		if (panelAfectaciones==null){
			panelAfectaciones = new JPanel();
			panelAfectaciones.setBackground(Color.ORANGE);
			panelAfectaciones.setBounds(0, 0, 280, 146);
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
			comboBoxTipoAfectacion.setBounds(149, 11, 115, 20);
		}
		return comboBoxTipoAfectacion;
	}
	public JComboBox<String> getComboBoxEsDerrumbeTotal() {
		if (comboBoxEsDerrumbeTotal == null) {
			comboBoxEsDerrumbeTotal = new JComboBox<String>();
			comboBoxEsDerrumbeTotal.setModel(new DefaultComboBoxModel<String>(new String[] {"Parcial", "Total"}));
			comboBoxEsDerrumbeTotal.setForeground(new Color(0, 0, 0));
			comboBoxEsDerrumbeTotal.setBounds(149, 67, 115, 20);
		}
		return comboBoxEsDerrumbeTotal;
	}

	public JLabel getLblTipoAfectacion(){
		if(lblTipoAfectacion==null){
			lblTipoAfectacion = new JLabel("Tipo de afectaci\u00F3n:");
			lblTipoAfectacion.setHorizontalAlignment(SwingConstants.LEFT);
			lblTipoAfectacion.setBounds(10, 13, 138, 17);
		}
		return lblTipoAfectacion;
	}
	public JLabel getLabelMaterialPredominante(){
		if(labelMaterialPredominante ==null){
			labelMaterialPredominante = new JLabel("Material predominante:");
			labelMaterialPredominante.setHorizontalAlignment(SwingConstants.LEFT);
			labelMaterialPredominante.setBounds(10, 42, 138, 14);
		}
		return labelMaterialPredominante;
	}
	public JLabel getLblGravedad() {
		if (lblGravedad == null) {
			lblGravedad = new JLabel("Gravedad:");
			lblGravedad.setBounds(10, 67, 138, 20);
		}
		return lblGravedad;
	}

	public JTextField getTextFieldMaterialPredominante(){
		if(textFieldMaterialPredominante==null){
			textFieldMaterialPredominante = new JTextField();
			textFieldMaterialPredominante.setBounds(149, 43, 115, 17);			
			textFieldMaterialPredominante.setColumns(10);
		}
		return textFieldMaterialPredominante;
	}

	public JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setForeground(Color.ORANGE);
			btnAgregar.setBackground(Color.DARK_GRAY);
			btnAgregar.setBounds(91, 112, 89, 23);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addAfectacion();				
				}
			});
		}
		return btnAgregar;
	}

	//Metodos
	private void addAfectacion(){	

		try {
			String tipo = getComboBoxTipoAfectacion().getSelectedItem().toString();
			String material = getTextFieldMaterialPredominante().getText();
			boolean esDerrumbeTotal = getComboBoxEsDerrumbeTotal().getSelectedItem().toString().equals("Total");

			if (ficha.addAfectacion(tipo, material, esDerrumbeTotal)) {
				JOptionPane.showMessageDialog(crearAfectacion , "Afectación agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				gestion.actualizarTableAfectaciones(ficha.getAfectaciones());
				limpiarCampos();				
			} else {
				JOptionPane.showMessageDialog(crearAfectacion , "No se pudo agregar la afectación.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(crearAfectacion , e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	private void limpiarCampos() {

		getTextFieldMaterialPredominante().setText("");	 
		getComboBoxTipoAfectacion().setSelectedIndex(0);	
		getComboBoxEsDerrumbeTotal().setSelectedIndex(0);
	}
	public void regresar(){
		limpiarCampos();
		dispose();
	}
}








