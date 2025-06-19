package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;

import java.awt.Scrollbar;

import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import clases.MICONS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionOficinaTramites extends JFrame {
	private MICONS micons;
	String[] consejosPopulares={"Prueba","Habana","Hola"};
	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JScrollPane scrollPane;
	private JList listOficinas;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;
	private JMenu mntmGestionar;
	private JMenuItem mntmMateriales;
	private JMenuItem mntmFtdos;
	private JMenuItem mntmPlantillas;

	public GestionOficinaTramites(MICONS micons) {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Oficinas de Tramites");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		this.micons=micons;
		setJMenuBar(getBarraSuperior());
		setContentPane(getContentPane());
		addPopup(getListOficinas(), getPopupMenu());
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
					Principal p = new Principal(micons);
					p.setVisible(true);
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
			scrollPane= new JScrollPane();
			scrollPane.setBounds(10, 11, 374, 225);
			scrollPane.setViewportView(getListOficinas());
		}
		return scrollPane;
	}
	public JList getListOficinas(){
		if(listOficinas==null){
			listOficinas = new JList(consejosPopulares);
			listOficinas.setForeground(Color.ORANGE);
			listOficinas.setBackground(Color.DARK_GRAY);
		}
		return listOficinas;
	}
	public JPopupMenu getPopupMenu(){
		if(popupMenu==null){
			popupMenu = new JPopupMenu();
			popupMenu.setForeground(Color.ORANGE);
			popupMenu.setBackground(Color.DARK_GRAY);
			popupMenu.add(getMenuItemAgregar());			
			popupMenu.add(getMenuItemModificar());
			popupMenu.add(getMenuItemEliminar());
			popupMenu.add(getMntmGestionar());
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
					CrearOficinaTramites c = new CrearOficinaTramites(micons);
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
					ModificarOficinaTramites c = new ModificarOficinaTramites(micons);
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
	public JMenu getMntmGestionar(){ 
		if(mntmGestionar==null){
			mntmGestionar= new JMenu("Gestionar");
			mntmGestionar.setBackground(Color.DARK_GRAY);
			mntmGestionar.setForeground(Color.ORANGE);
			mntmGestionar.add(getMntmMateriales());
			mntmGestionar.add(getMntmFtdos());
			mntmGestionar.add(getMntmPlantillas());
		}
		return mntmGestionar;
	}	
	public JMenuItem getMntmMateriales(){
		if(mntmMateriales==null){
			mntmMateriales = new JMenuItem("Materiales");
			mntmMateriales.setBackground(Color.DARK_GRAY);
			mntmMateriales.setForeground(Color.ORANGE);
			mntmMateriales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					GestionMateriales g= new GestionMateriales(micons);
					g.setVisible(true);
				}
			});
		}
		return mntmMateriales;
	}
	public JMenuItem getMntmFtdos(){
		if(mntmFtdos==null){
			mntmFtdos = new JMenuItem("FTDOs");
			mntmFtdos.setBackground(Color.DARK_GRAY);
			mntmFtdos.setForeground(Color.ORANGE);
			mntmFtdos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					GestionFichaTecnicaDO g =new GestionFichaTecnicaDO(micons);
					g.setVisible(true);
				}
			});
		}
		return mntmFtdos;
	}
	public JMenuItem getMntmPlantillas(){ 
		if(mntmPlantillas==null){
			mntmPlantillas = new JMenuItem("Plantillas");
			mntmPlantillas.setBackground(Color.DARK_GRAY);
			mntmPlantillas.setForeground(Color.ORANGE);
			mntmPlantillas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					GestionPlantillas g = new GestionPlantillas(micons);
					g.setVisible(true);
				}
			});
		}
		return mntmPlantillas;
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
