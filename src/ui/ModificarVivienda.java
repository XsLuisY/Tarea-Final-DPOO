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


public class ModificarVivienda extends JFrame {
	private MICONS micons;
	private JPanel contentPane;

	private JMenuBar barraSuperior;
	
	private JMenuItem mntmRegresar;
	
	private final ButtonGroup buttonGroupFacilidadTemporal = new ButtonGroup();
	
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;

	private JTextField textFieldDireccion;
	private JTextField textFieldNombre;
	private JTextField textFieldCI;
	
	private String[] tipologiaConstructiva={"Tipo I","Tipo II","Tipo III","Tipo IV","Tipo V"};
	private String[] tipologiaHabitacional={"Casa","Apartamento","Bohío","Otro"};
	private String[] documentoLegal={"Propiedad","Usufructo","Vivienda vinculada","Arrendamiento","Providencia","No posee"};

	private JComboBox comboBoxTipologiaHabitacional;
	private JComboBox comboBoxTipologiaConstructiva;
	private JComboBox comboBoxDocumentoLegal;

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
	
	private JButton btnModificar;
	
	private JSpinner spinnerLargo;
	private JSpinner spinnerAncho;
	private JSpinner spinnerAltura;
	private JSpinner spinnerTotal;
	private JSpinner spinnerAncianos;
	private JSpinner spinnerEmbarazadas;
	private JSpinner spinnerNinos;


	public ModificarVivienda( ) {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Modificar Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 490);
		micons=MICONS.getMICONS();	
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());	
		buttonGroupFacilidadTemporal.add(getRdbtnNo());
		buttonGroupFacilidadTemporal.add(getRdbtnSi());
	}

	public JPanel getContentPane(){
		if(contentPane==null){		
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getTextFieldDireccion());
			contentPane.add(getLblDireccion());
			contentPane.add(getLblDocumentoLegal());
			contentPane.add(getLblTipologiaHabitacional());
			contentPane.add(getLblTipologiaConstructiva());
			contentPane.add(getLblFacilidadTemporal());
			contentPane.add(getLblDatosJefeNucleo());
			contentPane.add(getRdbtnSi());
			contentPane.add(getRdbtnNo());
			contentPane.add(getLblDimensiones());
			contentPane.add(getLblLargo());
			contentPane.add(getLblAncho());
			contentPane.add(getLblAltura());
			contentPane.add(getLblNombre());
			contentPane.add(getTextFieldNombre());
			contentPane.add(getLblCI());
			contentPane.add(getTextFieldCI());
			contentPane.add(getBtnModificar());
			contentPane.add(getComboBoxDocumentoLegal());
			contentPane.add(getComboBoxTipologiaHabitacional());
			contentPane.add(getComboBoxTipologiaConstructiva());
			contentPane.add(getSpinnerLargo());
			contentPane.add(getSpinnerAncho());
			contentPane.add(getSpinnerAltura());
			contentPane.add(getLblDatosVivienda());	
			contentPane.add(getLblTotal());
			contentPane.add(getSpinnerTotal());
			contentPane.add(getSpinnerAncianos());
			contentPane.add(getSpinnerEmbarazadas());
			contentPane.add(getSpinnerNinos());
			contentPane.add(getLblAncianos());
			contentPane.add(getLblEmbarazadas());
			contentPane.add(getLblNinos());
			contentPane.add(getLblHabitantes());
			contentPane.add(getLblId());

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
	public JTextField getTextFieldDireccion(){
		if(textFieldDireccion==null){
			textFieldDireccion = new JTextField();
			textFieldDireccion.setColumns(10);
			textFieldDireccion.setBounds(88, 112, 196, 19);
		}
		return textFieldDireccion;
	}
	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDireccion.setBounds(11, 114, 67, 16);
		}
		return lblDireccion;
	}
	public JLabel getLblDocumentoLegal(){ 
		if(lblDocumentoLegal==null){
			lblDocumentoLegal = new JLabel("Documento Legal:");
			lblDocumentoLegal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDocumentoLegal.setBounds(0, 221, 144, 19);
		}
		return lblDocumentoLegal;
	}
	public JLabel getLblTipologiaHabitacional(){
		if(lblTipologiaHabitacional==null){
			lblTipologiaHabitacional = new JLabel("Tipologia Habitacional:");
			lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipologiaHabitacional.setBounds(0, 199, 144, 22);
		}
		return lblTipologiaHabitacional;
	}
	public JLabel getLblTipologiaConstructiva(){
		if(lblTipologiaConstructiva==null){
			lblTipologiaConstructiva = new JLabel("Tipolog\u00EDa Constructiva:");
			lblTipologiaConstructiva.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipologiaConstructiva.setBounds(0, 176, 144, 20);
		}
		return lblTipologiaConstructiva;
	}
	public JLabel getLblFacilidadTemporal(){
		if(lblFacilidadTemporal==null){
			lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
			lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFacilidadTemporal.setBounds(11, 142, 125, 23);
		}
		return lblFacilidadTemporal;
	}
	public JLabel getLblDatosJefeNucleo(){
		if(lblDatosJefeNucleo==null){

			lblDatosJefeNucleo = new JLabel("Datos del Jefe de N\u00FAcleo:");
			lblDatosJefeNucleo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosJefeNucleo.setBounds(11, 11, 273, 14);
		}
		return lblDatosJefeNucleo;
	}
	public JRadioButton getRdbtnSi(){		
		if(rdbtnSi==null){
			rdbtnSi = new JRadioButton("S\u00ED");
			rdbtnSi.setBackground(Color.ORANGE);
			rdbtnSi.setBounds(175, 142, 39, 23);
		}
		return rdbtnSi;

	}
	public JRadioButton getRdbtnNo(){
		if(rdbtnNo==null){
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.setBackground(Color.ORANGE);
			rdbtnNo.setBounds(216, 142, 48, 23);
		}
		return rdbtnNo;
	}
	public JLabel getLblDimensiones(){
		if(lblDimensiones==null){
			lblDimensiones = new JLabel("Dimensiones (m):");
			lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
			lblDimensiones.setBounds(148, 261, 136, 14);
		}
		return lblDimensiones;
	}
	public JLabel getLblLargo(){
		if(lblLargo==null){
			lblLargo = new JLabel("Largo:");
			lblLargo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLargo.setBounds(175, 286, 39, 20);
		}
		return lblLargo;
	}
	public JLabel getLblAncho(){
		if(lblAncho==null){			
			lblAncho = new JLabel("Ancho:");
			lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAncho.setBounds(175, 318, 39, 20);
		}
		return lblAncho;
	}	
	public JLabel getLblAltura(){
		if(lblAltura==null){
			lblAltura = new JLabel("Altura:");
			lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAltura.setBounds(175, 353, 39, 20);
		}
		return lblAltura;
	}
	public JLabel getLblNombre(){
		if(lblNombre==null){
			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setBounds(11, 34, 67, 14);
		}
		return lblNombre;
	}
	public JTextField getTextFieldNombre(){
		if(textFieldNombre==null){
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(88, 31, 196, 20);
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	public JLabel getLblCI(){
		if(lblCI==null){
			lblCI = new JLabel("CI:");
			lblCI.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCI.setBounds(11, 59, 67, 14);
		}
		return lblCI;
	}
	public JTextField getTextFieldCI(){
		if(textFieldCI==null){
			textFieldCI = new JTextField();
			textFieldCI.setHorizontalAlignment(SwingConstants.RIGHT);
			textFieldCI.setBounds(88, 56, 196, 20);
			textFieldCI.setColumns(10);
		}
		return textFieldCI;
	}
	public JButton getBtnModificar(){
		if(btnModificar==null){
			btnModificar = new JButton("Modificar");
			btnModificar.setBackground(Color.DARK_GRAY);
			btnModificar.setForeground(Color.ORANGE);
			btnModificar.setBounds(195, 403, 89, 23);
		}
		return btnModificar;
	}
	public JComboBox getComboBoxDocumentoLegal(){
		if(comboBoxDocumentoLegal==null){
			comboBoxDocumentoLegal = new JComboBox(documentoLegal);
			comboBoxDocumentoLegal.setBounds(165, 220, 95, 20);
		}
		return comboBoxDocumentoLegal;
	}
	public JComboBox getComboBoxTipologiaHabitacional(){
		if(comboBoxTipologiaHabitacional==null){
			comboBoxTipologiaHabitacional = new JComboBox(tipologiaHabitacional);
			comboBoxTipologiaHabitacional.setBounds(165, 200, 95, 20);
		}
		return comboBoxTipologiaHabitacional;
	}
	public JComboBox getComboBoxTipologiaConstructiva(){
		if(comboBoxTipologiaConstructiva==null){
			comboBoxTipologiaConstructiva = new JComboBox(tipologiaConstructiva);
			comboBoxTipologiaConstructiva.setBounds(165, 180, 95, 20);
		}
		return comboBoxTipologiaConstructiva;
	}
	public JSpinner getSpinnerLargo(){
		if(spinnerLargo==null){
			spinnerLargo = new JSpinner();
			spinnerLargo.setBounds(242, 286, 41, 20);
		}
		return spinnerLargo;
	}
	public JSpinner getSpinnerAncho(){
		if(spinnerAncho==null){
			spinnerAncho  = new JSpinner();
			spinnerAncho.setBounds(242, 318, 41, 20);
		}
		return spinnerAncho;
	}
	public JSpinner getSpinnerAltura(){
		if(spinnerAltura==null){
			spinnerAltura= new JSpinner();
			spinnerAltura.setBounds(243, 352, 41, 20);
		}
		return spinnerAltura;
	}
	public JLabel getLblDatosVivienda(){
		if(lblDatosVivienda==null){
			lblDatosVivienda = new JLabel("Datos de la Vivienda:");
			lblDatosVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosVivienda.setBounds(10, 86, 274, 17);
		}
		return lblDatosVivienda;
	}
	public JLabel getLblTotal(){
		if(lblTotal==null){
			lblTotal = new JLabel("Total:");
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotal.setBounds(16, 382, 67, 14);
		}
		return lblTotal;
	}
	public JSpinner getSpinnerTotal(){
		if(spinnerTotal==null){	
			spinnerTotal= new JSpinner();
			spinnerTotal.setBounds(103, 380, 41, 20);
		}
		return spinnerTotal;
	}
	public JSpinner getSpinnerAncianos(){
		if(spinnerAncianos==null){	
			spinnerAncianos= new JSpinner();
			spinnerAncianos.setBounds(103, 349, 41, 20);
		}
		return spinnerAncianos;
	}
	public JSpinner getSpinnerEmbarazadas(){
		if(spinnerEmbarazadas==null){	
			spinnerEmbarazadas= new JSpinner();
			spinnerEmbarazadas.setBounds(103, 318, 41, 20);
		}
		return spinnerEmbarazadas;
	}
	public JSpinner getSpinnerNinos(){
		if(spinnerNinos==null){	
			spinnerNinos= new JSpinner();
			spinnerNinos.setBounds(103, 287, 41, 20);
		}
		return spinnerNinos;
	}
	public JLabel getLblAncianos(){
		if(lblAncianos==null){
			lblAncianos= new JLabel("Ancianos:");
			lblAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAncianos.setBounds(6, 349, 75, 20);
		}return lblAncianos;
	}
	public JLabel getLblEmbarazadas(){
		if(lblEmbarazadas==null){
			lblEmbarazadas= new JLabel("Embarazadas:");
			lblEmbarazadas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmbarazadas.setBounds(-11, 318, 94, 20);
		}
		return lblEmbarazadas;
	}
	public JLabel getLblNinos(){
		if(lblNinos==null){
			lblNinos= new JLabel("Ni\u00F1os:");
			lblNinos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNinos.setBounds(6, 287, 75, 20);
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
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID:");
			lblId.setHorizontalAlignment(SwingConstants.CENTER);
			lblId.setBounds(11, 412, 203, 14);
		}
		return lblId;
	}
}

