package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.MICONS;
import clases.OficinaTramites;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModificarOficinaTramites extends JDialog {

	private static ModificarOficinaTramites modificarOficinaTramites;
	private MICONS micons;
	private OficinaTramites oficina;
	private GestionOficinaTramites gestion;

	private JPanel contentPane;

	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JLabel lblConsejoPopular;

	private JTextField textField;

	private JButton btnModificar;

	//Singleton 
	public static ModificarOficinaTramites getModificarOficinaTramites(OficinaTramites oficina, GestionOficinaTramites gestion){
		if(modificarOficinaTramites==null
				|| !modificarOficinaTramites.oficina.equals(oficina)
				|| !modificarOficinaTramites.gestion.equals(gestion))
			modificarOficinaTramites = new ModificarOficinaTramites(oficina, gestion);
		return modificarOficinaTramites;
	}

	//Constructor
	private ModificarOficinaTramites(OficinaTramites oficina, GestionOficinaTramites gestion) {
		super(gestion, "Modificar Oficina", true);
		micons=MICONS.getMICONS();	
		this.oficina=oficina;
		this.gestion=gestion;

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 190, 180);
		setResizable(false);
		setLocationRelativeTo(gestion);
		setJMenuBar(getBarraSuperior());
		setContentPane(getPane());	       

	}

	//Atributos
	public JPanel getPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getBtnModificar());
			contentPane.add(getLblConsejoPopular());
			contentPane.add(getTextField());
		}
		return contentPane;
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
					regresar();
				}
			});
		}
		return mntmRegresar;
	}

	public JLabel getLblConsejoPopular(){
		if(lblConsejoPopular==null){
			lblConsejoPopular= new JLabel("Consejo Popular:");
			lblConsejoPopular.setHorizontalAlignment(SwingConstants.CENTER);
			lblConsejoPopular.setBounds(10, 11, 164, 14);
		}
		return lblConsejoPopular;
	}

	public JTextField getTextField(){
		if(textField ==null){
			textField = new JTextField();
			textField.setBounds(10, 36, 164, 20);			
			textField.setColumns(10);
			textField.setText(oficina.getConsejoPopular());
		}
		return textField ;
	}

	public JButton getBtnModificar(){
		if(btnModificar==null){
			btnModificar = new JButton("Modificar");
			btnModificar.setBackground(Color.DARK_GRAY);
			btnModificar.setForeground(Color.ORANGE);
			btnModificar.setBounds(85, 73, 89, 23);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificar();
				}
			});

		}
		return btnModificar;
	}

	//Metodo
	private void limpiarCampos() {
		getTextField().setText("");
	}

	public void regresar(){
		limpiarCampos();
		dispose();
	}
	public void modificar(){
		String oficinaModificar = oficina.getConsejoPopular();
		String newConsejoPopular = getTextField().getText().trim();					

		if (!oficinaModificar.equalsIgnoreCase(newConsejoPopular)) 				
			try {
				if(micons.updateOficinaTramites(oficinaModificar, newConsejoPopular)){
					JOptionPane.showMessageDialog(modificarOficinaTramites, "Oficina actualizada exitosamente.");
					gestion.actualizarListaOficinas();
					dispose();
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(modificarOficinaTramites, e.getMessage(), "Error al actualizar", JOptionPane.ERROR_MESSAGE);
			}
		else   
			JOptionPane.showMessageDialog(modificarOficinaTramites, "El nuevo nombre es igual al actual.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

	}




}

