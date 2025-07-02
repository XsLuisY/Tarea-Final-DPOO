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
import clases.Mueble;
import clases.OficinaTramites;
import clases.Plantilla;
import clases.Vivienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;

public class GestionPlantillas extends JFrame {

	private static GestionPlantillas gestionPlantillas;

	private OficinaTramites oficina;
	private MICONS micons;

	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tablePlantillas;
	private JPopupMenu popupMenu;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmMostrar;

	//Singleton
	public static GestionPlantillas getGestionPlantillas(OficinaTramites oficina){
		if(gestionPlantillas==null 
				|| !gestionPlantillas.oficina.equals(oficina))
			gestionPlantillas = new GestionPlantillas(oficina);
		return gestionPlantillas;
	}

	//Constructor
	private GestionPlantillas(OficinaTramites oficina) {
		setTitle("Plantillas de "+oficina.getConsejoPopular());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		micons=MICONS.getMICONS();	
		this.oficina = oficina;
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getTablePlantillas(), getPopupMenu());

		actualizarTablePlantillas();

	}

	//Atributos
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
	public JScrollPane getScrollPane(){
		if(scrollPane==null){
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 490, 215);
			scrollPane.setViewportView(getTablePlantillas());
		}
		return  scrollPane;
	}
	public JTable getTablePlantillas(){
		if(tablePlantillas==null){
			tablePlantillas = new JTable();
			tablePlantillas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePlantillas.setForeground(Color.ORANGE);
			tablePlantillas.setFillsViewportHeight(true);
			tablePlantillas.setBackground(Color.DARK_GRAY);
			tablePlantillas.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Dirección","Fecha Levantamiento", "ID", "Precio Total"}));
			tablePlantillas.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (e.getClickCount() == 2) 
						showPlantilla();

				}
			});

		}
		return tablePlantillas;
	}
	public JPopupMenu getPopupMenu(){	
		if(popupMenu==null){
			popupMenu = new JPopupMenu();
			popupMenu.setForeground(Color.ORANGE);
			popupMenu.setBackground(Color.DARK_GRAY);
			popupMenu.add(getMenuItemMostrar());
			popupMenu.add(getMenuItemEliminar());
		}
		return popupMenu;
	}		
	public JMenuItem getMenuItemMostrar(){
		if(mntmMostrar==null){
			mntmMostrar = new JMenuItem("Mostrar");
			mntmMostrar.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmMostrar.setForeground(Color.ORANGE);
			mntmMostrar.setBackground(Color.DARK_GRAY);
			mntmMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showPlantilla();
				}
			});
		}
		return mntmMostrar;
	}
	public JMenuItem getMenuItemEliminar(){
		if(mntmEliminar==null){
			mntmEliminar = new JMenuItem("Eliminar");
			mntmEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
			mntmEliminar.setForeground(Color.ORANGE);
			mntmEliminar.setBackground(Color.DARK_GRAY);
			mntmEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					delPlantilla();
				}
			});
		}
		return mntmEliminar;
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

	//----------------------------------------------------------------------------
	public void showPlantilla(){
		Plantilla p = obtenerPlantillaSeleccionada();
		if(p!=null)
			MostrarPlantilla.getMostrarPlantilla(p).setVisible(true);
		else 
			JOptionPane.showMessageDialog(gestionPlantillas, "Debe seleccionar una plantilla para mostrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);

	}
	public void delPlantilla(){
		Plantilla p = obtenerPlantillaSeleccionada();
		if(p!=null){
			int confirmar = JOptionPane.showConfirmDialog(gestionPlantillas,"¿Seguro que deseas eliminar esta FTDO?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);

			if (confirmar == JOptionPane.YES_OPTION) 
				try{
					JOptionPane.showMessageDialog(gestionPlantillas, "Plantilla  eliminada con exito.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					oficina.deletePlantilla(p.getId());
					actualizarTablePlantillas();
				}catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(gestionPlantillas, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
		}else 
			JOptionPane.showMessageDialog(gestionPlantillas, "Debe seleccionar una plantilla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);

	}

	public void actualizarTablePlantillas() {
		ArrayList<Plantilla> plantillas=oficina.getPlantillas();
		DefaultTableModel model = (DefaultTableModel) getTablePlantillas().getModel();
		model.setRowCount(0);
		if(plantillas!=null)
			//"Dirección","Fecha Levantamiento", "ID", "Precio Total"
			for (int i = 0; i < plantillas.size(); i++) {
				Plantilla p = plantillas.get(i);
				String direccion=p.getFichaTecnicaDO().getVivienda().getDireccion();
				java.util.Date fecha=p.getFichaTecnicaDO().getFechaLevantamiento();	
				String id=p.getId().toString();
				Object[] newRow = new Object[]{direccion, fecha.getDate()+"/"+fecha.getMonth()+"/"+fecha.getYear(),id, p.calcularPrecioTotal()};
				model.addRow(newRow);			
			}
		getTablePlantillas().setModel(model);
	}	


	public Plantilla obtenerPlantillaSeleccionada(){
		Plantilla p = null;
		int pos = getTablePlantillas().getSelectedRow();
		if (pos >= 0 && pos < oficina.getPlantillas().size()) {
			p=oficina.getPlantillas().get(pos);
		}
		return p;
	}



	public void regresar(){
		GestionOficinaTramites g = GestionOficinaTramites.getGestionOficinaTramites();
		g.setVisible(true);	
		dispose();
	}
}























