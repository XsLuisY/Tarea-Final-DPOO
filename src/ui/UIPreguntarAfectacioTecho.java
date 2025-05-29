package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;

public class UIPreguntarAfectacioTecho extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIPreguntarAfectacioTecho frame = new UIPreguntarAfectacioTecho();
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
	public UIPreguntarAfectacioTecho() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpresentaAfectacionEn = new JLabel("\u00BFPresenta afectacion en el techo?");
		lblpresentaAfectacionEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblpresentaAfectacionEn.setBounds(0, 0, 224, 47);
		contentPane.add(lblpresentaAfectacionEn);
		
		JButton button = new JButton("S\u00ED");
		button.setBounds(10, 58, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("No");
		button_1.setBounds(125, 58, 89, 23);
		contentPane.add(button_1);
	}

}
