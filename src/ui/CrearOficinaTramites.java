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


public class CrearOficinaTramites extends JDialog {

	private static final long serialVersionUID = 1L;
	private static CrearOficinaTramites crearOficinaTramites;

	private MICONS micons;
	private GestionOficinaTramites gestion;

	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JLabel lblConsejoPopular;
	private JTextField textField;
	private JButton btnEnviar;


	//Constructor
	public CrearOficinaTramites(GestionOficinaTramites gestion) {
		super(gestion, "Crear Oficina de Tr�mites", true);
		micons=MICONS.getMICONS();	
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
			contentPane.add(getBtnEnviar());
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
		}
		return textField ;
	}

	public JButton getBtnEnviar(){
		if(btnEnviar==null){
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBackground(Color.DARK_GRAY);
			btnEnviar.setForeground(Color.ORANGE);
			btnEnviar.setBounds(85, 73, 89, 23);
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addOficinaTramites();
				}
			});
		}
		return btnEnviar;
	}

	//Metodos
	public void limpiarCampos() {
		getTextField().setText("");
	}
	public void regresar(){
		limpiarCampos();
		dispose();
	}

	public void addOficinaTramites(){
		String consejoPopular=getTextField().getText().trim();

		if (!consejoPopular.isEmpty()){					
			try{									
				if(micons.addOficinaTramites(consejoPopular)){
					JOptionPane.showMessageDialog(crearOficinaTramites, "Oficina agregada exitosamente.");			            
					gestion.actualizarListaOficinas();
					limpiarCampos();
				}
				else	
					JOptionPane.showMessageDialog(crearOficinaTramites, "No se ha podido agregar la Oficina.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			} catch(Exception e){
				JOptionPane.showMessageDialog(crearOficinaTramites, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		}else 
			JOptionPane.showMessageDialog(crearOficinaTramites, "Por favor ingresa un Consejo Popular.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

}



