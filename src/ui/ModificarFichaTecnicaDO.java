package ui;

import interfaces.AsignableAfectaciones;
import interfaces.AsignableMuebles;
import interfaces.AsignableVivienda;

import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.JButton;

import clases.Afectacion;
import clases.AfectacionPared;
import clases.AfectacionTecho;
import clases.FichaTecnicaDO;
import clases.Mueble;
import clases.OficinaTramites;
import clases.Vivienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import utils.SeleccionarViviendas;

public class ModificarFichaTecnicaDO extends JFrame implements AsignableAfectaciones, AsignableMuebles, AsignableVivienda {	

	private static ModificarFichaTecnicaDO modificarFichaTecnicaDO;
	private static final long serialVersionUID = 1L;

	private OficinaTramites oficina;
	private FichaTecnicaDO ficha;
	private GestionFichaTecnicaDO gestion;
	private ArrayList<Afectacion> afectaciones;
	private ArrayList<Mueble> muebles;
	private Vivienda vivienda;

	private JPanel contentPane;
	private JTable tableMuebles;
	private JTable tableAfectaciones;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JScrollPane scrollPaneAfectaciones;
	private JPopupMenu popupMenuAfectaciones;
	private JMenuItem mntmAgregarAfectacion;
	private JMenuItem mntmModificarAfectacion;
	private JMenuItem mntmEliminarAfectacion;
	private JScrollPane scrollPaneMuebles;
	private JPopupMenu popupMenuMuebles;
	private JMenuItem mntmAgregarMueble ;
	private JMenuItem mntmModificarMueble;
	private JMenuItem mntmEliminarMueble;
	private JLabel lblAfectacionInmueble; 
	private JLabel lblAfectacinVivienda; 
	private JLabel lblViviendaAsociada; 
	private JTextField textDireccion;
	private JButton btnAsignarVivienda;
	private JButton btnModificar;

	//Singleton
	public static ModificarFichaTecnicaDO getModificarFichaTecnicaDO(GestionFichaTecnicaDO gestion, OficinaTramites oficina, FichaTecnicaDO ficha){
		if(modificarFichaTecnicaDO==null)
			modificarFichaTecnicaDO= new ModificarFichaTecnicaDO(gestion, oficina, ficha);
		return modificarFichaTecnicaDO;
	}
	//Constructor
	private ModificarFichaTecnicaDO(GestionFichaTecnicaDO gestion, OficinaTramites oficina, FichaTecnicaDO ficha) {
		setType(Type.UTILITY);
		setTitle("Ficha T\u00E9cnica de Da\u00F1os Ocacionados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 500); 	
		this.gestion=gestion;		
		this.oficina=oficina;
		this.ficha=ficha;	
		afectaciones=ficha.getAfectaciones();
		muebles=ficha.getMuebles();
		vivienda=ficha.getVivienda();		
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
		addPopup(getTableAfectaciones(), getPopupMenuAfectaciones());
		addPopup(getTableMuebles(), getPopupMenuMuebles());

		rellenarFormulario();
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
			contentPane.add(getBtnModificar());
			contentPane.add(getLblViviendaAsociada());
			contentPane.add(getTextDireccion());
			contentPane.add(getBtnAsignarVivienda());

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
					limpiarCampos();
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JScrollPane getScrollPaneAfectaciones(){
		if(scrollPaneAfectaciones==null){
			scrollPaneAfectaciones = new JScrollPane();
			scrollPaneAfectaciones.setBounds(10, 37, 282, 139);
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
			tableAfectaciones.setModel(new DefaultTableModel(new Object[][] {},new String[] { "Tipo", "Material", "Derrumbe", "Carga" }));			
		}
		return tableAfectaciones;
	}
	public JPopupMenu getPopupMenuAfectaciones(){
		if(popupMenuAfectaciones==null){
			popupMenuAfectaciones = new JPopupMenu();
			popupMenuAfectaciones.add(getMntmAgregarAfectacion());
			popupMenuAfectaciones.add(getMntmModificarAfectacion());
			popupMenuAfectaciones.add(getMntmEliminarAfectacion());
		}
		return popupMenuAfectaciones;
	}
	public JMenuItem getMntmAgregarAfectacion(){			
		if(mntmAgregarAfectacion==null){
			mntmAgregarAfectacion = new JMenuItem("Agregar");
			mntmAgregarAfectacion.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmAgregarAfectacion.setBackground(Color.DARK_GRAY);
			mntmAgregarAfectacion.setForeground(Color.ORANGE);
			mntmAgregarAfectacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CrearAfectacion c = CrearAfectacion.getCrearAfectacion(modificarFichaTecnicaDO, ficha);
					c.setVisible(true);
				}
			});
		}
		return mntmAgregarAfectacion;
	}
	public JMenuItem getMntmModificarAfectacion(){
		if(mntmModificarAfectacion==null){
			mntmModificarAfectacion = new JMenuItem("Modificar");
			mntmModificarAfectacion.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmModificarAfectacion.setBackground(Color.DARK_GRAY);
			mntmModificarAfectacion.setForeground(Color.ORANGE);
			mntmModificarAfectacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Afectacion a= getAfectacionSeleccionada();
					if (a != null) {
						ModificarAfectacion.getModificarAfectacion(modificarFichaTecnicaDO, ficha, a).setVisible(true);
					} else 
						JOptionPane.showMessageDialog(ModificarFichaTecnicaDO.this, "Debes seleccionar una afectacion para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE );					
				}
			});
		}
		return mntmModificarAfectacion;
	}
	public JMenuItem getMntmEliminarAfectacion(){ 
		if(mntmEliminarAfectacion == null){
			mntmEliminarAfectacion = new JMenuItem("Eliminar");
			mntmEliminarAfectacion.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmEliminarAfectacion.setBackground(Color.DARK_GRAY);
			mntmEliminarAfectacion.setForeground(Color.ORANGE);
			mntmEliminarAfectacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Afectacion afectacion = getAfectacionSeleccionada();
					if (afectacion != null) {
						int confirmar = JOptionPane.showConfirmDialog(ModificarFichaTecnicaDO.this, "¿Seguro que deseas eliminar la afectación seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION );

						if (confirmar == JOptionPane.YES_OPTION) { 
							ficha.delAfectacion(afectacion.getId()); 
							actualizarTableAfectaciones(ficha.getAfectaciones());}
					} else {
						JOptionPane.showMessageDialog( ModificarFichaTecnicaDO.this, "Debes seleccionar una afectación para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE );
					}
				}
			});
		}
		return mntmEliminarAfectacion;
	}

	public JScrollPane getScrollPaneMuebles(){
		if(scrollPaneMuebles==null){
			scrollPaneMuebles = new JScrollPane();
			scrollPaneMuebles.setBounds(10, 212, 282, 139);
			scrollPaneMuebles.setViewportView(getTableMuebles());
		}
		return scrollPaneMuebles;
	}

	public JTable getTableMuebles(){
		if(tableMuebles==null){
			tableMuebles = new JTable();
			tableMuebles.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Mueble", "Cantidad"}));
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
					CrearMueble c = CrearMueble.getCrearMueble(modificarFichaTecnicaDO, ficha);
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
				public void actionPerformed(ActionEvent e) {
					Mueble mueble= getMuebleSeleccionado();
					if (mueble != null) {
						ModificarMueble m = ModificarMueble.getModificarMueble(modificarFichaTecnicaDO, ficha, mueble);
						m.setVisible(true);
					} else 
						JOptionPane.showMessageDialog(ModificarFichaTecnicaDO.this, "Debes seleccionar un mueble para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);

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
			mntmEliminarMueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int fila = getTableMuebles().getSelectedRow();
					if (fila >= 0) {
						String nombre = (String) getTableMuebles().getValueAt(fila, 0);
						int confirmar = JOptionPane.showConfirmDialog(ModificarFichaTecnicaDO.this,"¿Seguro que deseas eliminar el mueble \"" + nombre + "\"?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
						if (confirmar == JOptionPane.YES_OPTION) 
							try {
								ficha.delMueble(nombre);
								actualizarTableMuebles(ficha.getMuebles());
							} catch (IllegalArgumentException ex) {
								JOptionPane.showMessageDialog(ModificarFichaTecnicaDO.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}			            
					} else 
						JOptionPane.showMessageDialog( ModificarFichaTecnicaDO.this,"Debes seleccionar un mueble para eliminar.","Aviso", JOptionPane.WARNING_MESSAGE);

				}
			});
		}
		return mntmEliminarMueble;
	}
	public JLabel getLblAfectacionInmueble(){		
		if(lblAfectacionInmueble==null){
			lblAfectacionInmueble = new JLabel("Afectaci\u00F3n al Inmueble:");
			lblAfectacionInmueble.setHorizontalAlignment(SwingConstants.CENTER);
			lblAfectacionInmueble.setBounds(10, 187, 292, 14);
		}
		return lblAfectacionInmueble;
	}
	public JLabel getLblAfectacinVivienda(){
		if(lblAfectacinVivienda==null){
			lblAfectacinVivienda= new JLabel("Afectaci\u00F3n a la vivienda:");
			lblAfectacinVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblAfectacinVivienda.setBounds(10, 11, 284, 15);
		}
		return lblAfectacinVivienda;
	}

	public JButton getBtnAsignarVivienda(){
		if(btnAsignarVivienda==null){
			btnAsignarVivienda = new JButton("Asignar vivienda");
			btnAsignarVivienda.setBackground(Color.DARK_GRAY);
			btnAsignarVivienda.setForeground(Color.ORANGE);
			btnAsignarVivienda.setBounds(10, 387, 116, 23);
			btnAsignarVivienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SeleccionarViviendas s = new SeleccionarViviendas(ModificarFichaTecnicaDO.this, ficha);
					s.setVisible(true);							
				}
			});
		}
		return btnAsignarVivienda;
	}
	public JTextField getTextDireccion(){
		if(textDireccion==null){
			textDireccion = new JTextField();
			textDireccion.setEditable(false);
			textDireccion.setBounds(136, 362, 156, 20);
			textDireccion.setColumns(10);
		}
		return textDireccion;
	}
	public JLabel getLblViviendaAsociada(){
		if(lblViviendaAsociada==null){
			lblViviendaAsociada= new JLabel("Vivienda asociada:");
			lblViviendaAsociada.setBounds(10, 362, 116, 14);		
		}
		return lblViviendaAsociada;
	}

	public JButton getBtnModificar(){
		if(btnModificar==null){
			btnModificar = new JButton("Modificar");			
			btnModificar.setForeground(Color.ORANGE);
			btnModificar.setBackground(Color.DARK_GRAY);
			btnModificar.setBounds(205, 403, 89, 23);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						if (ficha.getAfectaciones().isEmpty() && ficha.getMuebles().isEmpty())
							JOptionPane.showMessageDialog(ModificarFichaTecnicaDO.this,"La ficha técnica debe contener al menos una afectación o un mueble.","Validación", JOptionPane.WARNING_MESSAGE);						
						else
							if(ficha.getVivienda()==null)
								JOptionPane.showMessageDialog(ModificarFichaTecnicaDO.this,"La ficha técnica debe Estar asociada a una vivienda.","Validación", JOptionPane.WARNING_MESSAGE);
							else
							{														
								boolean updt = oficina.updateFichaTecnicaDO(ficha.getId(), vivienda);
								if(updt){									
									JOptionPane.showMessageDialog(null, "Ficha Tecnica de Daños Ocacionados modificada exitosamente.");			            
									gestion.actualizarTableFichas(oficina.getFichas());								
									limpiarCampos();
									dispose();
								} else 
									JOptionPane.showMessageDialog(null, "Ya existe una Ficha Tecnica de Daños Ocacionados asociada a esta vivienda.", "Advertencia", JOptionPane.WARNING_MESSAGE);
							}
					}catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(ModificarFichaTecnicaDO.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

					);
		}		
		return btnModificar; 
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
	public Afectacion getAfectacionSeleccionada(){
		Afectacion a=null;
		int pos = getTableAfectaciones().getSelectedRow();
		if (pos >= 0 && pos < afectaciones.size())
			a=afectaciones.get(pos);
		return a;
	}
	public Mueble getMuebleSeleccionado(){
		Mueble m=null;
		int pos = getTableMuebles().getSelectedRow();
		if (pos >= 0 && pos < muebles.size())
			m=muebles.get(pos);
		return m;
	}

	public void actualizarViviendaAsociada(){
		getTextDireccion().setText(ficha.getVivienda().getDireccion());
	}
	private void rellenarFormulario(){
		actualizarViviendaAsociada();
		actualizarTableAfectaciones(afectaciones);
		actualizarTableMuebles(muebles);
	}
	private void limpiarCampos() {
		
		getTextDireccion().setText("");

	if (getTableAfectaciones() != null) {
		DefaultTableModel model = (DefaultTableModel) tableAfectaciones.getModel();
		model.setRowCount(0);
	}

	if (getTableMuebles() != null) {
		DefaultTableModel model = (DefaultTableModel) tableMuebles.getModel();
		model.setRowCount(0);
	}
}
}







