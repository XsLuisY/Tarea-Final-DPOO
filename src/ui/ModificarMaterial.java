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
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ModificarMaterial extends JFrame {

	private JPanel contentPane;
	
	private String[] tipoDerrumbe={"Pared", "Techo"};
	private final ButtonGroup buttonGroupEsDeCarga = new ButtonGroup();
	private JTextField textFieldNombre;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarMaterial frame = new ModificarMaterial();
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
	public ModificarMaterial() {
		setTitle("Modificar material");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 190);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
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
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setForeground(Color.ORANGE);
		btnModificar.setBackground(Color.DARK_GRAY);
		btnModificar.setBounds(165, 93, 89, 23);
		panelAfectaciones.add(btnModificar);
		
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
		
		JLabel lblNewLabel = new JLabel("ID: 5684-5789-4125-4568");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 107, 155, 20);
		panelAfectaciones.add(lblNewLabel);
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
