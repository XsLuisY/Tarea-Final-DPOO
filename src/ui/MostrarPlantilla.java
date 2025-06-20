package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
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
import clases.Plantilla;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPlantilla extends JFrame {
	private Plantilla plantilla;
	private JPanel contentPane;
	private JTable tableCubicacion;
	private JTable tableMuebles;
	private JTable tableAfectacion;
	private JMenuItem mntmRegresar;
	private JMenuBar barraSuperior;
	private JLabel lblJefeNucleo;
	private JLabel lblCI;
	private JLabel lblDireccion;
	private JLabel lblFacilidadTemporal;
	private JLabel lblTipologiaConstructiva;
	private JLabel lblTipologiaHabitacional;
	private JScrollPane scrollPaneAfectacion;
	private JLabel lblCubicacion;
	private JLabel lblMuebles;
	private JLabel lblAfectacion;
	private JLabel lblFechaLevantamiento;
	private JLabel lblTotal;
	private JLabel lblEmbarazadas;
	private JLabel lblAncianos;
	private JLabel lblNinos;
	private JLabel lblAltura;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private JLabel lblDocumentoLegal;
	private JScrollPane scrollPaneMuebles;
	private JScrollPane scrollPaneCubicacion;
	private JLabel lblPrecioTotal;
	private JLabel lblDimensiones;
	private JLabel lblDatosVivienda;
	private JLabel lblHabitantes;
	private JLabel lblId;

	public MostrarPlantilla(Plantilla plantilla) {
		setTitle("Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 485);
		this.plantilla=plantilla;
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
	}

	public JMenuBar getBarraSuperior(){
		if(barraSuperior==null){
			barraSuperior = new JMenuBar();
			barraSuperior.setBackground(Color.DARK_GRAY);
			barraSuperior.setForeground(Color.ORANGE);
			barraSuperior.add(getMntmRegresar());
		}
		return barraSuperior;
	}
	public JMenuItem getMntmRegresar(){
		if(mntmRegresar==null){
			mntmRegresar = new JMenuItem("Regresar");
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JPanel getContentPane(){
		if(contentPane==null){			
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setForeground(new Color(0, 0, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getLblJefeNucleo());
			contentPane.add(getLblCI());
			contentPane.add(getLblDireccion());
			contentPane.add(getLblFacilidadTemporal());
			contentPane.add(getLblTipologiaConstructiva());
			contentPane.add(getLblTipologiaHabitacional());
			contentPane.add(getLblDocumentoLegal());
			contentPane.add(getLblLargo());
			contentPane.add(getLblAncho());
			contentPane.add(getLblAltura());
			contentPane.add(getLblNinos());
			contentPane.add(getLblAncianos());
			contentPane.add(getLblEmbarazadas());
			contentPane.add(getLblTotal());
			contentPane.add(getLblFechaLevantamiento());
			contentPane.add(getLblAfectacion());
			contentPane.add(getLblMuebles());
			contentPane.add(getLblCubicacion());
			contentPane.add(getScrollPaneAfectacion());
			contentPane.add(getScrollPaneMuebles());
			contentPane.add(getScrollPaneCubicacion());
			contentPane.add(getLblPrecioTotal());	
			contentPane.add(getLblDimensiones());	
			contentPane.add(getLblDatosVivienda());	
			contentPane.add(getLblHabitantes());
			contentPane.add(getLblId());
		}
		return contentPane;
	}

	public JLabel getLblJefeNucleo(){
		if(lblJefeNucleo==null){
			lblJefeNucleo= new JLabel("Jefe de N\u00FAcleo:");
			lblJefeNucleo.setBounds(10, 71, 190, 14);
		}
		return lblJefeNucleo;
	}
	public JLabel getLblCI(){
		if(lblCI ==null){
			lblCI = new JLabel("CI:");
			lblCI.setBounds(10, 96, 190, 14);
		}
		return lblCI;
	}
	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion= new JLabel("Direcci\u00F3n:");
			lblDireccion.setBounds(10, 147, 190, 14);
		}
		return lblDireccion;
	}
	public JLabel getLblFacilidadTemporal(){
		if(lblFacilidadTemporal==null){
			lblFacilidadTemporal= new JLabel("Facilidad Temporal:");
			lblFacilidadTemporal.setBounds(10, 172, 190, 14);
		}
		return lblFacilidadTemporal;
	}
	public JLabel getLblTipologiaConstructiva(){
		if(lblTipologiaConstructiva==null){
			lblTipologiaConstructiva= new JLabel("Tipolog\u00EDa Constructiva:");
			lblTipologiaConstructiva.setBounds(10, 197, 190, 14);
		}
		return lblTipologiaConstructiva;
	}
	public JLabel getLblTipologiaHabitacional(){
		if(	lblTipologiaHabitacional==null){
			lblTipologiaHabitacional= new JLabel("Tipolog\u00EDa Habitacional:");
			lblTipologiaHabitacional.setBounds(10, 224, 190, 14);
		}
		return 	lblTipologiaHabitacional;
	}
	public JLabel getLblDocumentoLegal(){
		if( lblDocumentoLegal==null){
			lblDocumentoLegal= new JLabel("Documento Legal:");
			lblDocumentoLegal.setBounds(10, 249, 190, 14);
		}
		return lblDocumentoLegal;
	}
	public JLabel getLblLargo(){
		if(lblLargo ==null){
			lblLargo= new JLabel("Largo:");
			lblLargo.setBounds(222, 71, 110, 14);
		}
		return lblLargo;
	}
	public JLabel getLblAncho(){
		if(lblAncho ==null){
			lblAncho= new JLabel("Ancho:");
			lblAncho.setBounds(222, 96, 110, 14);
		}
		return lblAncho;
	}
	public JLabel getLblAltura(){
		if( lblAltura==null){
			lblAltura= new JLabel("Altura:");
			lblAltura.setBounds(222, 120, 110, 14);
		}
		return lblAltura;
	}
	public JLabel getLblNinos(){
		if( lblNinos==null){
			lblNinos= new JLabel("Ni\u00F1os:");
			lblNinos.setBounds(222, 174, 110, 14);
		}
		return lblNinos;
	}
	public JLabel getLblAncianos(){
		if( lblAncianos==null){
			lblAncianos= new JLabel("Ancianos:");
			lblAncianos.setBounds(222, 199, 110, 14);
		}
		return lblAncianos;
	}
	public JLabel getLblEmbarazadas(){
		if( lblEmbarazadas==null){
			lblEmbarazadas= new JLabel("Embarazadas:");
			lblEmbarazadas.setBounds(222, 224, 110, 14);
		}
		return lblEmbarazadas;
	}
	public JLabel getLblTotal(){
		if( lblTotal==null){
			lblTotal= new JLabel("Total:");
			lblTotal.setBounds(222, 249, 110, 14);
		}
		return lblTotal;
	}
	public JLabel getLblFechaLevantamiento(){
		if( lblFechaLevantamiento==null){
			lblFechaLevantamiento= new JLabel("Fecha del Levantamiento:");
			lblFechaLevantamiento.setBounds(10, 304, 214, 14);
		}
		return lblFechaLevantamiento;
	}
	public JLabel getLblAfectacion(){
		if( lblAfectacion==null){
			lblAfectacion= new JLabel("Afectaciones Seg\u00FAn Deterioro");
			lblAfectacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblAfectacion.setBounds(342, 23, 240, 14);
		}
		return lblAfectacion;
	}
	public JLabel getLblMuebles(){
		if( lblMuebles==null){
			lblMuebles= new JLabel("Afectaciones al Inmueble");
			lblMuebles.setHorizontalAlignment(SwingConstants.CENTER);
			lblMuebles.setBounds(592, 21, 240, 14);
		}
		return lblMuebles;
	}
	public JLabel getLblCubicacion(){
		if( lblCubicacion==null){
			lblCubicacion= new JLabel("Cubicaci\u00F3n");
			lblCubicacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblCubicacion.setBounds(342, 198, 490, 14);
		}
		return lblCubicacion;
	}
	public JScrollPane getScrollPaneAfectacion(){
		if( scrollPaneAfectacion==null){
			scrollPaneAfectacion= new JScrollPane();
			scrollPaneAfectacion.setBounds(342, 48, 240, 139);
			scrollPaneAfectacion.setViewportView(getTableAfectacion());
		}
		return scrollPaneAfectacion;
	}
	public JTable getTableAfectacion(){
		if(tableAfectacion ==null){
			tableAfectacion = new JTable();
			tableAfectacion.setFillsViewportHeight(true);
			tableAfectacion.setForeground(Color.ORANGE);
			tableAfectacion.setBackground(Color.DARK_GRAY);
			tableAfectacion.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Tipo", "Material Predominante"
					}
					));
		}
		return tableAfectacion ;
	}
	public JScrollPane getScrollPaneMuebles(){
		if(scrollPaneMuebles==null){
			scrollPaneMuebles = new JScrollPane();
			scrollPaneMuebles.setBounds(592, 48, 240, 139);
			scrollPaneMuebles.setViewportView(getTableMuebles());
		}
		return scrollPaneMuebles;
	}
	public JTable getTableMuebles(){
		if(tableMuebles ==null){
			tableMuebles = new JTable();
			tableMuebles.setFillsViewportHeight(true);
			tableMuebles.setForeground(Color.ORANGE);
			tableMuebles.setBackground(Color.DARK_GRAY);
			tableMuebles.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Mueble", "Cantidad"
					}
					));
		}
		return tableMuebles ;
	}
	public JScrollPane getScrollPaneCubicacion(){
		if(scrollPaneCubicacion==null){
			scrollPaneCubicacion= new JScrollPane();
			scrollPaneCubicacion.setBounds(342, 223, 490, 163);
			scrollPaneCubicacion.setViewportView(getTableCubicacion());
		}
		return scrollPaneCubicacion;
	}
	public JTable getTableCubicacion(){
		if(tableCubicacion==null){
			tableCubicacion = new JTable();
			tableCubicacion.setBackground(Color.DARK_GRAY);
			tableCubicacion.setForeground(Color.ORANGE);
			tableCubicacion.setFillsViewportHeight(true);
			tableCubicacion.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Nombre", "u/medida", "Precio unitario", "Cantidad", "Precio Total"
					}
					));
		}
		return tableCubicacion;
	}
	public JLabel getLblPrecioTotal(){
		if( lblPrecioTotal==null){
			lblPrecioTotal= new JLabel("Precio Total:");
			lblPrecioTotal.setBounds(222, 372, 152, 14);
		}
		return lblPrecioTotal;
	}
	public JLabel getLblDimensiones(){
		if( lblDimensiones==null){
			lblDimensiones= new JLabel("Dimensiones:");
			lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
			lblDimensiones.setBounds(222, 46, 110, 14);
		}
		return lblDimensiones;
	}
	public JLabel getLblDatosVivienda(){
		if( lblDatosVivienda==null){
			lblDatosVivienda= new JLabel("Datos de la Vivienda:");
			lblDatosVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosVivienda.setBounds(10, 21, 322, 14);
		}
		return lblDatosVivienda;
	}
	public JLabel getLblHabitantes(){
		if( lblHabitantes==null){
			lblHabitantes= new JLabel("Habitantes:");
			lblHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
			lblHabitantes.setBounds(222, 146, 110, 14);

		}
		return lblHabitantes;
	}
	public JLabel getLblId(){
		if( lblId==null){
			lblId= new JLabel("ID:");
			lblId.setForeground(Color.DARK_GRAY);
			lblId.setBounds(10, 397, 322, 14);

		}
		return lblId;
	}
}
