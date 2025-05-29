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

public class UIPreguntarEsDerrumbeTotal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIPreguntarEsDerrumbeTotal frame = new UIPreguntarEsDerrumbeTotal();
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
	public UIPreguntarEsDerrumbeTotal() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblquTipoDe = new JLabel("\u00BFQu\u00E9 tipo de derrumbe presenta?");
		lblquTipoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblquTipoDe.setBounds(0, 5, 184, 14);
		contentPane.add(lblquTipoDe);
		
		JButton btnParcial = new JButton("Parcial");
		btnParcial.setBounds(10, 30, 74, 23);
		contentPane.add(btnParcial);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.setBounds(100, 30, 74, 23);
		contentPane.add(btnTotal);
	}

}
