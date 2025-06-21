package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.ListSelectionModel;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

import clases.MICONS;
import clases.Material;
import clases.OficinaTramites;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GestionMateriales extends JFrame {
	private MICONS micons;
	private OficinaTramites actualOficinaTramites;
	private JPanel contentPane;
	private JScrollPane scrollPaneMateriales;
	private JTable tableMateriales;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	public GestionMateriales(OficinaTramites actualOficinaTramites) {
		setTitle("Materiales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		micons=MICONS.getMICONS();	
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getTableMateriales(), getPopupMenu());
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
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getScrollPaneMateriales());
		}
		return contentPane ;
	}
	public JScrollPane getScrollPaneMateriales(){	
		if(scrollPaneMateriales==null){
			scrollPaneMateriales = new JScrollPane();
			scrollPaneMateriales.setBounds(10, 11, 364, 215);
			scrollPaneMateriales.setViewportView(getTableMateriales());
		}
		return scrollPaneMateriales ;
	}
	public JTable getTableMateriales(){
		if(tableMateriales==null){
			tableMateriales = new JTable();
			tableMateriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableMateriales.setForeground(Color.ORANGE);
			tableMateriales.setFillsViewportHeight(true);
			tableMateriales.setBackground(Color.DARK_GRAY);
			tableMateriales.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Nombre", "u/medida", "Precio"
					}
					));
		}
		return tableMateriales;
	}
	public JPopupMenu getPopupMenu(){
		if(popupMenu==null){
			popupMenu = new JPopupMenu();
			popupMenu.setForeground(Color.ORANGE);
			popupMenu.setBackground(Color.DARK_GRAY);
			popupMenu.add(getMenuItemAgregar());			
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
					CrearMaterial c = new CrearMaterial();
					c.setVisible(true);
				}
			});
		}
		return menuItemAgregar;
	}

	public JMenuItem getMenuItemModificar(){
		if(menuItemModificar==null){
			menuItemModificar = new JMenuItem("Modificar");
			menuItemModificar.setHorizontalAlignment(SwingConstants.RIGHT);
			menuItemModificar.setForeground(Color.ORANGE);
			menuItemModificar.setBackground(Color.DARK_GRAY);
			menuItemModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ModificarMaterial c = new ModificarMaterial();
					c.setVisible(true);
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
				public void actionPerformed(ActionEvent e) {
					Material material = obtenerMaterialSeleccionado();

					if (material != null) {
						String nombre = material.getNombre();
						int confirmar = JOptionPane.showConfirmDialog(
								GestionMateriales.this,
								"¿Seguro que deseas eliminar \"" + nombre + "\"?",
								"Confirmar eliminación",
								JOptionPane.YES_NO_OPTION
								);

						if (confirmar == JOptionPane.YES_OPTION) {
							actualOficinaTramites.deleteMaterial(material.getId());
							cargarMateriales();
						}
					} else {
						JOptionPane.showMessageDialog(
								GestionMateriales.this,
								"Debes seleccionar un material para eliminar.",
								"Aviso",
								JOptionPane.WARNING_MESSAGE
								);
					}
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
	public void cargarMateriales() {
		DefaultTableModel modelo = (DefaultTableModel) tableMateriales.getModel();
		modelo.setRowCount(0); // Limpiar tabla
		for (Material m : actualOficinaTramites.getMateriales()) {
			modelo.addRow(new Object[]{
					m.getNombre(), m.getUnidadMedida(), m.getPrecioUnitario()
			});
		}
	}
	public Material obtenerMaterialSeleccionado() {
		Material seleccionado = null;
		int fila = tableMateriales.getSelectedRow();
		int i = 0;

		if (fila >= 0) {
			String nombre = (String) tableMateriales.getValueAt(fila, 0);
			ArrayList<Material> materiales = actualOficinaTramites.getMateriales();

			while (i < materiales.size()) {
				Material m = materiales.get(i);
				if (m.getNombre().equals(nombre) && seleccionado == null) {
					seleccionado = m;
				}
				i++;
			}
		}

		return seleccionado;
	}

}