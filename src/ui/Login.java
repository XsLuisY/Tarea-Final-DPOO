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

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Inicio de Sesión");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(321, 0, 123, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 175, 103, 20);
		panel.add(passwordField);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBienvenido.setForeground(Color.ORANGE);
		lblBienvenido.setBackground(new Color(255, 255, 255));
		lblBienvenido.setBounds(10, 11, 103, 31);
		panel.add(lblBienvenido);
		
		JLabel lblIntroduzcaSuContrasea = new JLabel("Contrase\u00F1a:");
		lblIntroduzcaSuContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaSuContrasea.setBounds(10, 159, 103, 14);
		panel.add(lblIntroduzcaSuContrasea);
		
		String[] usuarios ={"Cliente", "Administrador"};
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(10, 115, 103, 14);
		panel.add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(10, 128, 103, 20);
		panel.add(usuario);
		usuario.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(Color.DARK_GRAY);
		btnIniciar.setForeground(Color.ORANGE);
		btnIniciar.setBounds(10, 227, 103, 23);
		panel.add(btnIniciar);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
