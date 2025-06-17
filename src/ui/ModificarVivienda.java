package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

//import net.miginfocom.swing.MigLayout;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.ComboBoxModel;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import java.awt.Choice;

import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ModificarVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDireccion;
	private JLabel lblFacilidadTemporal;
	private final ButtonGroup buttonGroupDocumentoLegal = new ButtonGroup();
	private final ButtonGroup buttonGroupTipologiaConstructiva = new ButtonGroup();
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private final ButtonGroup buttonGroupFacilidadTemporal = new ButtonGroup();
	private final ButtonGroup buttonGroupTipologiaHabitacional = new ButtonGroup();
	private JLabel lblDimensiones;
	private JLabel lblLargo;
	private JLabel lblAncho;
	private JLabel lblAltura;
	private JTextField textFieldNombre;
	private JTextField textFieldCI;
	
	private String[] tipologiaConstructiva={"Tipo I","Tipo II","Tipo III","Tipo IV","Tipo V"};
	private String[] tipologiaHabitacional={"Casa","Apartamento","Bohío","Otro"};
	private String[] documentoLegal={"Propiedad","Usufructo","Vivienda vinculada","Arrendamiento","Providencia","No posee"};
	private JComboBox comboBoxTipologiaHabitacional;
	private JComboBox comboBoxTipologiaConstructiva;
	private JLabel lblDatosDeLa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarVivienda frame = new ModificarVivienda();
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
	public ModificarVivienda() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Modificar Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 490);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setForeground(Color.ORANGE);
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.setBackground(Color.DARK_GRAY);
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(88, 112, 196, 19);
		contentPane.add(textFieldDireccion);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(11, 114, 67, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblDocumentoLegal = new JLabel("Documento Legal:");
		lblDocumentoLegal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDocumentoLegal.setBounds(0, 221, 144, 19);
		contentPane.add(lblDocumentoLegal);
		
		JLabel lblTipologiaHabitacional = new JLabel("Tipologia Habitacional:");
		lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipologiaHabitacional.setBounds(0, 199, 144, 22);
		contentPane.add(lblTipologiaHabitacional);
		
		JLabel lblL = new JLabel("Tipolog\u00EDa Constructiva:");
		lblL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblL.setBounds(0, 176, 144, 20);
		contentPane.add(lblL);
		
		lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
		lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFacilidadTemporal.setBounds(11, 142, 125, 23);
		contentPane.add(lblFacilidadTemporal);
		
		JLabel lblDatosDelJefe = new JLabel("Datos del Jefe de N\u00FAcleo:");
		lblDatosDelJefe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJefe.setBounds(11, 11, 273, 14);
		contentPane.add(lblDatosDelJefe);
		
		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setBackground(Color.ORANGE);
		buttonGroupFacilidadTemporal.add(rdbtnSi);
		rdbtnSi.setBounds(175, 142, 39, 23);
		contentPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.ORANGE);
		buttonGroupFacilidadTemporal.add(rdbtnNo);
		rdbtnNo.setBounds(216, 142, 48, 23);
		contentPane.add(rdbtnNo);
		
		lblDimensiones = new JLabel("Dimensiones (m):");
		lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimensiones.setBounds(148, 261, 136, 14);
		contentPane.add(lblDimensiones);
		
		lblLargo = new JLabel("Largo:");
		lblLargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLargo.setBounds(175, 286, 39, 20);
		contentPane.add(lblLargo);
		
		lblAncho = new JLabel("Ancho:");
		lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAncho.setBounds(175, 318, 39, 20);
		contentPane.add(lblAncho);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setBounds(175, 353, 39, 20);
		contentPane.add(lblAltura);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(11, 34, 67, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(88, 31, 196, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCI = new JLabel("CI:");
		lblCI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCI.setBounds(11, 59, 67, 14);
		contentPane.add(lblCI);
		
		textFieldCI = new JTextField();
		textFieldCI.setBounds(88, 56, 196, 20);
		contentPane.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.DARK_GRAY);
		btnModificar.setForeground(Color.ORANGE);
		btnModificar.setBounds(195, 407, 89, 23);
		contentPane.add(btnModificar);
		
		JComboBox comboBoxDocumentoLegal = new JComboBox(documentoLegal);
		comboBoxDocumentoLegal.setBounds(165, 220, 95, 20);
		contentPane.add(comboBoxDocumentoLegal);
		
		comboBoxTipologiaHabitacional = new JComboBox(tipologiaHabitacional);
		comboBoxTipologiaHabitacional.setBounds(165, 200, 95, 20);
		contentPane.add(comboBoxTipologiaHabitacional);
		
		comboBoxTipologiaConstructiva = new JComboBox(tipologiaConstructiva);
		comboBoxTipologiaConstructiva.setBounds(165, 180, 95, 20);
		contentPane.add(comboBoxTipologiaConstructiva);
		
		JSpinner spinnerLargo = new JSpinner();
		spinnerLargo.setBounds(242, 286, 41, 20);
		contentPane.add(spinnerLargo);
		
		JSpinner spinnerAncho = new JSpinner();
		spinnerAncho.setBounds(242, 318, 41, 20);
		contentPane.add(spinnerAncho);
		
		JSpinner spinnerAltura = new JSpinner();
		spinnerAltura.setBounds(243, 352, 41, 20);
		contentPane.add(spinnerAltura);
		
		lblDatosDeLa = new JLabel("Datos de la Vivienda:");
		lblDatosDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeLa.setBounds(10, 86, 274, 17);
		contentPane.add(lblDatosDeLa);
		
		JLabel label = new JLabel("Total:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(26, 381, 67, 14);
		contentPane.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(103, 380, 41, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(103, 349, 41, 20);
		contentPane.add(spinner_1);
		
		JLabel label_1 = new JLabel("Ancianos:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(16, 348, 75, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Embarazadas:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(-1, 317, 94, 20);
		contentPane.add(label_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(103, 318, 41, 20);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(103, 287, 41, 20);
		contentPane.add(spinner_3);
		
		JLabel label_3 = new JLabel("Ni\u00F1os:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(16, 286, 75, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Habitantes:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(19, 261, 125, 14);
		contentPane.add(label_4);
		
		JLabel lblId = new JLabel("ID: 3943-2342-3448-2342");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(0, 417, 174, 20);
		contentPane.add(lblId);
	}
}
