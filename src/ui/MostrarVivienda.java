package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import clases.Vivienda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarVivienda extends JFrame {
	private static MostrarVivienda mostrarVivienda;
	private Vivienda vivienda;

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

	//Singleton
	public static MostrarVivienda getMostrarVivienda(Vivienda vivienda){
		if(mostrarVivienda==null
			|| !mostrarVivienda.vivienda.equals(vivienda))
			mostrarVivienda=new MostrarVivienda(vivienda);
		return mostrarVivienda;
	}

	//Constructor
	private MostrarVivienda(Vivienda vivienda) {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Formulario de la Vivienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 490);		
		this.vivienda=vivienda;
		setJMenuBar(getBarraSuperior());	
		setContentPane(getContentPane());
		rellenarFormulario();
	}

	//Atributos
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

	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion = new JLabel("Direcci\u00F3n: ");
			lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
			lblDireccion.setBounds(11, 129, 273, 16);
		}
		return lblDireccion;
	}
	public JLabel getLblDocumentoLegal(){ 
		if(lblDocumentoLegal==null){
			lblDocumentoLegal = new JLabel("Documento Legal: ");
			lblDocumentoLegal.setHorizontalAlignment(SwingConstants.LEFT);
			lblDocumentoLegal.setBounds(11, 225, 273, 19);
		}
		return lblDocumentoLegal;
	}
	public JLabel getLblTipologiaHabitacional(){
		if(lblTipologiaHabitacional==null){
			lblTipologiaHabitacional = new JLabel("Tipologia Habitacional: ");
			lblTipologiaHabitacional.setHorizontalAlignment(SwingConstants.LEFT);
			lblTipologiaHabitacional.setBounds(11, 203, 273, 22);
		}
		return lblTipologiaHabitacional;
	}
	public JLabel getLblTipologiaConstructiva(){
		if(lblTipologiaConstructiva==null){
			lblTipologiaConstructiva = new JLabel("Tipolog\u00EDa Constructiva: ");
			lblTipologiaConstructiva.setHorizontalAlignment(SwingConstants.LEFT);
			lblTipologiaConstructiva.setBounds(11, 180, 273, 20);
		}
		return lblTipologiaConstructiva;
	}
	public JLabel getLblFacilidadTemporal(){
		if(lblFacilidadTemporal==null){
			lblFacilidadTemporal = new JLabel("Facilidad Temporal: ");
			lblFacilidadTemporal.setHorizontalAlignment(SwingConstants.LEFT);
			lblFacilidadTemporal.setBounds(11, 156, 273, 23);
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
			lblDimensiones = new JLabel("Dimensiones:");
			lblDimensiones.setHorizontalAlignment(SwingConstants.CENTER);
			lblDimensiones.setBounds(158, 283, 126, 14);
		}
		return lblDimensiones;
	}
	public JLabel getLblLargo(){
		if(lblLargo==null){
			lblLargo = new JLabel("Largo: ");
			lblLargo.setHorizontalAlignment(SwingConstants.LEFT);
			lblLargo.setBounds(181, 308, 103, 20);
		}
		return lblLargo;
	}
	public JLabel getLblAncho(){
		if(lblAncho==null){			
			lblAncho = new JLabel("Ancho: ");
			lblAncho.setHorizontalAlignment(SwingConstants.LEFT);
			lblAncho.setBounds(181, 327, 103, 20);
		}
		return lblAncho;
	}	
	public JLabel getLblAltura(){
		if(lblAltura==null){
			lblAltura = new JLabel("Altura: ");
			lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
			lblAltura.setBounds(181, 350, 103, 20);
		}
		return lblAltura;
	}
	public JLabel getLblNombre(){
		if(lblNombre==null){
			lblNombre = new JLabel("Nombre: ");
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombre.setBounds(11, 44, 273, 14);
		}
		return lblNombre;
	}
	public JLabel getLblCI(){
		if(lblCI==null){
			lblCI = new JLabel("CI: ");
			lblCI.setHorizontalAlignment(SwingConstants.LEFT);
			lblCI.setBounds(11, 69, 273, 14);
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
			lblTotal = new JLabel("Total: ");
			lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
			lblTotal.setBounds(11, 370, 125, 20);
		}
		return lblTotal;
	}
	public JLabel getLblAncianos(){
		if(lblAncianos==null){
			lblAncianos= new JLabel("Ancianos: ");
			lblAncianos.setHorizontalAlignment(SwingConstants.LEFT);
			lblAncianos.setBounds(11, 350, 125, 20);
		}return lblAncianos;
	}
	public JLabel getLblEmbarazadas(){
		if(lblEmbarazadas==null){
			lblEmbarazadas= new JLabel("Embarazadas: ");
			lblEmbarazadas.setHorizontalAlignment(SwingConstants.LEFT);
			lblEmbarazadas.setBounds(10, 327, 126, 20);
		}
		return lblEmbarazadas;
	}
	public JLabel getLblNinos(){
		if(lblNinos==null){
			lblNinos= new JLabel("Ni\u00F1os: ");
			lblNinos.setHorizontalAlignment(SwingConstants.LEFT);
			lblNinos.setBounds(11, 308, 125, 20);
		}
		return lblNinos;
	}
	public JLabel getLblHabitantes(){
		if(lblHabitantes==null){
			lblHabitantes= new JLabel("Habitantes: ");
			lblHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
			lblHabitantes.setBounds(11, 283, 125, 14);
		}
		return lblHabitantes;
	}

	//Metodos
	public void regresar(){
		dispose();
	}
	
	public void rellenarFormulario(){
		getLblDireccion().setText(getLblDireccion().getText()+vivienda.getDireccion());
		getLblDocumentoLegal().setText(getLblDocumentoLegal().getText()+vivienda.getDocumentoLegal());
		getLblTipologiaHabitacional().setText(getLblTipologiaHabitacional().getText()+ vivienda.getTipologiaHabitacional());
		getLblTipologiaConstructiva().setText(getLblTipologiaConstructiva().getText()+ vivienda.getTipologiaConstructiva());
		getLblFacilidadTemporal().setText(getLblFacilidadTemporal().getText()+ (vivienda.getFacilidadTemporal()?"Si":"No"));
		getLblLargo().setText(getLblLargo().getText() +vivienda.getLargo()+" m");
		getLblAncho().setText(getLblAncho().getText() +vivienda.getAncho()+" m");
		getLblAltura().setText(getLblAltura().getText() +vivienda.getAltura()+" m");
		getLblNombre().setText(getLblNombre().getText() +vivienda.getJefeNucleo().getNombre());
		getLblCI().setText(getLblCI().getText() + vivienda.getJefeNucleo().getCI());
		getLblTotal().setText(getLblTotal().getText() + vivienda.getTotalHabitantes());
		getLblAncianos().setText(getLblAncianos().getText() + vivienda.getCantAncianos());
		getLblEmbarazadas().setText(getLblEmbarazadas().getText() +vivienda.getCantEmbarazadas());
		getLblNinos().setText(getLblNinos().getText() +vivienda.getCantNinos());
	}
	

	
	
	
	
}

