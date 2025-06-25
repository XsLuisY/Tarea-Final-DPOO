package ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Login extends JFrame {
	private static Login login;
	private JPanel contentPane;
	private JPasswordField password;
	private JTextField usuario;
	private JPanel panel;
	private JLabel lblBienvenido;
	private JLabel lblContrasena;
	private JLabel lblUsuario;
	private JButton btnIniciar;
	private MICONS micons;
	private JScrollPane scrollPane;
	private JTextPane txtpnUsuarioAdminContrasea;
	private JTextPane lblUsuarioAdmin;

	//Singleton
	public static Login getLogin() {
		if (login == null)
			login = new Login();		
		return login;
	}

	//Constructor
	private Login() {		
		setTitle("Inicio de Sesión");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		micons=MICONS.getMICONS();			
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getScrollPane());
	}

	//Atributos
	public JPanel getPanel(){
		if(panel==null){
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(421, 0, 123, 271);
			panel.setLayout(null);
			panel.add(getPassword());
			panel.add(getLblBienvenido());
			panel.add(getLblContrasena());
			panel.add(getLblUsuario());
			panel.add(getUsuario());
			panel.add(getBtnIniciar());
			panel.add(getLblUsuarioAdmin());
		}
		return panel;
	}
	public JPasswordField getPassword(){
		if(password==null){
			password = new JPasswordField();
			password.setBounds(10, 185, 103, 20);
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
			lblContrasena.setBounds(10, 169, 103, 14);
		}
		return lblContrasena;
	}
	public JLabel getLblUsuario(){
		if(lblUsuario==null){
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsuario.setBounds(10, 125, 103, 14);
		}
		return lblUsuario;
	}
	public JTextField getUsuario(){
		if(usuario==null){
			usuario=new JTextField();
			usuario.setHorizontalAlignment(SwingConstants.CENTER);
			usuario.setBounds(10, 138, 103, 20);
			usuario.setColumns(10);
		}
		return usuario;
	}
	public JButton getBtnIniciar(){ 
		if(btnIniciar==null){
			btnIniciar = new JButton("Iniciar");	
			btnIniciar.setBackground(Color.DARK_GRAY);
			btnIniciar.setForeground(Color.ORANGE);
			btnIniciar.setBounds(10, 237, 103, 23);
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String usuario = getUsuario().getText().trim();
					String password = new String(getPassword().getPassword()).trim();

					if (usuario.equals("admin") && password.equals("1234")){
						JOptionPane.showMessageDialog(null, "¡Bienvenido administrador!");
						dispose();
						Principal.getPrincipal().setVisible(true);
					}
					else 
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
				}
			});
		}			
		return btnIniciar;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 401, 249);
			scrollPane.setViewportView(getTxtpnUsuarioAdminContrasea());
		}
		return scrollPane;
	}
	public JTextPane getTxtpnUsuarioAdminContrasea() {
		if (txtpnUsuarioAdminContrasea == null) {
			txtpnUsuarioAdminContrasea = new JTextPane();
			txtpnUsuarioAdminContrasea.setText("Bienvenido al Sistema de Gesti\u00F3n de Afectaciones MICONS\r\n\r\n Este sistema ha sido desarrollado para el Ministerio de la Construcci\u00F3n de la Rep\u00FAblica de Cuba, con el objetivo de facilitar la digitalizaci\u00F3n y seguimiento de los da\u00F1os ocasionados al fondo habitacional por eventos meteorol\u00F3gicos.\r\n\r\n Durante la etapa recuperativa, el sistema permite:\r\n\r\n   Registrar Oficinas de Tr\u00E1mites creadas por los Consejos Populares.\r\n\r\n   Gestionar Fichas T\u00E9cnicas de Da\u00F1os, donde se recopilan datos detallados sobre viviendas afectadas, sus ocupantes y el tipo de afectaci\u00F3n sufrida.\r\n\r\n   Clasificar y cuantificar afectaciones, desde derrumbes parciales hasta totales, as\u00ED como los materiales constructivos involucrados.\r\n\r\n   Realizar la cubicaci\u00F3n t\u00E9cnica de recursos materiales que deber\u00E1n ser entregados a los damnificados.\r\n\r\n   Emitir plantillas oficiales con informaci\u00F3n consolidada, listas para su tramitaci\u00F3n ante la Defensa Civil y otros organismos.\r\n\r\n   Adem\u00E1s, se incluye un sistema de identificaci\u00F3n y trazabilidad mediante c\u00F3digos \u00FAnicos por entidad (vivienda, afectaci\u00F3n, material, cubicaci\u00F3n y plantilla).\r\n\r\n Por favor, inicie sesi\u00F3n con sus credenciales para comenzar a operar. Cada acci\u00F3n registrada en el sistema busca asegurar una recuperaci\u00F3n m\u00E1s \u00E1gil, justa y documentada para las familias cubanas afectadas.\r\r\n");
			txtpnUsuarioAdminContrasea.setForeground(Color.ORANGE);
			txtpnUsuarioAdminContrasea.setBackground(Color.DARK_GRAY);
		}
		return txtpnUsuarioAdminContrasea;
	}
	public JTextPane getLblUsuarioAdmin() {
		if (lblUsuarioAdmin == null) {
			lblUsuarioAdmin = new JTextPane();
			lblUsuarioAdmin.setForeground(Color.ORANGE);
			lblUsuarioAdmin.setBackground(Color.DARK_GRAY);
			lblUsuarioAdmin.setText("Usuario: admin\t\r\n\r\nContase\u00F1a 1234\t");
			lblUsuarioAdmin.setEditable(false);
			lblUsuarioAdmin.setBounds(10, 36, 103, 81);
		}
		return lblUsuarioAdmin;
	}
}

