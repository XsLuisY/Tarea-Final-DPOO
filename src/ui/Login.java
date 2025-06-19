package ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JPopupMenu;

import clases.MICONS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField usuario;
	private JPanel panel;
	private JLabel lblBienvenido;
	private JLabel lblContrasena;
	private JLabel lblUsuario;
	private JButton btnIniciar;
	private MICONS micons;

	public Login(MICONS micons) {
		setTitle("Inicio de Sesión");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.micons=micons;

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	public JPanel getPanel(){
		if(panel==null){
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(321, 0, 123, 271);
			panel.setLayout(null);
			panel.add(getPassword());
			panel.add(getLblBienvenido());
			panel.add(getLblContrasena());
			panel.add(getLblUsuario());
			panel.add(getUsuario());
			panel.add(getBtnIniciar());
		}
		return panel;
	}
	public JPasswordField getPassword(){
		if(password==null){
			password = new JPasswordField();
			password.setBounds(10, 175, 103, 20);
		}
		return password;
	}
	public JLabel getLblBienvenido(){
		if(lblBienvenido==null){			
			lblBienvenido= new JLabel("Bienvenido");
			lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
			lblBienvenido.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblBienvenido.setForeground(Color.ORANGE);
			lblBienvenido.setBackground(new Color(255, 255, 255));
			lblBienvenido.setBounds(10, 11, 103, 31);
		}
		return lblBienvenido;
	}
	public JLabel getLblContrasena(){
		if(lblContrasena==null){
			lblContrasena = new JLabel("Contrase\u00F1a:");
			lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
			lblContrasena.setBounds(10, 159, 103, 14);
		}
		return lblContrasena;
	}
	public JLabel getLblUsuario(){
		if(lblUsuario==null){
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsuario.setBounds(10, 115, 103, 14);
		}
		return lblUsuario;
	}
	public JTextField getUsuario(){
		if(usuario==null){
			usuario=new JTextField();
			usuario.setHorizontalAlignment(SwingConstants.CENTER);
			usuario.setBounds(10, 128, 103, 20);
			usuario.setColumns(10);
		}
		return usuario;
	}
	public JButton getBtnIniciar(){ 
		if(btnIniciar==null){
			btnIniciar = new JButton("Iniciar");	
			btnIniciar.setBackground(Color.DARK_GRAY);
			btnIniciar.setForeground(Color.ORANGE);
			btnIniciar.setBounds(10, 227, 103, 23);
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					Principal p= new Principal(micons);
					p.setVisible(true);
				}
			});	
		}
		return btnIniciar;

	}
}
