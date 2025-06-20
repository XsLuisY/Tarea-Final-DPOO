package ui;

import java.awt.BorderLayout;
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

import javax.swing.ListSelectionModel;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

import clases.MICONS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionFichaTecnicaDO extends JFrame {
	private MICONS micons;
	private JMenuBar barraSuperior;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JMenuItem mntmRegresar;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemMostrar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;

	public GestionFichaTecnicaDO() {
		setTitle("Gesti\u00F3n de Fichas T\u00E9cnicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		micons=MICONS.getMICONS();	
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getTable(), getPopupMenu());

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
					GestionOficinaTramites g = new GestionOficinaTramites();
					g.setVisible(true);
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
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable(){
		if(table==null){
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setForeground(Color.ORANGE);
			table.setFillsViewportHeight(true);
			table.setBackground(Color.DARK_GRAY);
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Direcci\u00F3n", "Fecha Levantamiento","ID"
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
					dispose();
					CrearFichaTecnicaDO c =new CrearFichaTecnicaDO();
					c.setVisible(true);
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
					dispose();
					MostrarFichaTecnicaDO m = new MostrarFichaTecnicaDO( );
					m.setVisible(true);
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
					dispose();
					CrearFichaTecnicaDO c = new CrearFichaTecnicaDO();
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
}
