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

import clases.MICONS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarFichaTecnicaDO extends JFrame {
	private MICONS micons;
	private JPanel contentPane;
	private JTable tableMuebles;
	private JTable tableAfectaciones;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JScrollPane scrollPaneAfectaciones;
	private JPopupMenu popupMenuAfectaciones;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JScrollPane scrollPaneMuebles;
	private JPopupMenu popupMenuMuebles;
	private JMenuItem mntmAgregarMueble ;
	private JMenuItem mntmModificarMueble;
	private JMenuItem mntmEliminarMueble;
	private JLabel lblAfectacionInmueble; 
	private JLabel lblAfectacinVivienda; 
	private JLabel lblFechaLevantamiento;
	private JLabel lblId;
	private JLabel lblDatosVivienda; 
	private JLabel lblJefeNucleo;
	private JLabel lblDireccion;

	public MostrarFichaTecnicaDO(MICONS micons) {
		setType(Type.UTILITY);
		setTitle("Ficha T\u00E9cnica de Da\u00F1os Ocacionados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 550);
		this.micons=micons;
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
		addPopup(getTableAfectaciones(), getPopupMenuAfectaciones());
		addPopup(getTableMuebles(), getPopupMenuMuebles());
	}

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
			tableAfectaciones.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Tipo", "Material Predominante"
					}
					));			
		}
		return tableAfectaciones;
	}
	public JPopupMenu getPopupMenuAfectaciones(){
		if(popupMenuAfectaciones==null){
			popupMenuAfectaciones = new JPopupMenu();
			popupMenuAfectaciones.add(getMntmAgregar());
			popupMenuAfectaciones.add(getMntmModificar());
			popupMenuAfectaciones.add(getMntmEliminar());
		}
		return popupMenuAfectaciones;
	}
	public JMenuItem getMntmAgregar(){			
		if(mntmAgregar==null){
			mntmAgregar = new JMenuItem("Agregar");
			mntmAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmAgregar.setBackground(Color.DARK_GRAY);
			mntmAgregar.setForeground(Color.ORANGE);
			mntmAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CrearAfectacion c = new CrearAfectacion(micons);
					c.setVisible(true);
				}
			});
		}
		return mntmAgregar;
	}
	public JMenuItem getMntmModificar(){
		if(mntmModificar==null){
			mntmModificar = new JMenuItem("Modificar");
			mntmModificar.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmModificar.setBackground(Color.DARK_GRAY);
			mntmModificar.setForeground(Color.ORANGE);
			mntmModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ModificarAfectacion m=new ModificarAfectacion(micons);
					m.setVisible(true);
				}
			});
		}
		return mntmModificar;
	}
	public JMenuItem getMntmEliminar(){	
		if(mntmEliminar==null){
			mntmEliminar = new JMenuItem("Eliminar");
			mntmEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmEliminar.setBackground(Color.DARK_GRAY);
			mntmEliminar.setForeground(Color.ORANGE);
		}
		return mntmEliminar;
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
			tableMuebles.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Mueble", "Cantidad"
					}
					));
			tableMuebles.setFillsViewportHeight(true);
			tableMuebles.setForeground(Color.ORANGE);
			tableMuebles.setBackground(Color.DARK_GRAY);
		}
		return tableMuebles;
	}
	public JPopupMenu getPopupMenuMuebles(){ 
		if(popupMenuMuebles==null){
			popupMenuMuebles = new JPopupMenu();
			popupMenuMuebles.add(getMntmAgregarMueble());
			popupMenuMuebles.add(getMntmModificarMueble());
			popupMenuMuebles.add(getMntmEliminarMueble());
		}
		return popupMenuMuebles;
	}
	public JMenuItem getMntmAgregarMueble(){
		if(mntmAgregarMueble==null){
			mntmAgregarMueble = new JMenuItem("Agregar");
			mntmAgregarMueble.setBackground(Color.DARK_GRAY);
			mntmAgregarMueble.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmAgregarMueble.setForeground(Color.ORANGE);
			mntmAgregarMueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CrearMueble c =new CrearMueble(micons);
					c.setVisible(true);
				}
			});
		}
		return mntmAgregarMueble;
	}
	public JMenuItem getMntmModificarMueble(){
		if(mntmModificarMueble==null){
			mntmModificarMueble = new JMenuItem("Modificar");
			mntmModificarMueble.setBackground(Color.DARK_GRAY);
			mntmModificarMueble.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmModificarMueble.setForeground(Color.ORANGE);
			mntmModificarMueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ModificarMueble m =new ModificarMueble(micons);
					m.setVisible(true);
				}
			});
		}
		return mntmModificarMueble;
	}
	public JMenuItem getMntmEliminarMueble(){
		if(mntmEliminarMueble==null){
			mntmEliminarMueble= new JMenuItem("Eliminar");
			mntmEliminarMueble.setBackground(Color.DARK_GRAY);
			mntmEliminarMueble.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmEliminarMueble.setForeground(Color.ORANGE);
		}
		return mntmEliminarMueble;
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
			lblFechaLevantamiento= new JLabel("Fecha Levantamiento:");
			lblFechaLevantamiento.setBounds(10, 434, 133, 14);
		}
		return lblFechaLevantamiento;
	}
	public JLabel getLblId(){
		if(lblId==null){
			lblId = new JLabel("ID:");
			lblId.setBounds(10, 462, 172, 14);
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
			lblJefeNucleo = new JLabel("Jefe de n\u00FAcleo:");
			lblJefeNucleo.setBounds(10, 36, 282, 14);
		}
		return lblJefeNucleo;
	}
	public JLabel getLblDireccion(){
		if(lblDireccion==null){
			lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setBounds(10, 61, 282, 14);
		}
		return lblDireccion;
	}
}