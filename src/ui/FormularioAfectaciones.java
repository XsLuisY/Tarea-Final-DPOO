package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormularioAfectaciones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAfectaciones frame = new FormularioAfectaciones();
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
	public FormularioAfectaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 504, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Inmueble afectado:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 14, 95, 17);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Cantidad afectada:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 42, 95, 17);
		panel.add(label_1);
		
		JButton button = new JButton("Agregar");
		button.setBounds(343, 110, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Eliminar");
		button_1.setBounds(343, 144, 89, 23);
		panel.add(button_1);
		
		JSpinner spinnerCantAfectada = new JSpinner();
		spinnerCantAfectada.setBounds(115, 39, 40, 20);
		panel.add(spinnerCantAfectada);
		
		textField = new JTextField();
		textField.setBounds(115, 11, 119, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mueble", "Cantidad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(190, 71, 128, 96);
		panel.add(table);
	}
}
