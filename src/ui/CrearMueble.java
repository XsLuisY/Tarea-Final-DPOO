package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

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
		setBounds(100, 100, 280, 160);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidadAfectada = new JLabel("Cantidad\r\n:");
		lblCantidadAfectada.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadAfectada.setToolTipText("");
		lblCantidadAfectada.setBounds(29, 55, 76, 17);
		contentPane.add(lblCantidadAfectada);
		
		JLabel lblInmueble = new JLabel("Mueble:");
		lblInmueble.setHorizontalAlignment(SwingConstants.CENTER);
		lblInmueble.setBounds(10, 27, 95, 17);
		contentPane.add(lblInmueble);
		
		textField = new JTextField();
		lblInmueble.setLabelFor(textField);
		textField.setColumns(10);
		textField.setBounds(105, 24, 115, 20);
		contentPane.add(textField);
		
		JSpinner spinner = new JSpinner();
		lblCantidadAfectada.setLabelFor(spinner);
		spinner.setBounds(170, 53, 50, 20);
		contentPane.add(spinner);
		
		JButton buttonAgregar = new JButton("Agregar");
		buttonAgregar.setBounds(83, 83, 89, 23);
		contentPane.add(buttonAgregar);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
