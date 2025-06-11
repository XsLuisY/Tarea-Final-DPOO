package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PreguntarMatPredPared extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroupEsDeCarga = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreguntarMatPredPared frame = new PreguntarMatPredPared();
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
	public PreguntarMatPredPared() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaterialPredominante = new JLabel("Material predominante en la pared:");
		lblMaterialPredominante.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialPredominante.setBounds(0, 5, 184, 35);
		contentPane.add(lblMaterialPredominante);
		
		textField = new JTextField();
		textField.setBounds(180, 12, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(180, 51, 100, 23);
		contentPane.add(btnEnviar);
		
		JLabel lblesParedDe = new JLabel("\u00BFEs pared de carga?");
		lblesParedDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblesParedDe.setBounds(10, 41, 162, 14);
		contentPane.add(lblesParedDe);
		
		JRadioButton rdbtnS = new JRadioButton("S\u00ED");
		buttonGroupEsDeCarga.add(rdbtnS);
		rdbtnS.setBounds(53, 66, 33, 23);
		contentPane.add(rdbtnS);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		buttonGroupEsDeCarga.add(rdbtnNo);
		rdbtnNo.setBounds(88, 66, 39, 23);
		contentPane.add(rdbtnNo);
	}
}
