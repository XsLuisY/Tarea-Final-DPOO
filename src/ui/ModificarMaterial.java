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

import clases.Material;
import clases.OficinaTramites;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarMaterial extends JFrame {
	private static ModificarMaterial modificarMaterial;
	private static final long serialVersionUID = 1L;
	private OficinaTramites oficina;
	private Material material;
	private GestionMateriales gestion;

	private JTextField textFieldNombre;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JPanel panelAfectaciones;
	private JButton btnModificar;
	private JLabel lblMaterial;
	private JLabel lblUnidadDeMedida;
	private JComboBox<String> comboBox;
	private JLabel lblPrecioUnitario;
	private JTextField textFieldPrecioUnitario;

	//Singleton
	public static ModificarMaterial getModificarMaterial(GestionMateriales gestion, OficinaTramites oficina, Material material){
		if(modificarMaterial==null)
			modificarMaterial= new ModificarMaterial(gestion, oficina, material);
			return modificarMaterial;
	}
	
	//Constuctor
	private ModificarMaterial(GestionMateriales gestion, OficinaTramites oficina, Material material) {
		setTitle("Modificar material");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 190);
		setJMenuBar(getBarraSuperior());
		setContentPane(getPanelAfectaciones());
		this.oficina=oficina;
		this.gestion=gestion;
		this.material=material;

		rellenarFormulario();
	}

	//Atributos
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
	public JPanel getPanelAfectaciones(){
		if(panelAfectaciones==null){
			panelAfectaciones=new JPanel();
			panelAfectaciones.setBackground(Color.ORANGE);
			panelAfectaciones.setBounds(0, 0, 264, 127);
			panelAfectaciones.setLayout(null);
			panelAfectaciones.add(getTextFieldNombre());
			panelAfectaciones.add(getBtnModificar());
			panelAfectaciones.add(getLblMaterial());
			panelAfectaciones.add(getLblUnidadDeMedida());
			panelAfectaciones.add(getComboBox());
			panelAfectaciones.add(getLblPrecioUnitario());
			panelAfectaciones.add(getTextFieldPrecioUnitario());
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
	public JComboBox<String> getComboBox(){
		if(comboBox==null){
			comboBox  = new JComboBox<String>();						
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Metro", "Unidad", "Saco", "Kilogramo", "Litro"}));		
			comboBox.setBounds(140, 36, 114, 20);

		}
		return comboBox;
	}
	public JLabel getLblPrecioUnitario(){ 
		if(lblPrecioUnitario==null){
			lblPrecioUnitario = DefaultComponentFactory.getInstance().createLabel("Precio unitario:");
			lblPrecioUnitario.setBounds(10, 64, 120, 14);
		}
		return lblPrecioUnitario;
	}

	public JTextField getTextFieldPrecioUnitario() {
		if (textFieldPrecioUnitario == null) {
			textFieldPrecioUnitario = new JTextField();
			textFieldPrecioUnitario.setColumns(10);
			textFieldPrecioUnitario.setBounds(140, 61, 76, 20);
		}
		return textFieldPrecioUnitario;
	}
	public JButton getBtnModificar(){
		if(btnModificar ==null){
			btnModificar = new JButton("Modificar");		
			btnModificar.setForeground(Color.ORANGE);
			btnModificar.setBackground(Color.DARK_GRAY);
			btnModificar.setBounds(165, 93, 89, 23);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre = getTextFieldNombre().getText().trim();
					Object selectedItem = getComboBox().getSelectedItem();
					String unidad = selectedItem != null ? selectedItem.toString().trim() : null;
					String precioStr = getTextFieldPrecioUnitario().getText().trim();
					double precio = 0;
					boolean valido = true;

					if (nombre.isEmpty() || unidad == null || unidad.isEmpty() || precioStr.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.","Campos incompletos", JOptionPane.WARNING_MESSAGE);
						valido = false;
					}

					try {
						precio = Double.parseDouble(precioStr);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.","Error de formato", JOptionPane.ERROR_MESSAGE);
						valido = false;
					}

					if (valido) {
						try {
							oficina.updateMaterial(material.getId(), nombre, unidad, precio);
							gestion.actualizarTableMateriales(oficina.getMateriales());
							JOptionPane.showMessageDialog(null, "Material modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} catch (IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return btnModificar;
	}

	//Metodos
	private void rellenarFormulario() {
		getTextFieldNombre().setText(material.getNombre());
		getComboBox().setSelectedItem(material.getUnidadMedida());
		getTextFieldPrecioUnitario().setText(String.valueOf(material.getPrecioUnitario()));

	}
}



