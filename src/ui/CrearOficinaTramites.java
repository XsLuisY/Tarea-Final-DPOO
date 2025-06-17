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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CrearOficinaTramites extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearOficinaTramites frame = new CrearOficinaTramites();
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
	public CrearOficinaTramites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 170);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.setBackground(Color.DARK_GRAY);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(Color.DARK_GRAY);
		btnEnviar.setForeground(Color.ORANGE);
		btnEnviar.setBounds(85, 73, 89, 23);
		contentPane.add(btnEnviar);
		
		JLabel lblConsejoPopular = new JLabel("Consejo Popular:");
		lblConsejoPopular.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsejoPopular.setBounds(10, 11, 164, 14);
		contentPane.add(lblConsejoPopular);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 164, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
