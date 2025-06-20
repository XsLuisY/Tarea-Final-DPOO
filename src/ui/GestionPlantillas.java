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
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

import clases.MICONS;
import clases.OficinaTramites;
import clases.Plantilla;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPlantillas extends JFrame {
	private OficinaTramites actualOficinaTramites;
	private MICONS micons;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tablePlantillas;
	private JPopupMenu popupMenu;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmMostrar;


	public GestionPlantillas(OficinaTramites actualOficinaTramites) {
		setTitle("Plantillas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		micons=MICONS.getMICONS();	
		this.actualOficinaTramites = actualOficinaTramites;
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getTablePlantillas(), getPopupMenu());

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
					GestionOficinaTramites g = new GestionOficinaTramites( );
					g.setVisible(true);					
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
			tablePlantillas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Dirección","Fecha Levantamiento", "ID", "Precio Total"
					}
					));
			tablePlantillas.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (e.getClickCount() == 2) 
						mostrarPlantilla();

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
	public void mostrarPlantilla(){
		int pos = tablePlantillas.getSelectedRow();
		Plantilla p = actualOficinaTramites.getPlantillas().get(pos);
		MostrarPlantilla m = new MostrarPlantilla (p);
		m.setVisible(true);
	}
}
