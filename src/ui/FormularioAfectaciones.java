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

public class FormularioAfectaciones extends JFrame {

	private JPanel contentPane;
	
	private String[] tipoDerrumbe={"Pared", "Techo"};
	private final ButtonGroup buttonGroupEsDeCarga = new ButtonGroup();
	private JTextField textFieldMaterialPredominante;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAfectaciones frame = new FormularioAfectaciones();
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
	public FormularioAfectaciones() {
		setTitle("Agregar afectaci\u00F3n");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelAfectaciones = new JPanel();
		panelAfectaciones.setBackground(Color.ORANGE);
		panelAfectaciones.setBounds(0, 0, 264, 101);
		contentPane.add(panelAfectaciones);
		panelAfectaciones.setLayout(null);
		
		JComboBox comboBox = new JComboBox(tipoDerrumbe);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pared", "Pared de carga", "Techo"}));
		comboBox.setBounds(139, 11, 115, 20);
		panelAfectaciones.add(comboBox);
		JLabel lblquTipoDe = new JLabel("Tipo de afectaci\u00F3n:");
		lblquTipoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblquTipoDe.setBounds(0, 13, 138, 17);
		panelAfectaciones.add(lblquTipoDe);
		
		JLabel labelMaterialPredominante = new JLabel("Material predominante:");
		labelMaterialPredominante.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaterialPredominante.setBounds(10, 42, 140, 14);
		panelAfectaciones.add(labelMaterialPredominante);
		
		textFieldMaterialPredominante = new JTextField();
		textFieldMaterialPredominante.setBounds(149, 42, 105, 17);
		panelAfectaciones.add(textFieldMaterialPredominante);
		textFieldMaterialPredominante.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(85, 67, 89, 23);
		panelAfectaciones.add(btnAgregar);
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
