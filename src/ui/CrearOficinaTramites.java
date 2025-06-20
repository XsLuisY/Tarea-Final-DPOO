package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class CrearOficinaTramites extends JFrame {
	private MICONS micons;
	private GestionOficinaTramites gestion;
	private JPanel contentPane;
	private JTextField textField;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JButton btnEnviar;
	private JLabel lblConsejoPopular;
	
	public CrearOficinaTramites(GestionOficinaTramites gestion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 170);
		micons=MICONS.getMICONS();	
		this.gestion=gestion;
		setContentPane(getContentPane());		
		setJMenuBar(getBarraSuperior());

	}

	public JPanel getContentPane(){
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
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					
				}
			});
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
	public JButton getBtnEnviar(){
		if(btnEnviar==null){
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBackground(Color.DARK_GRAY);
			btnEnviar.setForeground(Color.ORANGE);
			btnEnviar.setBounds(85, 73, 89, 23);
			btnEnviar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String consejoPopular=textField.getText().trim();
			        if (!consejoPopular.isEmpty()) {		
			            micons.addOficinaTramites(consejoPopular);
			            JOptionPane.showMessageDialog(null, "Oficina agregada exitosamente.");			            
			            gestion.actualizarListaOficinas();
			            dispose();
			        } else {
			            JOptionPane.showMessageDialog(null, "Por favor ingresa un Consejo Popular.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        }
			    }
			});
		}
		return btnEnviar;
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
}

