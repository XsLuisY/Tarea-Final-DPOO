package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;



//import net.miginfocom.swing.MigLayout;


import javax.swing.SwingConstants;
import javax.swing.JButton;


import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;


public class EliminarVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDireccion;
	private JLabel lblFacilidadTemporal;	
	private JLabel lblDimensiones;
	private JLabel lblLargo;
	private JLabel lblAncho;
	private JLabel lblAltura;
	private JTextField textFieldNombre;
	private JTextField textFieldCI;		
	private JTextField textFieldTipologiaHabitacional;
	private JTextField textFieldTipologiaConstructiva;
	private JLabel lblDatosDeLa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarVivienda frame = new EliminarVivienda();
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
	public EliminarVivienda() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Modificar Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(99, 100, 151, 20);
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setColumns(10);
		contentPane.add(textFieldDireccion);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(5, 103, 94, 14);
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDireccion);
		
		JLabel lblDocumentoLegal = new JLabel("Documento Legal:");
		lblDocumentoLegal.setBounds(5, 195, 150, 20);
		lblDocumentoLegal.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDocumentoLegal);
		
		JLabel lblTipologiaHabitacional = new JLabel("Tipologia Habitacional:");
		lblTipologiaHabitacional.setBounds(5, 175, 150, 20);
		lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblTipologiaHabitacional);
		
		JLabel lblL = new JLabel("Tipolog\u00EDa Constructiva:");
		lblL.setBounds(5, 155, 150, 20);
		lblL.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblL);
		
		lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
		lblFacilidadTemporal.setBounds(5, 135, 150, 20);
		lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblFacilidadTemporal);
		
		JLabel lblDatosDelJefe = new JLabel("Datos del Jefe de N\u00FAcleo:");
		lblDatosDelJefe.setBounds(5, 5, 286, 20);
		lblDatosDelJefe.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDatosDelJefe);
		
		lblDimensiones = new JLabel("Dimensiones (m):");
		lblDimensiones.setBounds(155, 230, 136, 14);
		lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDimensiones);
		
		lblLargo = new JLabel("Largo:");
		lblLargo.setBounds(165, 250, 57, 20);
		lblLargo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblLargo);
		
		JTextField textFieldLargo = new JTextField();
		textFieldLargo.setBounds(222, 250, 28, 20);
		textFieldLargo.setEditable(false);
		contentPane.add(textFieldLargo);
		
		lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(175, 270, 47, 20);
		lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblAncho);
		
		JTextField textFieldAncho = new JTextField();
		textFieldAncho.setBounds(222, 270, 28, 20);
		textFieldAncho.setEditable(false);
		contentPane.add(textFieldAncho);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(175, 290, 47, 20);
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblAltura);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(5, 28, 94, 14);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(99, 25, 151, 20);
		textFieldNombre.setEditable(false);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCI = new JLabel("CI:");
		lblCI.setBounds(5, 48, 94, 14);
		lblCI.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblCI);
		
		textFieldCI = new JTextField();
		textFieldCI.setBounds(99, 45, 151, 20);
		textFieldCI.setEditable(false);
		textFieldCI.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		JTextField textFieldAltura = new JTextField();
		textFieldAltura.setBounds(222, 290, 28, 20);
		textFieldAltura.setEditable(false);
		contentPane.add(textFieldAltura);
		
		JTextField textFieldDocumentoLegal = new JTextField();
		textFieldDocumentoLegal.setBounds(155, 195, 95, 20);
		textFieldDocumentoLegal.setEditable(false);
		contentPane.add(textFieldDocumentoLegal);
		
		textFieldTipologiaHabitacional = new JTextField();
		textFieldTipologiaHabitacional.setBounds(155, 175, 95, 20);
		textFieldTipologiaHabitacional.setEditable(false);
		contentPane.add(textFieldTipologiaHabitacional);
		
		textFieldTipologiaConstructiva = new JTextField();
		textFieldTipologiaConstructiva.setBounds(155, 155, 95, 20);
		textFieldTipologiaConstructiva.setEditable(false);
		contentPane.add(textFieldTipologiaConstructiva);
		
		lblDatosDeLa = new JLabel("Datos de la Vivienda:");
		lblDatosDeLa.setBounds(5, 80, 286, 20);
		lblDatosDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDatosDeLa);
		
		JLabel label = new JLabel("Total:");
		label.setBounds(5, 316, 94, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label);
		
		JTextField textFieldTotal = new JTextField();
		textFieldTotal.setBounds(99, 310, 56, 20);
		textFieldTotal.setEditable(false);
		contentPane.add(textFieldTotal);
		
		JTextField textFieldAncianos = new JTextField();
		textFieldAncianos.setBounds(99, 290, 56, 20);
		textFieldAncianos.setEditable(false);
		contentPane.add(textFieldAncianos);
		
		JLabel label_1 = new JLabel("Ancianos:");
		label_1.setBounds(5, 290, 94, 20);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Embarazadas:");
		label_2.setBounds(5, 270, 94, 20);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label_2);
		
		JTextField textFieldEmbarazadas = new JTextField();
		textFieldEmbarazadas.setBounds(99, 270, 56, 20);
		textFieldEmbarazadas.setEditable(false);
		contentPane.add(textFieldEmbarazadas);
		
		JTextField textFieldNinos = new JTextField();
		textFieldNinos.setBounds(99, 250, 56, 20);
		textFieldNinos.setEditable(false);
		contentPane.add(textFieldNinos);
		
		JLabel label_3 = new JLabel("Ni\u00F1os:");
		label_3.setBounds(5, 250, 94, 20);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Habitantes:");
		label_4.setBounds(5, 230, 150, 14);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label_4);
		
		JTextField textFieldFacilidadTemporal = new JTextField();
		textFieldFacilidadTemporal.setBounds(155, 135, 24, 20);
		textFieldFacilidadTemporal.setEditable(false);
		contentPane.add(textFieldFacilidadTemporal);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(189, 349, 95, 23);
		btnEliminar.setForeground(Color.BLACK);
		contentPane.add(btnEliminar);
		
		JLabel label_5 = new JLabel("3943-2342-3448-2342");
		label_5.setBounds(30, 358, 149, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("ID:");
		label_6.setBounds(5, 358, 15, 14);
		contentPane.add(label_6);
	}
}
