package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class CrearMueble extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearMueble frame = new CrearMueble();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearMueble() {
		setType(Type.UTILITY);
		setTitle("Agregar mueble");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 170);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mntmRegresar.setBackground(Color.DARK_GRAY);
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCantidadAfectada = new JLabel("Cantidad\r\n:");
		lblCantidadAfectada.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadAfectada.setToolTipText("");
		lblCantidadAfectada.setBounds(10, 42, 76, 17);
		contentPane.add(lblCantidadAfectada);

		JLabel lblInmueble = new JLabel("Mueble:");
		lblInmueble.setHorizontalAlignment(SwingConstants.LEFT);
		lblInmueble.setBounds(10, 14, 76, 17);
		contentPane.add(lblInmueble);

		textField = new JTextField();
		lblInmueble.setLabelFor(textField);
		textField.setColumns(10);
		textField.setBounds(96, 12, 158, 20);
		contentPane.add(textField);

		JSpinner spinner = new JSpinner();
		lblCantidadAfectada.setLabelFor(spinner);
		spinner.setBounds(96, 40, 50, 20);
		contentPane.add(spinner);

		JButton buttonAgregar = new JButton("Agregar");
		buttonAgregar.setBackground(Color.DARK_GRAY);
		buttonAgregar.setForeground(Color.ORANGE);
		buttonAgregar.setBounds(165, 73, 89, 23);
		contentPane.add(buttonAgregar);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
