package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import clases.Afectacion;
import clases.AfectacionPared;
import clases.AfectacionTecho;
import clases.FichaTecnicaDO;
import clases.MICONS;
import clases.Mueble;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MostrarFichaTecnicaDO extends JFrame {
	private static MostrarFichaTecnicaDO mostrarFichaTecnicaDO;
	private FichaTecnicaDO ficha;

	private JPanel contentPane;
	private JTable tableMuebles;
	private JTable tableAfectaciones;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JScrollPane scrollPaneAfectaciones;
	private JScrollPane scrollPaneMuebles;
	private JLabel lblAfectacionInmueble; 
	private JLabel lblAfectacinVivienda; 
	private JLabel lblFechaLevantamiento;
	private JLabel lblId;
	private JLabel lblDatosVivienda; 
	private JLabel lblJefeNucleo;
	private JLabel lblDireccion;

	//Singleton
	public static MostrarFichaTecnicaDO getMostrarFichaTecnicaDO(FichaTecnicaDO ficha){
		if(mostrarFichaTecnicaDO==null)
			mostrarFichaTecnicaDO=new MostrarFichaTecnicaDO(ficha);
		return mostrarFichaTecnicaDO;
	}

	//Constructor
	public MostrarFichaTecnicaDO(FichaTecnicaDO ficha) {
		this.ficha=ficha;
		setType(Type.UTILITY);
		setTitle("Ficha T\u00E9cnica de Da\u00F1os Ocacionados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 550);
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
		actualizarTableAfectaciones(ficha.getAfectaciones());
		actualizarTableMuebles(ficha.getMuebles());
	}

	//Atributos
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getScrollPaneAfectaciones());
			contentPane.add(getScrollPaneMuebles());
			contentPane.add(getLblAfectacionInmueble());
			contentPane.add(getLblAfectacinVivienda());
			contentPane.add(getLblFechaLevantamiento());
			contentPane.add(getLblId());
			contentPane.add(getLblDatosVivienda());
			contentPane.add(getLblDireccion());
			contentPane.add(getLblJefeNucleo());
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
			mntmRegresar= new JMenuItem("Regresar");
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JScrollPane getScrollPaneAfectaciones(){
		if(scrollPaneAfectaciones==null){
			scrollPaneAfectaciones = new JScrollPane();
			scrollPaneAfectaciones.setBounds(10, 106, 282, 139);
			scrollPaneAfectaciones.setViewportView(getTableAfectaciones());
		}
		return scrollPaneAfectaciones;
	}
	public JTable getTableAfectaciones(){
		if(tableAfectaciones==null){
			tableAfectaciones = new JTable();
			tableAfectaciones.setFillsViewportHeight(true);
			tableAfectaciones.setForeground(Color.ORANGE);
			tableAfectaciones.setBackground(Color.DARK_GRAY);
			tableAfectaciones.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Tipo", "Material Predominante"}));			
		}
		return tableAfectaciones;
	}
	public JScrollPane getScrollPaneMuebles(){
		if(scrollPaneMuebles==null){
			scrollPaneMuebles = new JScrollPane();
			scrollPaneMuebles.setBounds(10, 281, 282, 139);
			scrollPaneMuebles.setViewportView(getTableMuebles());
		}
		return scrollPaneMuebles;
	}
	public JTable getTableMuebles(){
		if(tableMuebles==null){
			tableMuebles = new JTable();
			tableMuebles.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Mueble", "Cantidad"}));
			tableMuebles.setFillsViewportHeight(true);
			tableMuebles.setForeground(Color.ORANGE);
			tableMuebles.setBackground(Color.DARK_GRAY);
		}
		return tableMuebles;
	}
	public JLabel getLblAfectacionInmueble(){		
		if(lblAfectacionInmueble==null){
			lblAfectacionInmueble = new JLabel("Afectaci\u00F3n al Inmueble:");
			lblAfectacionInmueble.setHorizontalAlignment(SwingConstants.CENTER);
			lblAfectacionInmueble.setBounds(10, 256, 292, 14);
		}
		return lblAfectacionInmueble;
	}
	public JLabel getLblAfectacinVivienda(){
		if(lblAfectacinVivienda==null){
			lblAfectacinVivienda= new JLabel("Afectaci\u00F3n a la vivienda:");
			lblAfectacinVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblAfectacinVivienda.setBounds(10, 80, 284, 15);
		}
		return lblAfectacinVivienda;
	}
	public JLabel getLblFechaLevantamiento(){
		if(lblFechaLevantamiento==null){
			lblFechaLevantamiento= new JLabel("Fecha Levantamiento: "
					+ficha.getFechaLevantamiento().getDate()+"/"
					+ficha.getFechaLevantamiento().getMonth()+"/"
					+ficha.getFechaLevantamiento().getYear());
			lblFechaLevantamiento.setBounds(10, 431, 282, 34);
		}
		return lblFechaLevantamiento;
	}
	public JLabel getLblId(){
		if(lblId==null){
			lblId = new JLabel("ID: "+ficha.getId().toString());
			lblId.setBounds(10, 462, 282, 14);
		}
		return lblId;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public JLabel getLblDatosVivienda(){
		if(lblDatosVivienda==null){
			lblDatosVivienda = new JLabel("Datos de la vivienda asociada:");
			lblDatosVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosVivienda.setBounds(10, 11, 284, 14);
		}
		return lblDatosVivienda;
	}
	public JLabel getLblJefeNucleo(){	
		if(lblJefeNucleo==null){
			lblJefeNucleo = new JLabel("Jefe de n\u00FAcleo: "+ficha.getVivienda().getJefeNucleo().getNombre());
			lblJefeNucleo.setBounds(10, 36, 282, 14);
		}
		return lblJefeNucleo;
	}
	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion = new JLabel("Direcci\u00F3n: "+ficha.getVivienda().getDireccion());
			lblDireccion.setBounds(10, 61, 282, 14);
		}
		return lblDireccion;
	}

	//Metodos
	public void actualizarTableAfectaciones(ArrayList<Afectacion> afectaciones) {
		DefaultTableModel model = (DefaultTableModel) tableAfectaciones.getModel();
		model.setRowCount(0); // Limpiar la tabla

		String tipo;
		String materialPredominante;
		String esDerrumbeTotal;
		String esDeCarga;
		if(afectaciones!=null)
			for (int i = 0; i < afectaciones.size(); i++) {
				if (afectaciones.get(i) instanceof AfectacionPared){				
					AfectacionPared a =  ((AfectacionPared)afectaciones.get(i));
					tipo = "Pared";
					materialPredominante = a.getMaterialPredominante();
					esDerrumbeTotal = a.getEsDerrumbeTotal()? "Total" : "Parcial";
					esDeCarga= a.getEsDeCarga() ? "Sí" : "No";
				}
				else{			
					AfectacionTecho a =  ((AfectacionTecho)afectaciones.get(i));
					tipo = "Techo";	
					materialPredominante = a.getMaterialPredominante();		
					esDerrumbeTotal = a.getEsDerrumbeTotal()? "Total" : "Parcial";
					esDeCarga="-";
				}
				Object[] newRow = new Object[] { tipo, materialPredominante, esDerrumbeTotal, esDeCarga};
				model.addRow(newRow);			
			}
		getTableAfectaciones().setModel(model);
	}
	public void actualizarTableMuebles(ArrayList<Mueble> muebles) {
		DefaultTableModel model = (DefaultTableModel) tableMuebles.getModel();
		model.setRowCount(0); // Limpiar la tabla
		if(muebles!=null)
			for (int i = 0; i < muebles.size(); i++) {
				Mueble m = muebles.get(i);
				String nombre=m.getNombre();
				String cantidad=((Integer)m.getCantidad()).toString();
				Object[] newRow = new Object[]{nombre, cantidad};
				model.addRow(newRow);			
			}
		getTableMuebles().setModel(model);
	}		

}