package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import clases.MICONS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MostrarVivienda extends JFrame {

	private MICONS micons;

	private JPanel contentPane;

	private JMenuBar barraSuperior;

	private JMenuItem mntmRegresar;

	private final ButtonGroup buttonGroupFacilidadTemporal = new ButtonGroup();

	private String[] tipologiaConstructiva={"Tipo I","Tipo II","Tipo III","Tipo IV","Tipo V"};
	private String[] tipologiaHabitacional={"Casa","Apartamento","Bohío","Otro"};
	private String[] documentoLegal={"Propiedad","Usufructo","Vivienda vinculada","Arrendamiento","Providencia","No posee"};

	private JLabel lblFacilidadTemporal;
	private JLabel lblDimensiones;
	private JLabel lblLargo;
	private JLabel lblAncho;
	private JLabel lblAltura;
	private JLabel lblDatosJefeNucleo;
	private JLabel lblDatosVivienda;
	private JLabel lblDireccion;
	private JLabel lblDocumentoLegal;
	private JLabel lblTipologiaHabitacional;
	private JLabel lblTipologiaConstructiva;
	private JLabel lblNombre;
	private JLabel lblCI;
	private JLabel lblTotal;
	private JLabel lblAncianos;
	private JLabel lblEmbarazadas;
	private JLabel lblNinos;
	private JLabel lblHabitantes;
	private JLabel lblId;
	private JLabel lblHabitantes_1;

	public MostrarVivienda() {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Formulario de la Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 490);
		micons=MICONS.getMICONS();	
		setJMenuBar(getBarraSuperior());	
		setContentPane(getContentPane());
	}
	public JPanel getContentPane(){
		if(contentPane==null){		
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getLblDireccion());
			contentPane.add(getLblDocumentoLegal());
			contentPane.add(getLblTipologiaHabitacional());
			contentPane.add(getLblTipologiaConstructiva());
			contentPane.add(getLblFacilidadTemporal());
			contentPane.add(getLblDatosJefeNucleo());
			contentPane.add(getLblDimensiones());
			contentPane.add(getLblLargo());
			contentPane.add(getLblAncho());
			contentPane.add(getLblAltura());
			contentPane.add(getLblNombre());
			contentPane.add(getLblCI());
			contentPane.add(getLblDatosVivienda());	
			contentPane.add(getLblTotal());
			contentPane.add(getLblAncianos());
			contentPane.add(getLblEmbarazadas());
			contentPane.add(getLblNinos());
			contentPane.add(getLblHabitantes());
			contentPane.add(getLblId());
			contentPane.add(getLblHabitantes_1());


		}
		return contentPane;
	}

	public JMenuBar getBarraSuperior(){ 
		if(barraSuperior==null){
			barraSuperior = new JMenuBar();
			barraSuperior.add(getMntmRegresar());
		}
		return barraSuperior;
	}
	public JMenuItem getMntmRegresar(){
		if(mntmRegresar==null){
			mntmRegresar = new JMenuItem("Regresar");
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDireccion.setBounds(11, 129, 67, 16);
		}
		return lblDireccion;
	}
	public JLabel getLblDocumentoLegal(){ 
		if(lblDocumentoLegal==null){
			lblDocumentoLegal = new JLabel("Documento Legal:");
			lblDocumentoLegal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDocumentoLegal.setBounds(0, 236, 144, 19);
		}
		return lblDocumentoLegal;
	}
	public JLabel getLblTipologiaHabitacional(){
		if(lblTipologiaHabitacional==null){
			lblTipologiaHabitacional = new JLabel("Tipologia Habitacional:");
			lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipologiaHabitacional.setBounds(0, 214, 144, 22);
		}
		return lblTipologiaHabitacional;
	}
	public JLabel getLblTipologiaConstructiva(){
		if(lblTipologiaConstructiva==null){
			lblTipologiaConstructiva = new JLabel("Tipolog\u00EDa Constructiva:");
			lblTipologiaConstructiva.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipologiaConstructiva.setBounds(0, 191, 144, 20);
		}
		return lblTipologiaConstructiva;
	}
	public JLabel getLblFacilidadTemporal(){
		if(lblFacilidadTemporal==null){
			lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
			lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFacilidadTemporal.setBounds(11, 157, 125, 23);
		}
		return lblFacilidadTemporal;
	}
	public JLabel getLblDatosJefeNucleo(){
		if(lblDatosJefeNucleo==null){

			lblDatosJefeNucleo = new JLabel("Datos del Jefe de N\u00FAcleo:");
			lblDatosJefeNucleo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosJefeNucleo.setBounds(11, 21, 273, 14);
		}
		return lblDatosJefeNucleo;
	}
	public JLabel getLblDimensiones(){
		if(lblDimensiones==null){
			lblDimensiones = new JLabel("Dimensiones (m):");
			lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
			lblDimensiones.setBounds(158, 283, 126, 14);
		}
		return lblDimensiones;
	}
	public JLabel getLblLargo(){
		if(lblLargo==null){
			lblLargo = new JLabel("Largo:");
			lblLargo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLargo.setBounds(194, 308, 39, 20);
		}
		return lblLargo;
	}
	public JLabel getLblAncho(){
		if(lblAncho==null){			
			lblAncho = new JLabel("Ancho:");
			lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAncho.setBounds(194, 327, 39, 20);
		}
		return lblAncho;
	}	
	public JLabel getLblAltura(){
		if(lblAltura==null){
			lblAltura = new JLabel("Altura:");
			lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAltura.setBounds(194, 350, 39, 20);
		}
		return lblAltura;
	}
	public JLabel getLblNombre(){
		if(lblNombre==null){
			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setBounds(11, 44, 67, 14);
		}
		return lblNombre;
	}
	public JLabel getLblCI(){
		if(lblCI==null){
			lblCI = new JLabel("CI:");
			lblCI.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCI.setBounds(11, 69, 67, 14);
		}
		return lblCI;
	}
	public JLabel getLblDatosVivienda(){
		if(lblDatosVivienda==null){
			lblDatosVivienda = new JLabel("Datos de la Vivienda:");
			lblDatosVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosVivienda.setBounds(10, 101, 274, 17);
		}
		return lblDatosVivienda;
	}
	public JLabel getLblTotal(){
		if(lblTotal==null){
			lblTotal = new JLabel("Total:");
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotal.setBounds(40, 381, 67, 20);
		}
		return lblTotal;
	}
	public JLabel getLblAncianos(){
		if(lblAncianos==null){
			lblAncianos= new JLabel("Ancianos:");
			lblAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAncianos.setBounds(30, 350, 75, 20);
		}return lblAncianos;
	}
	public JLabel getLblEmbarazadas(){
		if(lblEmbarazadas==null){
			lblEmbarazadas= new JLabel("Embarazadas:");
			lblEmbarazadas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmbarazadas.setBounds(10, 327, 94, 20);
		}
		return lblEmbarazadas;
	}
	public JLabel getLblNinos(){
		if(lblNinos==null){
			lblNinos= new JLabel("Ni\u00F1os:");
			lblNinos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNinos.setBounds(28, 308, 75, 20);
		}
		return lblNinos;
	}
	public JLabel getLblHabitantes(){
		if(lblHabitantes==null){
			lblHabitantes= new JLabel("Habitantes:");
			lblHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
			lblHabitantes.setBounds(19, 261, 125, 14);
		}
		return lblNinos;
	}
	public JLabel getLblId(){
		if(lblId==null){
			lblId = new JLabel("ID:");
			lblId.setBounds(11, 412, 169, 14);
		}
		return lblId;
	}

	private JLabel getLblHabitantes_1() {
		if (lblHabitantes_1 == null) {
			lblHabitantes_1 = new JLabel("Habitantes:");
			lblHabitantes_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblHabitantes_1.setBounds(21, 283, 133, 14);
		}
		return lblHabitantes_1;
	}
}

