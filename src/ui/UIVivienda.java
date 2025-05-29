package ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
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
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Window.Type;


public class UIVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDireccion;
	private JTextField textFieldCantNinos;
	private JLabel lblFacilidadTemporal;
	private JLabel lblCantidadDeNios;
	private JLabel lblCantidadDeAncianos;
	private JLabel lblCantidadDeEmbarazadas;
	private JLabel lblTotalDeHabitantes;
	private JTextField textFieldCantAncianos;
	private JTextField textFieldCantEmbarazadas;
	private JTextField textFieldTotalHabitantes;
	private JRadioButton rdbtnUsufructo;
	private JRadioButton rdbtnViviendaVinculada;
	private JRadioButton rdbtnArrendamiento;
	private JRadioButton rdbtnProvidencia;
	private JRadioButton rdbtnNoPosee;
	private final ButtonGroup buttonGroupDocumentoLegal = new ButtonGroup();
	private JRadioButton rdbtnTipo1;
	private JRadioButton rdbtnTipo2;
	private JRadioButton rdbtnTipo3;
	private JRadioButton rdbtnTipo4;
	private JRadioButton rdbtnTipo5;
	private final ButtonGroup buttonGroupTipologiaConstructiva = new ButtonGroup();
	private JRadioButton rdbtnCasa;
	private JRadioButton rdbtnApartamento;
	private JRadioButton rdbtnBoho;
	private JRadioButton rdbtnOtro;
	private JRadioButton rdbtnS;
	private JRadioButton rdbtnNo;
	private final ButtonGroup buttonGroupFacilidadTemporal = new ButtonGroup();
	private final ButtonGroup buttonGroupTipologiaHabitacional = new ButtonGroup();
	private JLabel lblDimensiones;
	private JLabel lblLargo;
	private JLabel lblAncho;
	private JLabel lblAltura;
	private JTextField textFieldLargo;
	private JTextField textFieldAncho;
	private JTextField textFieldAltura;
	private JTextField textFieldNombre;
	private JTextField textFieldCI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIVivienda frame = new UIVivienda();
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
	public UIVivienda() {
		setResizable(false);
		setTitle("Formulario de Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(74, 109, 299, 20);
		contentPane.add(textFieldDireccion);
		
		textFieldCantNinos = new JTextField();
		textFieldCantNinos.setColumns(10);
		textFieldCantNinos.setBounds(305, 282, 20, 20);
		contentPane.add(textFieldCantNinos);
		
		JLabel lblNewLabel = new JLabel("Datos de la Vivienda:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(7, 84, 366, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDirección = new JLabel("Direccion:");
		lblDirección.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirección.setBounds(7, 112, 57, 14);
		contentPane.add(lblDirección);
		
		JLabel lblDocumentoLegal = new JLabel("Documento Legal:");
		lblDocumentoLegal.setBounds(14, 215, 86, 26);
		contentPane.add(lblDocumentoLegal);
		
		JLabel lblTipologiaHabitacional = new JLabel("Tipologia Habitacional:");
		lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipologiaHabitacional.setBounds(7, 185, 115, 22);
		contentPane.add(lblTipologiaHabitacional);
		
		JLabel lblL = new JLabel("Tipolog\u00EDa Constructiva:");
		lblL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblL.setBounds(7, 161, 115, 20);
		contentPane.add(lblL);
		
		lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
		lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFacilidadTemporal.setBounds(22, 131, 97, 23);
		contentPane.add(lblFacilidadTemporal);
		
		lblCantidadDeNios = new JLabel("Cantidad de Ni\u00F1os:");
		lblCantidadDeNios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeNios.setBounds(189, 282, 106, 20);
		contentPane.add(lblCantidadDeNios);
		
		lblCantidadDeAncianos = new JLabel("Cantidad de Ancianos:");
		lblCantidadDeAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeAncianos.setBounds(170, 307, 125, 20);
		contentPane.add(lblCantidadDeAncianos);
		
		lblCantidadDeEmbarazadas = new JLabel("Cantidad de embarazadas:");
		lblCantidadDeEmbarazadas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeEmbarazadas.setBounds(160, 332, 135, 20);
		contentPane.add(lblCantidadDeEmbarazadas);
		
		lblTotalDeHabitantes = new JLabel("Total de Habitantes:");
		lblTotalDeHabitantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDeHabitantes.setBounds(189, 360, 106, 17);
		contentPane.add(lblTotalDeHabitantes);
		
		textFieldCantAncianos = new JTextField();
		textFieldCantAncianos.setColumns(10);
		textFieldCantAncianos.setBounds(305, 307, 20, 20);
		contentPane.add(textFieldCantAncianos);
		
		textFieldCantEmbarazadas = new JTextField();
		textFieldCantEmbarazadas.setColumns(10);
		textFieldCantEmbarazadas.setBounds(305, 332, 20, 20);
		contentPane.add(textFieldCantEmbarazadas);
		
		textFieldTotalHabitantes = new JTextField();
		textFieldTotalHabitantes.setColumns(10);
		textFieldTotalHabitantes.setBounds(305, 357, 20, 20);
		contentPane.add(textFieldTotalHabitantes);
		
		JRadioButton rdbtnPropiedad = new JRadioButton("Propiedad");
		buttonGroupDocumentoLegal.add(rdbtnPropiedad);
		rdbtnPropiedad.setBounds(106, 217, 73, 23);
		contentPane.add(rdbtnPropiedad);
		
		JLabel lblDatosDelJefe = new JLabel("Datos del Jefe de N\u00FAcleo:");
		lblDatosDelJefe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJefe.setBounds(7, 11, 366, 14);
		contentPane.add(lblDatosDelJefe);
		
		rdbtnUsufructo = new JRadioButton("Usufructo");
		buttonGroupDocumentoLegal.add(rdbtnUsufructo);
		rdbtnUsufructo.setBounds(181, 217, 73, 23);
		contentPane.add(rdbtnUsufructo);
		
		rdbtnViviendaVinculada = new JRadioButton("Vivienda vinculada");
		buttonGroupDocumentoLegal.add(rdbtnViviendaVinculada);
		rdbtnViviendaVinculada.setBounds(260, 217, 113, 23);
		contentPane.add(rdbtnViviendaVinculada);
		
		rdbtnArrendamiento = new JRadioButton("Arrendamiento");
		buttonGroupDocumentoLegal.add(rdbtnArrendamiento);
		rdbtnArrendamiento.setBounds(106, 243, 97, 23);
		contentPane.add(rdbtnArrendamiento);
		
		rdbtnProvidencia = new JRadioButton("Providencia");
		buttonGroupDocumentoLegal.add(rdbtnProvidencia);
		rdbtnProvidencia.setBounds(202, 243, 81, 23);
		contentPane.add(rdbtnProvidencia);
		
		rdbtnNoPosee = new JRadioButton("No posee");
		buttonGroupDocumentoLegal.add(rdbtnNoPosee);
		rdbtnNoPosee.setBounds(285, 243, 73, 23);
		contentPane.add(rdbtnNoPosee);
		
		rdbtnTipo1 = new JRadioButton("I");
		buttonGroupTipologiaConstructiva.add(rdbtnTipo1);
		rdbtnTipo1.setBounds(128, 160, 29, 23);
		contentPane.add(rdbtnTipo1);
		
		rdbtnTipo2 = new JRadioButton("II");
		buttonGroupTipologiaConstructiva.add(rdbtnTipo2);
		rdbtnTipo2.setBounds(159, 158, 38, 23);
		contentPane.add(rdbtnTipo2);
		
		rdbtnTipo3 = new JRadioButton("III");
		buttonGroupTipologiaConstructiva.add(rdbtnTipo3);
		rdbtnTipo3.setBounds(199, 158, 38, 23);
		contentPane.add(rdbtnTipo3);
		
		rdbtnTipo4 = new JRadioButton("IV");
		buttonGroupTipologiaConstructiva.add(rdbtnTipo4);
		rdbtnTipo4.setBounds(239, 158, 38, 23);
		contentPane.add(rdbtnTipo4);
		
		rdbtnTipo5 = new JRadioButton("V");
		buttonGroupTipologiaConstructiva.add(rdbtnTipo5);
		rdbtnTipo5.setBounds(279, 158, 38, 23);
		contentPane.add(rdbtnTipo5);
		
		rdbtnCasa = new JRadioButton("Casa");
		buttonGroupTipologiaHabitacional.add(rdbtnCasa);
		rdbtnCasa.setBounds(128, 185, 49, 23);
		contentPane.add(rdbtnCasa);
		
		rdbtnApartamento = new JRadioButton("Apartamento");
		buttonGroupTipologiaHabitacional.add(rdbtnApartamento);
		rdbtnApartamento.setBounds(179, 185, 89, 23);
		contentPane.add(rdbtnApartamento);
		
		rdbtnBoho = new JRadioButton("Boh\u00EDo");
		buttonGroupTipologiaHabitacional.add(rdbtnBoho);
		rdbtnBoho.setBounds(266, 184, 51, 23);
		contentPane.add(rdbtnBoho);
		
		rdbtnOtro = new JRadioButton("Otro");
		buttonGroupTipologiaHabitacional.add(rdbtnOtro);
		rdbtnOtro.setBounds(317, 184, 49, 23);
		contentPane.add(rdbtnOtro);
		
		rdbtnS = new JRadioButton("S\u00ED");
		buttonGroupFacilidadTemporal.add(rdbtnS);
		rdbtnS.setBounds(118, 131, 39, 23);
		contentPane.add(rdbtnS);
		
		rdbtnNo = new JRadioButton("No");
		buttonGroupFacilidadTemporal.add(rdbtnNo);
		rdbtnNo.setBounds(159, 131, 38, 23);
		contentPane.add(rdbtnNo);
		
		lblDimensiones = new JLabel("Dimensiones:");
		lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimensiones.setBounds(7, 282, 128, 14);
		contentPane.add(lblDimensiones);
		
		lblLargo = new JLabel("Largo:");
		lblLargo.setBounds(7, 308, 46, 14);
		contentPane.add(lblLargo);
		
		lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(7, 333, 46, 14);
		contentPane.add(lblAncho);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(7, 358, 46, 14);
		contentPane.add(lblAltura);
		
		textFieldLargo = new JTextField();
		textFieldLargo.setBounds(49, 305, 86, 20);
		contentPane.add(textFieldLargo);
		textFieldLargo.setColumns(10);
		
		textFieldAncho = new JTextField();
		textFieldAncho.setBounds(49, 330, 86, 20);
		contentPane.add(textFieldAncho);
		textFieldAncho.setColumns(10);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(49, 355, 86, 20);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(18, 34, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(74, 31, 299, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCI = new JLabel("CI:");
		lblCI.setBounds(44, 59, 20, 14);
		contentPane.add(lblCI);
		
		textFieldCI = new JTextField();
		textFieldCI.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldCI.setBounds(74, 56, 129, 20);
		contentPane.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(284, 388, 89, 23);
		contentPane.add(btnEnviar);
	}
}
