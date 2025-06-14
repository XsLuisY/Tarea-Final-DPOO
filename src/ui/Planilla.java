package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Planilla extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planilla frame = new Planilla();
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
	public Planilla() {
		setTitle("Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJefeNucleo = new JLabel("Jefe de N\u00FAcleo:");
		lblJefeNucleo.setBounds(10, 11, 214, 14);
		contentPane.add(lblJefeNucleo);
		
		JLabel lblCI = new JLabel("CI:");
		lblCI.setBounds(10, 36, 214, 14);
		contentPane.add(lblCI);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 86, 214, 14);
		contentPane.add(lblDireccin);
		
		JLabel lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
		lblFacilidadTemporal.setBounds(10, 111, 214, 14);
		contentPane.add(lblFacilidadTemporal);
		
		JLabel lblTipologiaConstructiva = new JLabel("Tipolog\u00EDa Constructiva:");
		lblTipologiaConstructiva.setBounds(10, 136, 214, 14);
		contentPane.add(lblTipologiaConstructiva);
		
		JLabel lblTipologaHabitacional = new JLabel("Tipolog\u00EDa Habitacional:");
		lblTipologaHabitacional.setBounds(10, 163, 214, 14);
		contentPane.add(lblTipologaHabitacional);
		
		JLabel lblDocumentoLegal = new JLabel("Documento Legal:");
		lblDocumentoLegal.setBounds(10, 188, 214, 14);
		contentPane.add(lblDocumentoLegal);
		
		JLabel lblLargo = new JLabel("Largo:");
		lblLargo.setBounds(10, 213, 214, 14);
		contentPane.add(lblLargo);
		
		JLabel lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(10, 238, 214, 14);
		contentPane.add(lblAncho);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 262, 214, 14);
		contentPane.add(lblAltura);
		
		JLabel label = new JLabel("Cantidad de Ni\u00F1os:");
		label.setBounds(10, 287, 214, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Cantidad de Ancianos:");
		label_1.setBounds(10, 312, 214, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Cantidad de embarazadas:");
		label_2.setBounds(10, 337, 214, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Total de Habitantes:");
		label_3.setBounds(10, 362, 214, 14);
		contentPane.add(label_3);
		
		JLabel lblFechaDelLevantamiento = new JLabel("Fecha del Levantamiento:");
		lblFechaDelLevantamiento.setBounds(10, 61, 214, 14);
		contentPane.add(lblFechaDelLevantamiento);
		
		JLabel label_4 = new JLabel("Afectaciones Seg\u00FAn Deterioro");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(234, 11, 240, 14);
		contentPane.add(label_4);
		
		JList listAfectaciones = new JList();
		listAfectaciones.setBounds(234, 35, 240, 89);
		contentPane.add(listAfectaciones);
		
		JLabel label_5 = new JLabel("Afectaciones al Inmueble");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(234, 136, 240, 14);
		contentPane.add(label_5);
		
		JList listInmuebleAfectado = new JList();
		listInmuebleAfectado.setBounds(234, 162, 240, 89);
		contentPane.add(listInmuebleAfectado);
		
		JLabel lblCubicacion = new JLabel("Cubicaci\u00F3n");
		lblCubicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCubicacion.setBounds(234, 262, 240, 14);
		contentPane.add(lblCubicacion);
		
		JList listCubicacion = new JList();
		listCubicacion.setBounds(234, 287, 240, 89);
		contentPane.add(listCubicacion);
	}

}
