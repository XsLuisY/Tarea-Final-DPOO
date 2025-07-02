package ui;

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

import clases.Material;
import clases.OficinaTramites;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.UUID;

public class GestionMateriales extends JFrame {

	private static GestionMateriales gestionMateriales;
	private static final long serialVersionUID = 1L;

	private OficinaTramites oficina;
	private ArrayList<Material> materiales;

	private JPanel contentPane;
	private JScrollPane scrollPaneMateriales;
	private JTable tableMateriales;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	//Singleton
	public static GestionMateriales getGestionMateriales(OficinaTramites oficina){
		if(gestionMateriales==null
				|| !gestionMateriales.oficina.equals(oficina))
			gestionMateriales= new GestionMateriales(oficina);
		return gestionMateriales;
	}

	//Constructor
	private GestionMateriales(OficinaTramites oficina) {
		setTitle("Materiales");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getTableMateriales(), getPopupMenu());
		this.oficina=oficina;
		materiales=oficina.getMateriales();
		updtTableMateriales(materiales);
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
					addMaterial();
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
					modMaterial();
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
					deleteMaterial();
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

	//Metodos
	public void cargarMateriales() {
		DefaultTableModel modelo = (DefaultTableModel) tableMateriales.getModel();
		modelo.setRowCount(0); // Limpiar tabla
		for (Material m : oficina.getMateriales()) {
			modelo.addRow(new Object[]{
					m.getNombre(), m.getUnidadMedida(), m.getPrecioUnitario()
			});
		}
	}
	public void updtTableMateriales(ArrayList<Material> material) {
		DefaultTableModel model = (DefaultTableModel) tableMateriales.getModel();
		model.setRowCount(0); // Limpiar la tabla

		for (int i = 0; i < materiales.size(); i++) {
			Material m = materiales.get(i);
			String nombre=m.getNombre();
			String unidadMedida=m.getUnidadMedida();
			String precioUnitario=((Double)m.getPrecioUnitario()).toString();

			Object[] newRow = new Object[]{nombre, unidadMedida, precioUnitario};
			model.addRow(newRow);			
		}
		getTableMateriales().setModel(model);
	}
	public Material getSelectedMaterial (){
		Material m=null;
		int pos = getTableMateriales().getSelectedRow();
		if (pos >= 0 && pos < materiales.size())
			m=materiales.get(pos);
		return m;
	}
	public void addMaterial(){
		new CrearMaterial(gestionMateriales, oficina).setVisible(true);
	}
	public void modMaterial(){
		Material m = getSelectedMaterial();
		if (m != null) 
			ModificarMaterial.getModificarMaterial(gestionMateriales, oficina, m).setVisible(true);
		else 
			JOptionPane.showMessageDialog(gestionMateriales, "Debes seleccionar un material para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);

	}
	public void deleteMaterial(){
		Material m = getSelectedMaterial();

		if (m != null) {
			int confirmar = JOptionPane.showConfirmDialog(gestionMateriales,"¿Seguro que deseas eliminar el material \"" + m.getNombre() + "\"?","Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			if (confirmar == JOptionPane.YES_OPTION) {
				try {
					oficina.deleteMaterial(m.getId());
					updtTableMateriales(oficina.getMateriales());
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(gestionMateriales, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(gestionMateriales, "Debes seleccionar un material para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}		
	}


	public void regresar(){
		dispose();
	}
}







