package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import clases.MICONS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPlantilla extends JFrame {
	private MICONS micons;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	public MostrarPlantilla(MICONS micons) {
		setTitle("Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 485);
		this.micons=micons;
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setForeground(Color.ORANGE);
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mntmRegresar.setBackground(Color.DARK_GRAY);
		mntmRegresar.setForeground(Color.ORANGE);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJefeNucleo = new JLabel("Jefe de N\u00FAcleo:");
		lblJefeNucleo.setBounds(10, 71, 190, 14);
		contentPane.add(lblJefeNucleo);
		
		JLabel lblCI = new JLabel("CI:");
		lblCI.setBounds(10, 96, 190, 14);
		contentPane.add(lblCI);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 147, 190, 14);
		contentPane.add(lblDireccin);
		
		JLabel lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
		lblFacilidadTemporal.setBounds(10, 172, 190, 14);
		contentPane.add(lblFacilidadTemporal);
		
		JLabel lblTipologiaConstructiva = new JLabel("Tipolog\u00EDa Constructiva:");
		lblTipologiaConstructiva.setBounds(10, 197, 190, 14);
		contentPane.add(lblTipologiaConstructiva);
		
		JLabel lblTipologaHabitacional = new JLabel("Tipolog\u00EDa Habitacional:");
		lblTipologaHabitacional.setBounds(10, 224, 190, 14);
		contentPane.add(lblTipologaHabitacional);
		
		JLabel lblDocumentoLegal = new JLabel("Documento Legal:");
		lblDocumentoLegal.setBounds(10, 249, 190, 14);
		contentPane.add(lblDocumentoLegal);
		
		JLabel lblLargo = new JLabel("Largo:");
		lblLargo.setBounds(222, 71, 110, 14);
		contentPane.add(lblLargo);
		
		JLabel lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(222, 96, 110, 14);
		contentPane.add(lblAncho);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(222, 120, 110, 14);
		contentPane.add(lblAltura);
		
		JLabel lblNios = new JLabel("Ni\u00F1os:");
		lblNios.setBounds(222, 174, 110, 14);
		contentPane.add(lblNios);
		
		JLabel lblAncianos = new JLabel("Ancianos:");
		lblAncianos.setBounds(222, 199, 110, 14);
		contentPane.add(lblAncianos);
		
		JLabel lblEmbarazadas = new JLabel("Embarazadas:");
		lblEmbarazadas.setBounds(222, 224, 110, 14);
		contentPane.add(lblEmbarazadas);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(222, 249, 110, 14);
		contentPane.add(lblTotal);
		
		JLabel lblFechaDelLevantamiento = new JLabel("Fecha del Levantamiento:");
		lblFechaDelLevantamiento.setBounds(10, 304, 214, 14);
		contentPane.add(lblFechaDelLevantamiento);
		
		JLabel label_4 = new JLabel("Afectaciones Seg\u00FAn Deterioro");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(342, 23, 240, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Afectaciones al Inmueble");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(592, 21, 240, 14);
		contentPane.add(label_5);
		
		JLabel lblCubicacion = new JLabel("Cubicaci\u00F3n");
		lblCubicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCubicacion.setBounds(342, 198, 490, 14);
		contentPane.add(lblCubicacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 48, 240, 139);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "Material Predominante"
			}
		));
		table_2.setFillsViewportHeight(true);
		table_2.setForeground(Color.ORANGE);
		table_2.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(592, 48, 240, 139);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mueble", "Cantidad"
			}
		));
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(Color.ORANGE);
		table_1.setBackground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(342, 223, 490, 163);
		contentPane.add(scrollPane_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "u/medida", "Precio unitario", "Cantidad", "Precio Total"
			}
		));
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.ORANGE);
		table.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(table);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total:");
		lblPrecioTotal.setBounds(222, 372, 152, 14);
		contentPane.add(lblPrecioTotal);
		
		JLabel lblDimensiones = new JLabel("Dimensiones:");
		lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimensiones.setBounds(222, 46, 110, 14);
		contentPane.add(lblDimensiones);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la Vivienda:");
		lblDatosDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeLa.setBounds(10, 21, 322, 14);
		contentPane.add(lblDatosDeLa);
		
		JLabel lblHabitantes = new JLabel("Habitantes:");
		lblHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitantes.setBounds(222, 146, 110, 14);
		contentPane.add(lblHabitantes);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.DARK_GRAY);
		lblId.setBounds(10, 397, 322, 14);
		contentPane.add(lblId);
	}
}
