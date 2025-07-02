package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import clases.FichaTecnicaDO;
import clases.MICONS;
import clases.Material;
import clases.Vivienda;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GestionViviendas extends JFrame {
	private static final long serialVersionUID = 1L;
	private static GestionViviendas gestionViviendas;
	
	private MICONS micons;
	private ArrayList<Vivienda> viviendas;
	
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemMostrar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;

	//Singleton
	public static GestionViviendas getGestionViviendas(){
		if(gestionViviendas==null)
		gestionViviendas = new GestionViviendas();
		return gestionViviendas;
	}
	
	//Constructor
	private GestionViviendas() {
		setTitle("Gestion de Viviendas");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		micons=MICONS.getMICONS();	
		viviendas=micons.getViviendas();
		setJMenuBar(getBarraSuperior());		
		setContentPane(getContentPane());
		addPopup(getTableViviendas(), getPopupMenu());
		actualizarTableViviendas();
	}

	//Atibutos
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
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getScrollPane());
		}
		return contentPane;
	}
	public JScrollPane getScrollPane(){
		if(scrollPane==null){
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 364, 224);
			scrollPane.setViewportView(getTableViviendas());
		}
		return scrollPane;
	}
	public JTable getTableViviendas(){
		if(table==null){
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setForeground(Color.ORANGE);
			table.setBackground(Color.DARK_GRAY);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Jefe de Nï¿½cleo", "Direcciï¿½n", "ID"
					}
					));
		}
		return table;
	}
	public JPopupMenu getPopupMenu(){	
		if(popupMenu==null){
			popupMenu = new JPopupMenu();
			popupMenu.setForeground(Color.ORANGE);
			popupMenu.setBackground(Color.DARK_GRAY);
			popupMenu.add(getMenuItemAgregar());
			popupMenu.add(getMenuItemMostrar());
			popupMenu.add(getMenuItemModificar());
			popupMenu.add(getMenuItemEliminar());
		}
		return popupMenu;
	}
	public JMenuItem getMenuItemAgregar(){
		if(menuItemAgregar==null){
			menuItemAgregar = new JMenuItem("Agregar");
			menuItemAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
			menuItemAgregar.setForeground(Color.ORANGE);
			menuItemAgregar.setBackground(Color.DARK_GRAY);
			menuItemAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addVivienda();
				}
			});
		}
		return menuItemAgregar;
	}
	public JMenuItem getMenuItemMostrar(){
		if(menuItemMostrar==null){
			menuItemMostrar = new JMenuItem("Mostrar");
			menuItemMostrar.setHorizontalAlignment(SwingConstants.RIGHT);
			menuItemMostrar.setForeground(Color.ORANGE);
			menuItemMostrar.setBackground(Color.DARK_GRAY);
			menuItemMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				showVivienda();
				}
			});
		}
		return menuItemMostrar;
	}
	public JMenuItem getMenuItemModificar(){
		if(menuItemModificar==null){
			menuItemModificar = new JMenuItem("Modificar");
			menuItemModificar.setHorizontalAlignment(SwingConstants.RIGHT);
			menuItemModificar.setForeground(Color.ORANGE);
			menuItemModificar.setBackground(Color.DARK_GRAY);
			menuItemModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				updtVivienda();
				}
			});

		}
		return menuItemModificar;
	}
	public JMenuItem getMenuItemEliminar(){
		if(menuItemEliminar==null){
			menuItemEliminar = new JMenuItem("Eliminar");
			menuItemEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
			menuItemEliminar.setForeground(Color.ORANGE);
			menuItemEliminar.setBackground(Color.DARK_GRAY);
			menuItemEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					delVivienda();
					}
			});
		}
		return menuItemEliminar;
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

	public Vivienda obtenerViviendaSeleccionada(){
		Vivienda v = null;
		int pos = getTableViviendas().getSelectedRow();
		if (pos >= 0 && pos < viviendas.size()) {
			v=viviendas.get(pos);
		}
		return v;
	}
	public void actualizarTableViviendas() {
		DefaultTableModel model = (DefaultTableModel) getTableViviendas().getModel();
		model.setRowCount(0); // Limpiar la tabla

		for(Vivienda v:  viviendas){
			Object[] newRow = new Object[]{v.getJefeNucleo().getNombre(),v.getDireccion(), v.getJefeNucleo().getCI()};
			model.addRow(newRow);			
		}
		getTableViviendas().setModel(model);
	}
	public void addVivienda(){
		CrearVivienda.getCrearVivienda(gestionViviendas).setVisible(true);
	}
	public void showVivienda(){
		Vivienda v = obtenerViviendaSeleccionada();
		if (v != null) {
			dispose();
			MostrarVivienda.getMostrarVivienda(v).setVisible(true);
		} else 
			JOptionPane.showMessageDialog(gestionViviendas, "Debes seleccionar una vivienda para mostrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
	}
	public void updtVivienda(){
		Vivienda v = obtenerViviendaSeleccionada();
		if (v != null) {
			dispose();
			ModificarVivienda.getModificarVivienda(gestionViviendas, v).setVisible(true);
		} else 
			JOptionPane.showMessageDialog(gestionViviendas, "Debes seleccionar una vivienda para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);

	}
	public void delVivienda(){
		Vivienda v = obtenerViviendaSeleccionada();
		if(v!=null){
			int confirmar = JOptionPane.showConfirmDialog(gestionViviendas,"¿Seguro que deseas eliminar esta FTDO?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);

			if (confirmar == JOptionPane.YES_OPTION) {
				micons.deleteVivienda(v.getJefeNucleo().getCI());
				JOptionPane.showMessageDialog(gestionViviendas, "Ficha Tecnica de Daños Ocacionados  eliminada con exito.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				actualizarTableViviendas();
			}
		}else 
			JOptionPane.showMessageDialog(gestionViviendas, "Debe seleccionar una Ficha Tecnica de Daños Ocacionados para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	
	}
	public void regresar(){
		dispose();
		Principal.getPrincipal().setVisible(true);
	}


}













