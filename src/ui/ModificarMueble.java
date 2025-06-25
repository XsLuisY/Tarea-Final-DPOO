package ui;

import interfaces.AsignableMuebles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import clases.FichaTecnicaDO;
import clases.Material;
import clases.Mueble;

public class ModificarMueble extends JFrame {	
	private static ModificarMueble modificarMueble;
	private static final long serialVersionUID = 1L;

	private FichaTecnicaDO ficha;
	private AsignableMuebles gestion;
	private Mueble mueble;

	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JTextField textFieldNombre;
	private JLabel lblCantidadAfectada;
	private JLabel lblMueble;
	private JSpinner spinnerCantidad; 
	private JButton buttonModificar;

	//Singleton
	public static ModificarMueble getModificarMueble(AsignableMuebles gestion, FichaTecnicaDO ficha, Mueble mueble){
		if(modificarMueble==null)
			modificarMueble= new ModificarMueble(gestion, ficha, mueble);
		return modificarMueble;
	}

	//Constructor
	private ModificarMueble(AsignableMuebles gestion, FichaTecnicaDO ficha, Mueble mueble) {

		setType(Type.UTILITY);
		setTitle("Modificar mueble");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 170);		
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		this.gestion=gestion;
		this.ficha=ficha;
		this.mueble=mueble;
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
			contentPane.add(getButtonModificar());
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
	public JButton getButtonModificar(){
		if(buttonModificar==null){
			buttonModificar = new JButton("Modificar");
			buttonModificar.setBackground(Color.DARK_GRAY);
			buttonModificar.setForeground(Color.ORANGE);
			buttonModificar.setBounds(165, 73, 89, 23);
			buttonModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre = getTextFieldNombre().getText().trim();
					int cantidad = (int) getSpinnerCantidad().getValue();

					if (nombre.isEmpty()) {
						JOptionPane.showMessageDialog(ModificarMueble.this, "Debes ingresar el nombre del mueble.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else if (cantidad <= 0) {
						JOptionPane.showMessageDialog(ModificarMueble.this, "La cantidad debe ser mayor que cero.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else {
						try {
							boolean updt = ficha.updtMueble(mueble.getNombre(), nombre, cantidad);
							if (updt) {
								JOptionPane.showMessageDialog(ModificarMueble.this, "Mueble modificardo exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								gestion.actualizarTableMuebles(ficha.getMuebles());
								dispose();
							}
						} catch (IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(ModificarMueble.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

		}
		return buttonModificar;
	}


	//Metodos
	private void rellenarFormulario() {
		getTextFieldNombre().setText(mueble.getNombre());
		getSpinnerCantidad().setValue(mueble.getCantidad());
	}
}
