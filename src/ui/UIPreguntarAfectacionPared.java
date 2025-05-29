package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Window.Type;

public class UIPreguntarAfectacionPared extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupAfectacionPared = new ButtonGroup();
	private final ButtonGroup buttonGroupAfectacionTecho = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIPreguntarAfectacionPared frame = new UIPreguntarAfectacionPared();
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
	public UIPreguntarAfectacionPared() {
		setType(Type.UTILITY);
		setTitle("Afectaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("\u00BFPresenta afectacion en alguna pared?");
		lbl1.setBounds(5, 5, 213, 36);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl1);
		
		JButton btnS = new JButton("S\u00ED");
		btnS.setBounds(15, 52, 89, 23);
		contentPane.add(btnS);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(125, 52, 89, 23);
		contentPane.add(btnNo);
	}
}
