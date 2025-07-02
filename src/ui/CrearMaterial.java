package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JMenuBar;
import clases.OficinaTramites;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CrearMaterial extends JFrame {

	private static CrearMaterial crearMaterial;
	private static final long serialVersionUID = 1L;

	private OficinaTramites oficina;
	private GestionMateriales gestion;

	private JPanel panelAfectaciones;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JComboBox<String> comboBox;

	private JLabel lblMaterial;
	private JLabel lblUnidadDeMedida;
	private JLabel lblPrecioUnitario;

	private JTextField textFieldNombre;
	private JTextField textFieldPrecioUnitario;

	private JButton btnAgregar;

	//Singleton
	public static CrearMaterial getCrearMaterial(GestionMateriales gestion, OficinaTramites oficina){
		if(crearMaterial==null
				|| !crearMaterial.gestion.equals(gestion)
				|| !crearMaterial.oficina.equals(oficina))
			crearMaterial=new CrearMaterial(gestion, oficina);
		return crearMaterial;
	}

	//Constructor
	private CrearMaterial(GestionMateriales gestion, OficinaTramites oficina) {
		setTitle("Agregar material");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 190);
		setJMenuBar(getBarraSuperior());
		setContentPane(getPanelAfectaciones());
		this.oficina=oficina;
		this.gestion=gestion;
		oficina.getMateriales();

	}

	//Atributos
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
			panelAfectaciones.add(getTextFieldPrecioUnitario());
		}
		return panelAfectaciones;
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
					regresar();
				}
			});
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return mntmRegresar;
	}

	public JComboBox<String> getComboBox(){
		if(comboBox==null){
			comboBox  = new JComboBox<String>();						
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Metro", "Unidad", "Saco", "Kilogramo", "Litro"}));		
			comboBox.setBounds(140, 36, 114, 20);

		}
		return comboBox;
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
	public JLabel getLblPrecioUnitario(){ 
		if(lblPrecioUnitario==null){
			lblPrecioUnitario = DefaultComponentFactory.getInstance().createLabel("Precio unitario:");
			lblPrecioUnitario.setBounds(10, 64, 120, 14);
		}
		return lblPrecioUnitario;
	}

	public JTextField getTextFieldNombre(){
		if(textFieldNombre==null){ 
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(96, 11, 158, 20);
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}	

	public JTextField getTextFieldPrecioUnitario() {
		if (textFieldPrecioUnitario == null) {
			textFieldPrecioUnitario = new JTextField();
			textFieldPrecioUnitario.setColumns(10);
			textFieldPrecioUnitario.setBounds(140, 61, 76, 20);
		}
		return textFieldPrecioUnitario;
	}

	public JButton getBtnAgregar(){
		if(btnAgregar ==null){
			btnAgregar = new JButton("Agregar");		
			btnAgregar.setForeground(Color.ORANGE);
			btnAgregar.setBackground(Color.DARK_GRAY);
			btnAgregar.setBounds(165, 93, 89, 23);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addMaterial();
				}
			});
		}
		return btnAgregar;
	}

	//Metodos
	public void limpiarCampos() {
		getTextFieldNombre().setText("");
		getComboBox().setSelectedIndex(0);
		getTextFieldPrecioUnitario().setText("");
	}
	public void addMaterial(){
		String nombre = getTextFieldNombre().getText().trim();
		Object selectedItem = getComboBox().getSelectedItem();
		String unidad = selectedItem != null ? selectedItem.toString().trim() : null;
		String precioStr = getTextFieldPrecioUnitario().getText().trim();

		if (nombre.isEmpty() || unidad == null || unidad.isEmpty() || precioStr.isEmpty()) 
			JOptionPane.showMessageDialog(crearMaterial, "Por favor complete todos los campos.","Campos incompletos", JOptionPane.WARNING_MESSAGE);
		else {
			try {
				double precio = Double.parseDouble(precioStr);
				oficina.addMaterial(nombre, unidad, precio);
				gestion.updtTableMateriales(oficina.getMateriales());
				JOptionPane.showMessageDialog(crearMaterial, "Material agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos();							
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(crearMaterial, "El precio debe ser un número válido.","Formato incorrecto", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(crearMaterial, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}
	public void regresar(){
		limpiarCampos();
		dispose();
	}
}







