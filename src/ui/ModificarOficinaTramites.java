package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.MICONS;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModificarOficinaTramites extends JFrame {
	private MICONS micons;
	private JPanel contentPane;
	private JTextField textField;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JButton btnModificar;
	private JLabel lblConsejoPopular;

	public ModificarOficinaTramites(MICONS micons) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 170);
		this.micons=micons;
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());

	}

	public JPanel getContentPane(){
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
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JButton getBtnModificar(){
		if(btnModificar==null){
			btnModificar = new JButton("Modificar");
			btnModificar.setBackground(Color.DARK_GRAY);
			btnModificar.setForeground(Color.ORANGE);
			btnModificar.setBounds(85, 73, 89, 23);
		}
		return btnModificar;
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

