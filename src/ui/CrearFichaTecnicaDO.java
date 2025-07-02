package ui;

import interfaces.AsignableAfectaciones;
import interfaces.AsignableMuebles;
import interfaces.AsignableVivienda;

import java.awt.Color;

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

public class CrearFichaTecnicaDO extends JFrame implements AsignableAfectaciones, AsignableMuebles, AsignableVivienda {	

	private static final long serialVersionUID = 1L;
	private static CrearFichaTecnicaDO crearFichaTecnicaDO;
	private GestionFichaTecnicaDO gestion;
	private FichaTecnicaDO ficha;
	private OficinaTramites oficina;
	private ArrayList<Afectacion> afectaciones;
	private ArrayList<Mueble> muebles;	
	private Vivienda vivienda;

	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JPanel contentPane;

	private JScrollPane scrollPaneAfectaciones;
	private JTable tableAfectaciones;
	private JPopupMenu popupMenuAfectaciones;
	private JMenuItem mntmAgregarAfectacion;
	private JMenuItem mntmModificarAfectacion;
	private JMenuItem mntmEliminarAfectacion;

	private JScrollPane scrollPaneMuebles;
	private JTable tableMuebles;
	private JPopupMenu popupMenuMuebles;
	private JMenuItem mntmAgregarMueble ;
	private JMenuItem mntmModificarMueble;
	private JMenuItem mntmEliminarMueble;

	private JLabel lblAfectacionInmueble; 
	private JLabel lblAfectacinVivienda; 
	private JLabel lblViviendaAsociada; 

	private JTextField textDireccion;

	private JButton btnAsignarVivienda;
	private JButton btnEnviar;

	//Singleton
	public static CrearFichaTecnicaDO getCrearFichaTecnicaDO(GestionFichaTecnicaDO gestion, OficinaTramites oficina){
		if(crearFichaTecnicaDO==null
				|| !crearFichaTecnicaDO.gestion.equals(gestion)
				|| !crearFichaTecnicaDO.oficina.equals(oficina))
			crearFichaTecnicaDO=new CrearFichaTecnicaDO(gestion, oficina);
		return crearFichaTecnicaDO;
	}

	//Constructor
	private CrearFichaTecnicaDO(GestionFichaTecnicaDO gestion, OficinaTramites oficina) {
		setType(Type.UTILITY);
		setTitle("Ficha T\u00E9cnica de Da\u00F1os Ocacionados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 500); 	
		this.gestion=gestion;		
		this.oficina=oficina;
		ficha=new FichaTecnicaDO();	
		afectaciones=ficha.getAfectaciones();
		muebles=ficha.getMuebles();				
		setContentPane(getContentPane());
		setJMenuBar(getBarraSuperior());
		addPopup(getTableAfectaciones(), getPopupMenuAfectaciones());
		addPopup(getTableMuebles(), getPopupMenuMuebles());
	}

	//Atributos

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
					regresar();
				}
			});
		}
		return mntmRegresar;
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
			contentPane.add(getBtnEnviar());
			contentPane.add(getLblViviendaAsociada());
			contentPane.add(getTextDireccion());
			contentPane.add(getBtnAsignarVivienda());

		}
		return contentPane;
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
			tableAfectaciones.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] { "Tipo", "Material", "Derrumbe", "Carga" }
					));			
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
					CrearAfectacion c = CrearAfectacion.getCrearAfectacion(CrearFichaTecnicaDO.this, ficha);
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
						//TODO Revisar excepciones (NullPointer) y xq no se instancia ModificarAfectacion
						ModificarAfectacion m = ModificarAfectacion.getModificarAfectacion(crearFichaTecnicaDO, ficha, a);
						m.setVisible(true);
					} else 
						JOptionPane.showMessageDialog(CrearFichaTecnicaDO.this, "Debes seleccionar una afectacion para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE );					
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
						int confirmar = JOptionPane.showConfirmDialog(CrearFichaTecnicaDO.this, "¿Seguro que deseas eliminar la afectación seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION );

						if (confirmar == JOptionPane.YES_OPTION) { 
							ficha.delAfectacion(afectacion.getId()); 
							actualizarTableAfectaciones(ficha.getAfectaciones());}
					} else {
						JOptionPane.showMessageDialog( CrearFichaTecnicaDO.this, "Debes seleccionar una afectación para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE );
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
					CrearMueble c = CrearMueble.getCrearMueble(crearFichaTecnicaDO, ficha);
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
						//TODO Revisar excepciones (NullPointer) y xq no se instancia ModificarMueble
						ModificarMueble m = ModificarMueble.getModificarMueble(crearFichaTecnicaDO, ficha, mueble);
						m.setVisible(true);
					} else 
						JOptionPane.showMessageDialog(CrearFichaTecnicaDO.this, "Debes seleccionar un mueble para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);

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
						int confirmar = JOptionPane.showConfirmDialog(CrearFichaTecnicaDO.this,"¿Seguro que deseas eliminar el mueble \"" + nombre + "\"?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
						if (confirmar == JOptionPane.YES_OPTION) 
							try {
								ficha.delMueble(nombre);
								actualizarTableMuebles(ficha.getMuebles());
							} catch (IllegalArgumentException ex) {
								JOptionPane.showMessageDialog(CrearFichaTecnicaDO.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}			            
					} else 
						JOptionPane.showMessageDialog( CrearFichaTecnicaDO.this,"Debes seleccionar un mueble para eliminar.","Aviso", JOptionPane.WARNING_MESSAGE);

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
	public JLabel getLblViviendaAsociada(){
		if(lblViviendaAsociada==null){
			lblViviendaAsociada= new JLabel("Vivienda asociada:");
			lblViviendaAsociada.setBounds(10, 362, 116, 14);		
		}
		return lblViviendaAsociada;
	}

	public JTextField getTextDireccion(){
		if(textDireccion==null){
			textDireccion = new JTextField("No hay una vivienda asignada");
			textDireccion.setEditable(false);
			textDireccion.setBounds(136, 362, 156, 20);
			textDireccion.setColumns(10);
		}
		return textDireccion;
	}

	public JButton getBtnAsignarVivienda(){
		if(btnAsignarVivienda==null){
			btnAsignarVivienda = new JButton("Asignar vivienda");
			btnAsignarVivienda.setBackground(Color.DARK_GRAY);
			btnAsignarVivienda.setForeground(Color.ORANGE);
			btnAsignarVivienda.setBounds(10, 387, 116, 23);
			btnAsignarVivienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SeleccionarViviendas s = new SeleccionarViviendas(CrearFichaTecnicaDO.this, ficha);
					s.setVisible(true);							
				}
			});
		}
		return btnAsignarVivienda;
	}
	public JButton getBtnEnviar(){
		if(btnEnviar==null){
			btnEnviar = new JButton("Enviar");			
			btnEnviar.setForeground(Color.ORANGE);
			btnEnviar.setBackground(Color.DARK_GRAY);
			btnEnviar.setBounds(205, 403, 89, 23);
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addFichaTecnicaDO();
				}
			});
		}		
		return btnEnviar; 
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

		for (int i = 0; i < muebles.size(); i++) {
			Mueble m = muebles.get(i);
			String nombre=m.getNombre();
			String cantidad=((Integer)m.getCantidad()).toString();
			Object[] newRow = new Object[]{nombre, cantidad};
			model.addRow(newRow);			
		}
		getTableMuebles().setModel(model);
	}
	public void actualizarViviendaAsociada(){
		if(vivienda!=null)
			getTextDireccion().setText(vivienda.getDireccion());
		
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

	public void addFichaTecnicaDO(){
		try{

			if (ficha.getAfectaciones().isEmpty() && ficha.getMuebles().isEmpty())
				JOptionPane.showMessageDialog(crearFichaTecnicaDO,"La ficha técnica debe contener al menos una afectación o un mueble.","Validación", JOptionPane.WARNING_MESSAGE);						
			else
				if(vivienda==null)
					JOptionPane.showMessageDialog(crearFichaTecnicaDO,"La ficha técnica debe Estar asociada a una vivienda.","Validación", JOptionPane.WARNING_MESSAGE);
				else{																			
					if(oficina.addFichaTecnicaDO(vivienda, ficha.getAfectaciones(), ficha.getMuebles())){									
						JOptionPane.showMessageDialog(crearFichaTecnicaDO, "Ficha Tecnica de Daños Ocacionados agregada exitosamente.");			            
						gestion.updtTableFichas(oficina.getFichas());								
						limpiarCampos();
						dispose();
					} else 
						JOptionPane.showMessageDialog(crearFichaTecnicaDO, "Ha ocurrido un error en la creación de la Ficha Tecnica de Daños Ocasionados.", "Error", JOptionPane.WARNING_MESSAGE);
				}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(crearFichaTecnicaDO, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void limpiarCampos() {

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
	public void regresar(){
		limpiarCampos();
		dispose();
	}

	@Override
	public void setVivienda(Vivienda vivienda){		
		this.vivienda=vivienda;
	}


}




