package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

import clases.FichaTecnicaDO;
import clases.MICONS;
import clases.OficinaTramites;
import clases.Vivienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class GestionFichaTecnicaDO extends JFrame {
	private static GestionFichaTecnicaDO gestionFichaTecnicaDO;
	private static final long serialVersionUID = 1L;

	private ArrayList<FichaTecnicaDO> fichas;
	private OficinaTramites oficina;

	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;

	private JPanel contentPane;

	private JScrollPane scrollPane;
	private JTable tableFichas;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemMostrar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;

	//Singleton
	public static GestionFichaTecnicaDO getGestionFichaTecnicaDO(OficinaTramites oficina){		
		if(gestionFichaTecnicaDO==null
				|| !gestionFichaTecnicaDO.oficina.equals(oficina))
			gestionFichaTecnicaDO=new GestionFichaTecnicaDO(oficina);
		return gestionFichaTecnicaDO;
	}

	//Constructor
	private GestionFichaTecnicaDO(OficinaTramites oficina) {
		setTitle("Gesti\u00F3n de Fichas T\u00E9cnicas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		this.oficina=oficina;
		fichas=oficina.getFichas();
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getTableFichas(), getPopupMenu());
		updtTableFichas(fichas);
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
			contentPane.add(getScrollPane());

		}
		return contentPane;
	}

	public JScrollPane getScrollPane(){
		if(scrollPane==null){
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 364, 215);
			scrollPane.setViewportView(getTableFichas());
		}
		return scrollPane;
	}
	public JTable getTableFichas(){
		if(tableFichas==null){
			tableFichas = new JTable();
			tableFichas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableFichas.setForeground(Color.ORANGE);
			tableFichas.setFillsViewportHeight(true);
			tableFichas.setBackground(Color.DARK_GRAY);
			tableFichas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Direcci\u00F3n", "Fecha Levantamiento","ID"
					}
					));
		}
		return tableFichas;
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
					addFichaTecnicaDO();
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
					showFichaTecnicaDO();				
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
					modFichaTecnicaDO();
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
					deleteFichaTecnicaDO();
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
	public FichaTecnicaDO getSelectedFichaTecnicaDO(){
		FichaTecnicaDO f = null;
		int pos = getTableFichas().getSelectedRow();
		if (pos >= 0 && pos < fichas.size()) {
			f=fichas.get(pos);
		}
		return f;
	}
	public void updtTableFichas(ArrayList<FichaTecnicaDO> fichas) {
		DefaultTableModel model = (DefaultTableModel) getTableFichas().getModel();
		model.setRowCount(0); //

		for(FichaTecnicaDO f:  fichas){//TODO Revisar asignacion de direccion
			String direccion = (f.getVivienda() != null) ? f.getVivienda().getDireccion() : "Sin dirección";
			Date fechaLevantamiento=f.getFechaLevantamiento();
			Object[] newRow = new Object[]{direccion, fechaLevantamiento.getDate()+"/"+fechaLevantamiento.getMonth()+"/"+fechaLevantamiento.getYear(), f.getId()};
			model.addRow(newRow);			
		}
		getTableFichas().setModel(model);
	}

	public void addFichaTecnicaDO(){					
		CrearFichaTecnicaDO.getCrearFichaTecnicaDO(gestionFichaTecnicaDO , oficina).setVisible(true);					
	}	
	public void modFichaTecnicaDO(){
		FichaTecnicaDO f = getSelectedFichaTecnicaDO();

		if(f!=null)					
			ModificarFichaTecnicaDO.getModificarFichaTecnicaDO(gestionFichaTecnicaDO, oficina, f).setVisible(true);
		else 
			JOptionPane.showMessageDialog(gestionFichaTecnicaDO, "Debe seleccionar una Ficha Tecnica de Daños Ocacionados para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	public void showFichaTecnicaDO(){
		FichaTecnicaDO f = getSelectedFichaTecnicaDO();
		if (f != null)				
			MostrarFichaTecnicaDO.getMostrarFichaTecnicaDO(f).setVisible(true);
		else 
			JOptionPane.showMessageDialog(gestionFichaTecnicaDO, "Debes seleccionar una vivienda para mostrar.", "Aviso", JOptionPane.WARNING_MESSAGE);						
	}
	public void deleteFichaTecnicaDO(){
		FichaTecnicaDO f = getSelectedFichaTecnicaDO();
		if(f!=null){
			int confirmar = JOptionPane.showConfirmDialog(GestionFichaTecnicaDO.this,"¿Seguro que deseas eliminar esta FTDO?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);

			if (confirmar == JOptionPane.YES_OPTION) {
				try{
					oficina.deleteFichaTecnicaDO(f.getId());
					JOptionPane.showMessageDialog(gestionFichaTecnicaDO, "Ficha Tecnica de Daños Ocacionados  eliminada con exito.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					updtTableFichas(oficina.getFichas());
				}catch(Exception e){
					JOptionPane.showMessageDialog(gestionFichaTecnicaDO, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else 
			JOptionPane.showMessageDialog(null, "Debe seleccionar una Ficha Tecnica de Daños Ocacionados para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	public void regresar(){
		dispose();
		GestionOficinaTramites.getGestionOficinaTramites().setVisible(true);	
	}
}










