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

public class CrearMueble extends JFrame {	
	private static CrearMueble crearMueble;
	private static final long serialVersionUID = 1L;

	private FichaTecnicaDO ficha;
	private AsignableMuebles gestion;

	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JTextField textFieldNombre;
	private JLabel lblCantidadAfectada;
	private JLabel lblMueble;
	private JSpinner spinnerCantidad; 
	private JButton buttonAgregar;

	//Singleton
		public static CrearMueble getCrearMueble(AsignableMuebles gestion, FichaTecnicaDO ficha){
			if(crearMueble==null)
				crearMueble=new CrearMueble(gestion,ficha);
			return crearMueble;
		}

	//Constructor
	private CrearMueble(AsignableMuebles gestion, FichaTecnicaDO ficha) {
		this.gestion=gestion;
		this.ficha=ficha;

		setType(Type.UTILITY);
		setTitle("Agregar mueble");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 170);		
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
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
			buttonAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre = getTextFieldNombre().getText().trim();
					int cantidad = (int) getSpinnerCantidad().getValue();

					if (nombre.isEmpty()) {
						JOptionPane.showMessageDialog(CrearMueble.this, "Debes ingresar el nombre del mueble.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else if (cantidad <= 0) {
						JOptionPane.showMessageDialog(CrearMueble.this, "La cantidad debe ser mayor que cero.", "Validación", JOptionPane.WARNING_MESSAGE);
					} else {
						try {
							boolean add = ficha.addMueble(nombre, cantidad);
							if (add) {
								JOptionPane.showMessageDialog(CrearMueble.this, "Mueble agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								gestion.actualizarTableMuebles(ficha.getMuebles());
								dispose();
							}
						} catch (IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(CrearMueble.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

		}
		return buttonAgregar;
	}
}
