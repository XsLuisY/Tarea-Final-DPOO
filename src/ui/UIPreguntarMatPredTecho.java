package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class UIPreguntarMatPredTecho extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIPreguntarMatPredTecho frame = new UIPreguntarMatPredTecho();
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
	public UIPreguntarMatPredTecho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaterialPredominante = new JLabel("Material predominante en el techo:");
		lblMaterialPredominante.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialPredominante.setBounds(0, 0, 184, 35);
		contentPane.add(lblMaterialPredominante);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(180, 7, 100, 20);
		contentPane.add(textField);
		
		JButton button = new JButton("Enviar");
		button.setBounds(180, 46, 100, 23);
		contentPane.add(button);
	}

}
