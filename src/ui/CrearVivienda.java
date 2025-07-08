package ui;

import javax.swing.SpinnerNumberModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.*;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import clases.MICONS;
import clases.Vivienda;
import clases.JefeNucleo;


public class CrearVivienda extends JFrame {
	private static CrearVivienda crearVivienda;
	private static final long serialVersionUID = 1L;

	private GestionViviendas gestion;
	private MICONS micons;
	private Vivienda vivienda;

	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private final ButtonGroup buttonGroupFacilidadTemporal = new ButtonGroup();

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
	private JLabel lblErrorArea;
	private JLabel lblAltura;
	private JLabel lblDatosJefeNucleo;
	private JLabel lblDatosVivienda;
	private JLabel lblDireccion;
	private JLabel lblErrorDireccion;
	private JLabel lblDocumentoLegal;
	private JLabel lblTipologiaHabitacional;
	private JLabel lblTipologiaConstructiva;
	private JLabel lblNombre;
	private JLabel lblErrorNombre;
	private JLabel lblCI;
	private JLabel lblErrorCI;
	private JLabel lblTotal;
	private JLabel lblAncianos;
	private JLabel lblEmbarazadas;
	private JLabel lblNinios;
	private JLabel lblHabitantes;

	private JSpinner spinnerLargo;
	private JSpinner spinnerAncho;
	private JSpinner spinnerAltura;
	private JSpinner spinnerTotal;
	private JSpinner spinnerAncianos;
	private JSpinner spinnerEmbarazadas;
	private JSpinner spinnerNinios;

	private JButton btnEnviar;

	//Constructor
	public CrearVivienda(GestionViviendas gestion) {
		//FIX: posible error a la hora de rectificar el nombre, eliminado: this.gestionV= gestionV;
		vivienda= new Vivienda();
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Formulario de la Vivienda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 525);
		micons=MICONS.getMICONS();	
		this.gestion=gestion;
		setJMenuBar(getBarraSuperior());	
		setContentPane(getContentPane());
		buttonGroupFacilidadTemporal.add(getRdbtnNo());
		buttonGroupFacilidadTemporal.add(getRdbtnSi());
	}

	//Atributos
	public JPanel getContentPane(){
		if(contentPane==null){		
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getTextFieldDireccion());
			contentPane.add(getLblDireccion());
			contentPane.add(getLblErrorDireccion());
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
			contentPane.add(getLblErrorArea());
			contentPane.add(getLblAltura());
			contentPane.add(getLblNombre());
			contentPane.add(getLblErrorNombre());
			contentPane.add(getTextFieldNombre());
			contentPane.add(getLblCI());
			contentPane.add(getLblErrorCI());
			contentPane.add(getTextFieldCI());
			contentPane.add(getBtnEnviar());
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
			contentPane.add(getSpinnerNinios());
			contentPane.add(getLblAncianos());
			contentPane.add(getLblEmbarazadas());
			contentPane.add(getLblNinios());
			contentPane.add(getLblHabitantes());

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
					regresar();
				}
			});
		}
		return mntmRegresar;
	}
	public JTextField getTextFieldDireccion(){
		if(textFieldDireccion==null){
			textFieldDireccion = new JTextField();
			textFieldDireccion.setColumns(10);
			textFieldDireccion.setBounds(88, 135, 196, 19);
			textFieldDireccion.getDocument().addDocumentListener(new DocumentListener() {
				void validarDirec() {
					try {
						vivienda.setDireccion(textFieldDireccion.getText());
						lblErrorDireccion.setVisible(false);
					} catch (IllegalArgumentException ex) {
						lblErrorDireccion.setText(ex.getMessage());
						lblErrorDireccion.setVisible(true);
					}
				}
				@Override public void insertUpdate(DocumentEvent e) { validarDirec(); }
				@Override public void removeUpdate(DocumentEvent e) { validarDirec(); }
				@Override public void changedUpdate(DocumentEvent e) { validarDirec(); }
			});
		}
		return textFieldDireccion;
	}


	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion = new JLabel("Dirección:");
			lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDireccion.setBounds(11, 137, 67, 16);
		}
		return lblDireccion;
	}
	public JLabel getLblErrorDireccion(){
		if(lblErrorDireccion==null){
			lblErrorDireccion = new JLabel(" ");
			lblErrorDireccion.setForeground(Color.RED);
			lblErrorDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorDireccion.setBounds(11, 120, 293, 15);
			lblErrorDireccion.setVisible(false);
		}
		return lblErrorDireccion;
	}
	public JLabel getLblDocumentoLegal(){ 
		if(lblDocumentoLegal==null){
			lblDocumentoLegal = new JLabel("Documento Legal:");
			lblDocumentoLegal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDocumentoLegal.setBounds(10, 244, 144, 19);
		}
		return lblDocumentoLegal;
	}
	public JLabel getLblTipologiaHabitacional(){
		if(lblTipologiaHabitacional==null){
			lblTipologiaHabitacional = new JLabel("Tipología Habitacional:");
			lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipologiaHabitacional.setBounds(10, 222, 144, 22);
		}
		return lblTipologiaHabitacional;
	}
	public JLabel getLblTipologiaConstructiva(){
		if(lblTipologiaConstructiva==null){
			lblTipologiaConstructiva = new JLabel("Tipología Constructiva:");
			lblTipologiaConstructiva.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipologiaConstructiva.setBounds(10, 199, 144, 20);
		}
		return lblTipologiaConstructiva;
	}
	public JLabel getLblFacilidadTemporal(){
		if(lblFacilidadTemporal==null){
			lblFacilidadTemporal = new JLabel("Facilidad Temporal:");
			lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFacilidadTemporal.setBounds(21, 165, 125, 23);
		}
		return lblFacilidadTemporal;
	}
	public JLabel getLblDatosJefeNucleo(){
		if(lblDatosJefeNucleo==null){

			lblDatosJefeNucleo = new JLabel("Datos del Jefe de Núcleo:");
			lblDatosJefeNucleo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosJefeNucleo.setBounds(11, 11, 273, 14);
		}
		return lblDatosJefeNucleo;
	}
	public JRadioButton getRdbtnSi(){		
		if(rdbtnSi==null){
			rdbtnSi = new JRadioButton("Sí");
			rdbtnSi.setBackground(Color.ORANGE);
			rdbtnSi.setBounds(185, 165, 39, 23);
		}
		return rdbtnSi;

	}
	public JRadioButton getRdbtnNo(){
		if(rdbtnNo==null){
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.setBackground(Color.ORANGE);
			rdbtnNo.setBounds(226, 165, 48, 23);
		}
		return rdbtnNo;
	}
	public JLabel getLblDimensiones(){
		if(lblDimensiones==null){
			lblDimensiones = new JLabel("Dimensiones (m):");
			lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
			lblDimensiones.setBounds(148, 274, 136, 14);
		}
		return lblDimensiones;
	}
	public JLabel getLblLargo(){
		if(lblLargo==null){
			lblLargo = new JLabel("Largo:");
			lblLargo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLargo.setBounds(175, 299, 39, 20);
		}
		return lblLargo;
	}
	public JLabel getLblAncho(){
		if(lblAncho==null){			
			lblAncho = new JLabel("Ancho:");
			lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAncho.setBounds(175, 331, 39, 20);
		}
		return lblAncho;
	}	
	public JLabel getLblErrorArea(){
		if(lblErrorArea==null){
			lblErrorArea = new JLabel(" ");
			lblErrorArea.setForeground(Color.RED);
			lblErrorArea.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorArea.setBounds(158, 397, 146, 30);
		}
		return lblErrorArea;
	}
	public JLabel getLblAltura(){
		if(lblAltura==null){
			lblAltura = new JLabel("Altura:");
			lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAltura.setBounds(175, 366, 39, 20);
		}
		return lblAltura;
	}
	public JLabel getLblNombre(){
		if(lblNombre==null){
			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setBounds(11, 47, 67, 14);
		}
		return lblNombre;
	}
	public JLabel getLblErrorNombre(){
		if(lblErrorNombre==null){
			lblErrorNombre = new JLabel(" ");
			lblErrorNombre.setForeground(Color.RED);
			lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorNombre.setBounds(11, 25, 293, 15);
			lblErrorNombre.setVisible(false);
		}
		return lblErrorNombre;
	}
	public JTextField getTextFieldNombre(){
		if(textFieldNombre==null){
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(88, 42, 196, 20);
			textFieldNombre.setColumns(10);
			textFieldNombre.getDocument().addDocumentListener(new DocumentListener() {
				void validarNombre() {
					try {			
						vivienda.getJefeNucleo().setNombre(getTextFieldNombre().getText());
						getLblErrorNombre().setVisible(false);
					} catch (IllegalArgumentException ex) {
						getLblErrorNombre().setText(ex.getMessage());
						getLblErrorNombre().setVisible(true);
					}
				}
				@Override public void insertUpdate(DocumentEvent e) { validarNombre(); }
				@Override public void removeUpdate(DocumentEvent e) { validarNombre(); }
				@Override public void changedUpdate(DocumentEvent e) { validarNombre(); }
			});
		}
		return textFieldNombre;
	}


	public JLabel getLblCI(){
		if(lblCI==null){
			lblCI = new JLabel("CI:");
			lblCI.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCI.setBounds(11, 82, 67, 14);
		}
		return lblCI;
	}
	public JLabel getLblErrorCI(){
		if(lblErrorCI==null){
			lblErrorCI = new JLabel(" ");
			lblErrorCI.setForeground(Color.RED);
			lblErrorCI.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorCI.setBounds(10, 61, 294, 15);
			lblErrorCI.setVisible(false);
		}
		return lblErrorCI;
	}
	public JTextField getTextFieldCI(){
		if(textFieldCI==null){
			textFieldCI = new JTextField();
			textFieldCI.setBounds(88, 79, 196, 20);
			textFieldCI.setColumns(10);
			textFieldCI.getDocument().addDocumentListener(new DocumentListener() {
				void validarCI() {
					try {
						vivienda.getJefeNucleo().setCI(textFieldCI.getText());
						lblErrorCI.setVisible(false);
					} catch (IllegalArgumentException ex) {
						lblErrorCI.setText(ex.getMessage());
						lblErrorCI.setVisible(true);
					}
				}
				@Override public void insertUpdate(DocumentEvent e) { validarCI(); }
				@Override public void removeUpdate(DocumentEvent e) { validarCI(); }
				@Override public void changedUpdate(DocumentEvent e) { validarCI(); }
			});
		}
		return textFieldCI;
	}


	public JButton getBtnEnviar(){
		if(btnEnviar==null){
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBackground(Color.DARK_GRAY);
			btnEnviar.setForeground(Color.ORANGE);
			btnEnviar.setBounds(195, 438, 89, 23);
			btnEnviar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addVivienda();
				}
			});

		}
		return btnEnviar;
	}
	public JComboBox getComboBoxDocumentoLegal(){
		if(comboBoxDocumentoLegal==null){
			comboBoxDocumentoLegal = new JComboBox(documentoLegal);
			comboBoxDocumentoLegal.setBounds(175, 243, 95, 20);
		}
		return comboBoxDocumentoLegal;
	}
	public JComboBox getComboBoxTipologiaHabitacional(){
		if(comboBoxTipologiaHabitacional==null){
			comboBoxTipologiaHabitacional = new JComboBox(tipologiaHabitacional);
			comboBoxTipologiaHabitacional.setBounds(175, 223, 95, 20);
		}
		return comboBoxTipologiaHabitacional;
	}
	public JComboBox getComboBoxTipologiaConstructiva(){
		if(comboBoxTipologiaConstructiva==null){
			comboBoxTipologiaConstructiva = new JComboBox(tipologiaConstructiva);
			comboBoxTipologiaConstructiva.setBounds(175, 203, 95, 20);
		}
		return comboBoxTipologiaConstructiva;
	}
	public JSpinner getSpinnerLargo(){
		if(spinnerLargo==null){
			SpinnerNumberModel largo= new SpinnerNumberModel(3.0,3.0,Double.MAX_VALUE,1.0);
			spinnerLargo = new JSpinner(largo);
			spinnerLargo.setBounds(242, 299, 41, 20);
			spinnerLargo.addChangeListener(validarArea);
		}
		return spinnerLargo;
	}
	public JSpinner getSpinnerAncho(){
		if(spinnerAncho==null){
			SpinnerNumberModel ancho= new SpinnerNumberModel(3.0,3.0,Double.MAX_VALUE,1.0);
			spinnerAncho  = new JSpinner(ancho);
			spinnerAncho.setBounds(242, 331, 41, 20);
			spinnerAncho.addChangeListener(validarArea);
		}
		return spinnerAncho;
	}
	// Validar ancho y largo 
	ChangeListener validarArea = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			//.doubleValue() Arregla el eor que daba al castear el valo del spinner 
			double ancho = ((Number) spinnerAncho.getValue()).doubleValue();
			double largo = ((Number) spinnerLargo.getValue()).doubleValue();

			double area = ancho * largo;

			if (area > 50) {
				lblErrorArea.setText("El área (ancho x largo) no puede superar 50 (actual: " + area + ")");
				lblErrorArea.setVisible(true);
			} else {
				lblErrorArea.setVisible(false);
			}
		}
	};


	public JSpinner getSpinnerAltura(){
		if(spinnerAltura==null){
			SpinnerNumberModel altura= new SpinnerNumberModel(2.0,2.0,3.0,0.2);
			spinnerAltura= new JSpinner(altura);
			spinnerAltura.setBounds(243, 365, 41, 20);
		}
		return spinnerAltura;
	}
	public JLabel getLblDatosVivienda(){
		if(lblDatosVivienda==null){
			lblDatosVivienda = new JLabel("Datos de la Vivienda:");
			lblDatosVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosVivienda.setBounds(11, 107, 274, 15);
		}
		return lblDatosVivienda;
	}
	public JLabel getLblTotal(){
		if(lblTotal==null){
			lblTotal = new JLabel("Total:");
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotal.setBounds(16, 395, 67, 14);
		}
		return lblTotal;
	}
	public JSpinner getSpinnerTotal(){
		if(spinnerTotal==null){	
			SpinnerNumberModel total= new SpinnerNumberModel(0,0,40,1);
			spinnerTotal= new JSpinner(total);
			spinnerTotal.setBounds(103, 393, 41, 20);
		}
		return spinnerTotal;
	}
	public JSpinner getSpinnerAncianos(){
		if(spinnerAncianos==null){	
			SpinnerNumberModel ancianos= new SpinnerNumberModel(0,0,10,1);
			spinnerAncianos= new JSpinner(ancianos);
			spinnerAncianos.setBounds(103, 362, 41, 20);
		}
		return spinnerAncianos;
	}
	public JSpinner getSpinnerEmbarazadas(){
		if(spinnerEmbarazadas==null){	
			SpinnerNumberModel embarazadas= new SpinnerNumberModel(0,0,10,1);
			spinnerEmbarazadas= new JSpinner(embarazadas);
			spinnerEmbarazadas.setBounds(103, 331, 41, 20);
		}
		return spinnerEmbarazadas;
	}
	public JSpinner getSpinnerNinios(){
		if(spinnerNinios==null){	
			SpinnerNumberModel ninios= new SpinnerNumberModel(0,0,10,1);
			spinnerNinios= new JSpinner(ninios);
			spinnerNinios.setBounds(103, 300, 41, 20);
		}
		return spinnerNinios;
	}
	public JLabel getLblAncianos(){
		if(lblAncianos==null){
			lblAncianos= new JLabel("Ancianos:");
			lblAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAncianos.setBounds(6, 362, 75, 20);
		}return lblAncianos;
	}
	public JLabel getLblEmbarazadas(){
		if(lblEmbarazadas==null){
			lblEmbarazadas= new JLabel("Embarazadas:");
			lblEmbarazadas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmbarazadas.setBounds(-11, 331, 94, 20);
		}
		return lblEmbarazadas;
	}
	public JLabel getLblNinios(){
		if(lblNinios==null){
			lblNinios= new JLabel("Ninios:");
			lblNinios.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNinios.setBounds(6, 300, 75, 20);
		}
		return lblNinios;
	}
	public JLabel getLblHabitantes(){
		if(lblHabitantes==null){
			lblHabitantes= new JLabel("Habitantes:");
			lblHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
			lblHabitantes.setBounds(19, 261, 125, 14);
		}
		return lblNinios;
	}
	//Metodos
	private void limpiarCampos() {

		getTextFieldNombre().setText("");
		getTextFieldCI().setText("");
		getTextFieldDireccion().setText("");

		getComboBoxDocumentoLegal().setSelectedIndex(0);
		getComboBoxTipologiaHabitacional().setSelectedIndex(0);
		getComboBoxTipologiaConstructiva().setSelectedIndex(0);

		getRdbtnSi().setSelected(false);
		getRdbtnNo().setSelected(false);

		getSpinnerLargo().setValue(1);
		getSpinnerAncho().setValue(1);
		getSpinnerAltura().setValue(1);
		getSpinnerTotal().setValue(1);
		getSpinnerAncianos().setValue(0);
		getSpinnerEmbarazadas().setValue(0);
		getSpinnerNinios().setValue(0);
	}
	public void addVivienda(){
		try {
			// Validar campos de texto no vacÃ­os
			if (getTextFieldNombre().getText().trim().isEmpty()) {
				throw new IllegalArgumentException("Debe ingresar el nombre del jefe de núcleo.");
			}
			if (getTextFieldCI().getText().trim().isEmpty()) {
				throw new IllegalArgumentException("Debe ingresar el carnet de identidad.");
			}
			if (getTextFieldDireccion().getText().trim().isEmpty()) {
				throw new IllegalArgumentException("Debe ingresar la dirección.");
			}

			// Validar que se haya seleccionado un RadioButton (Facilidad Temporal)
			if (!getRdbtnSi().isSelected() && !getRdbtnNo().isSelected()) {
				throw new IllegalArgumentException("Debe seleccionar una opción para Facilidad Temporal.");
			}
			Boolean facilidadTemporal = getRdbtnSi().isSelected();

			// Validar ComboBoxes (que tengan selección)
			if (getComboBoxTipologiaConstructiva().getSelectedIndex() == -1) {
				throw new IllegalArgumentException("Debe seleccionar un tipo de construcción.");
			}
			if (getComboBoxTipologiaHabitacional().getSelectedIndex() == -1) {
				throw new IllegalArgumentException("Debe seleccionar un tipo habitacional.");
			}
			if (getComboBoxDocumentoLegal().getSelectedIndex() == -1) {
				throw new IllegalArgumentException("Debe seleccionar un documento legal.");
			}

			// Validar spinners con commitEdit para aplicar valor y lanzar excepción si inválido
			getSpinnerNinios().commitEdit();
			getSpinnerAncianos().commitEdit();
			getSpinnerEmbarazadas().commitEdit();
			getSpinnerTotal().commitEdit();
			getSpinnerAltura().commitEdit();
			getSpinnerAncho().commitEdit();
			getSpinnerLargo().commitEdit();

			// Obtener valores de spinners
			int cantidadNinios = (Integer) getSpinnerNinios().getValue();
			int cantidadAncianos = (Integer) getSpinnerAncianos().getValue();
			int cantidadEmbarazadas = (Integer) getSpinnerEmbarazadas().getValue();
			int totalPersonas = (Integer) getSpinnerTotal().getValue();
			//puse .doubleValue() para eliminar los errores a la hora de castear los valores de los spinners
			double altura = ((Number) getSpinnerAltura().getValue()).doubleValue();
			double ancho = ((Number) getSpinnerAncho().getValue()).doubleValue();
			double largo = ((Number) getSpinnerLargo().getValue()).doubleValue();

			// Validar área máxima
			double area = ancho * largo;
			if (area > 50) {
				throw new IllegalArgumentException("El área (ancho x largo) no puede superar 50. área actual: " + area);
			}

			// Si todo está bien, asignar valores a la instancia vivienda
			vivienda.getJefeNucleo().setNombre(getTextFieldNombre().getText().trim());
			vivienda.getJefeNucleo().setCI(getTextFieldCI().getText().trim());
			vivienda.setDireccion(getTextFieldDireccion().getText().trim());
			vivienda.setFacilidadTemporal(facilidadTemporal);
			vivienda.setTipologiaConstructiva((String) getComboBoxTipologiaConstructiva().getSelectedItem());
			vivienda.setTipologiaHabitacional((String) getComboBoxTipologiaHabitacional().getSelectedItem());
			vivienda.setDocumentoLegal((String) getComboBoxDocumentoLegal().getSelectedItem());
			vivienda.setCantNinios(cantidadNinios);
			vivienda.setCantAncianos(cantidadAncianos);
			vivienda.setCantEmbarazadas(cantidadEmbarazadas);
			vivienda.setTotalHabitantes(totalPersonas);
			vivienda.setAltura(altura);
			vivienda.setAncho(ancho);
			vivienda.setLargo(largo);

			// Agregar vivienda a la lista
			if(micons.addVivienda(vivienda)){						
				JOptionPane.showMessageDialog(crearVivienda, "Vivienda guardada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);							
				gestion.actualizarTableViviendas();	//actualizar lista viviendas
				limpiarCampos();				
			}
			else JOptionPane.showMessageDialog(crearVivienda, "Error al guardar la vivienda.", "Error", JOptionPane.ERROR_MESSAGE);							

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(crearVivienda, "Error en los valores numéricos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(crearVivienda, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(crearVivienda, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void regresar(){
		limpiarCampos();
		dispose();
	}
}







