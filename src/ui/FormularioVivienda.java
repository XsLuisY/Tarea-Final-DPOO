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

import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JSpinner;
import java.awt.Color;


public class FormularioVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDireccion;
	private JLabel lblFacilidadTemporal;
	private JLabel lblCantidadDeNios;
	private JLabel lblCantidadDeAncianos;
	private JLabel lblCantidadDeEmbarazadas;
	private JLabel lblTotalDeHabitantes;
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
	private JSpinner spinnerNinos;
	private JSpinner spinnerAncianos;
	private JSpinner spinnerEmbarazadas;
	private JSpinner spinnerTotalHabitantes;
	private JLabel lblCantidadDeHabitantes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioVivienda frame = new FormularioVivienda();
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
	public FormularioVivienda() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Formulario de la Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(88, 82, 157, 19);
		contentPane.add(textFieldDireccion);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(21, 84, 57, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblDocumentoLegal = new JLabel("Documento Legal:");
		lblDocumentoLegal.setBounds(50, 187, 86, 19);
		contentPane.add(lblDocumentoLegal);
		
		JLabel lblTipologiaHabitacional = new JLabel("Tipologia Habitacional:");
		lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipologiaHabitacional.setBounds(21, 165, 115, 22);
		contentPane.add(lblTipologiaHabitacional);
		
		JLabel lblL = new JLabel("Tipolog\u00EDa Constructiva:");
		lblL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblL.setBounds(21, 146, 115, 20);
		contentPane.add(lblL);
		
		lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
		lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFacilidadTemporal.setBounds(37, 112, 99, 23);
		contentPane.add(lblFacilidadTemporal);
		
		lblCantidadDeNios = new JLabel("Ni\u00F1os:");
		lblCantidadDeNios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeNios.setBounds(164, 243, 38, 20);
		contentPane.add(lblCantidadDeNios);
		
		lblCantidadDeAncianos = new JLabel("Ancianos:");
		lblCantidadDeAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeAncianos.setBounds(154, 305, 48, 20);
		contentPane.add(lblCantidadDeAncianos);
		
		lblCantidadDeEmbarazadas = new JLabel("Embarazadas:");
		lblCantidadDeEmbarazadas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeEmbarazadas.setBounds(127, 274, 77, 20);
		contentPane.add(lblCantidadDeEmbarazadas);
		
		lblTotalDeHabitantes = new JLabel("Total:");
		lblTotalDeHabitantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDeHabitantes.setBounds(175, 338, 29, 17);
		contentPane.add(lblTotalDeHabitantes);
		
		JLabel lblDatosDelJefe = new JLabel("Datos del Jefe de N\u00FAcleo:");
		lblDatosDelJefe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJefe.setBounds(11, 11, 230, 14);
		contentPane.add(lblDatosDelJefe);
		
		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setBackground(Color.ORANGE);
		buttonGroupFacilidadTemporal.add(rdbtnSi);
		rdbtnSi.setBounds(136, 112, 39, 23);
		contentPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.ORANGE);
		buttonGroupFacilidadTemporal.add(rdbtnNo);
		rdbtnNo.setBounds(175, 112, 38, 23);
		contentPane.add(rdbtnNo);
		
		lblDimensiones = new JLabel("Dimensiones (en metros):");
		lblDimensiones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDimensiones.setBounds(0, 217, 136, 14);
		contentPane.add(lblDimensiones);
		
		lblLargo = new JLabel("Largo:");
		lblLargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLargo.setBounds(37, 256, 39, 20);
		contentPane.add(lblLargo);
		
		lblAncho = new JLabel("Ancho:");
		lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAncho.setBounds(37, 288, 39, 20);
		contentPane.add(lblAncho);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setBounds(37, 323, 39, 20);
		contentPane.add(lblAltura);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(32, 34, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(88, 31, 157, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCI = new JLabel("CI:");
		lblCI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCI.setBounds(58, 59, 20, 14);
		contentPane.add(lblCI);
		
		textFieldCI = new JTextField();
		textFieldCI.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldCI.setBounds(88, 56, 157, 20);
		contentPane.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.BLACK);
		btnEnviar.setBounds(100, 367, 89, 23);
		contentPane.add(btnEnviar);
		
		JComboBox comboBoxDocumentoLegal = new JComboBox(documentoLegal);
		comboBoxDocumentoLegal.setBounds(146, 186, 95, 20);
		contentPane.add(comboBoxDocumentoLegal);
		
		comboBoxTipologiaHabitacional = new JComboBox(tipologiaHabitacional);
		comboBoxTipologiaHabitacional.setBounds(146, 166, 95, 20);
		contentPane.add(comboBoxTipologiaHabitacional);
		
		comboBoxTipologiaConstructiva = new JComboBox(tipologiaConstructiva);
		comboBoxTipologiaConstructiva.setBounds(146, 146, 95, 20);
		contentPane.add(comboBoxTipologiaConstructiva);
		
		JSpinner spinnerLargo = new JSpinner();
		spinnerLargo.setBounds(78, 256, 41, 20);
		contentPane.add(spinnerLargo);
		
		JSpinner spinnerAncho = new JSpinner();
		spinnerAncho.setBounds(78, 288, 41, 20);
		contentPane.add(spinnerAncho);
		
		JSpinner spinnerAltura = new JSpinner();
		spinnerAltura.setBounds(79, 322, 41, 20);
		contentPane.add(spinnerAltura);
		
		spinnerNinos = new JSpinner();
		spinnerNinos.setBounds(204, 243, 41, 20);
		contentPane.add(spinnerNinos);
		
		spinnerAncianos = new JSpinner();
		spinnerAncianos.setBounds(204, 305, 41, 20);
		contentPane.add(spinnerAncianos);
		
		spinnerEmbarazadas = new JSpinner();
		spinnerEmbarazadas.setBounds(204, 274, 41, 20);
		contentPane.add(spinnerEmbarazadas);
		
		spinnerTotalHabitantes = new JSpinner();
		spinnerTotalHabitantes.setBounds(204, 336, 41, 20);
		contentPane.add(spinnerTotalHabitantes);
		
		lblCantidadDeHabitantes = new JLabel("Cantidad de Habitantes:");
		lblCantidadDeHabitantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeHabitantes.setBounds(140, 217, 125, 14);
		contentPane.add(lblCantidadDeHabitantes);
	}
}
