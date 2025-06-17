package ui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CrearMaterial extends JFrame {

	private JPanel contentPane;

	private JTextField textFieldNombre;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearMaterial frame = new CrearMaterial();
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
	public CrearMaterial() {
		setTitle("Agregar material");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 190);

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelAfectaciones = new JPanel();
		panelAfectaciones.setBackground(Color.ORANGE);
		panelAfectaciones.setBounds(0, 0, 264, 127);
		contentPane.add(panelAfectaciones);
		panelAfectaciones.setLayout(null);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(96, 11, 158, 20);
		panelAfectaciones.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregar.setForeground(Color.ORANGE);
		btnAgregar.setBackground(Color.DARK_GRAY);
		btnAgregar.setBounds(165, 93, 89, 23);
		panelAfectaciones.add(btnAgregar);

		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(10, 14, 76, 14);
		panelAfectaciones.add(lblMaterial);

		JLabel lblUnidadDeMedida = new JLabel("Unidad de medida:");
		lblUnidadDeMedida.setBounds(10, 39, 120, 14);
		panelAfectaciones.add(lblUnidadDeMedida);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(140, 36, 114, 20);
		panelAfectaciones.add(comboBox);

		JLabel lblPrecioUnitario = DefaultComponentFactory.getInstance().createLabel("Precio unitario:");
		lblPrecioUnitario.setBounds(10, 64, 92, 14);
		panelAfectaciones.add(lblPrecioUnitario);

		textField = new JTextField();
		textField.setBounds(140, 61, 114, 20);
		panelAfectaciones.add(textField);
		textField.setColumns(10);

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
