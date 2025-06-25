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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

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
import clases.OficinaTramites;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GestionOficinaTramites extends JFrame {
	private static GestionOficinaTramites gestionOficinaTramites;
	private MICONS micons ;
	private ArrayList<OficinaTramites> oficinas;

	private JPanel contentPane;
	private JMenuBar barraSuperior;
	private JMenuItem mntmRegresar;
	private JScrollPane scrollPane;
	private JList<String> listOficinas;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAgregar;
	private JMenuItem menuItemModificar;
	private JMenuItem menuItemEliminar;
	private JMenu mntmGestionar;
	private JMenuItem mntmMateriales;
	private JMenuItem mntmFtdos;
	private JMenuItem mntmPlantillas;

	//Singleton
	public static GestionOficinaTramites getGestionOficinaTramites(){
		if(gestionOficinaTramites==null)
			gestionOficinaTramites= new GestionOficinaTramites();
		return gestionOficinaTramites;
	}

	//Constructor
	private GestionOficinaTramites() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Oficinas de Tramites");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		micons=MICONS.getMICONS();	
		oficinas = micons.getOficinaTramites();
		setJMenuBar(getBarraSuperior());
		setContentPane(getPanel());
		addPopup(getListOficinas(), getPopupMenu());
	}

	//Atributo
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
					Principal p = Principal.getPrincipal();
					p.setVisible(true);
				}
			});
		}
		return mntmRegresar;
	}
	public JPanel getPanel(){
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
	public JList<String> getListOficinas(){
		if(listOficinas==null){
			DefaultListModel<String> model = new DefaultListModel<String>();
			for(OficinaTramites o :  micons.getOficinaTramites())
				model.addElement(o.getConsejoPopular());
			listOficinas = new JList<String>(model);
			listOficinas.setForeground(Color.ORANGE);
			listOficinas.setBackground(Color.DARK_GRAY);
			listOficinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// Mostrar aviso si no hay oficinas
			if (model.isEmpty()) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JOptionPane.showMessageDialog(GestionOficinaTramites.this,
								"No hay oficinas registradas todavía.",
								"Información", JOptionPane.INFORMATION_MESSAGE);
					}
				});
			}
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
					CrearOficinaTramites c = CrearOficinaTramites.getCrearOficinaTramites(gestionOficinaTramites);
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
				public void actionPerformed(ActionEvent e) {
					OficinaTramites oficina = obtenerOficinaSeleccionada();
					if (oficina != null) {
						ModificarOficinaTramites m = ModificarOficinaTramites.getModificarOficinaTramites(oficina, gestionOficinaTramites);
						m.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(gestionOficinaTramites, "Debes seleccionar una oficina para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
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
					OficinaTramites oficina = obtenerOficinaSeleccionada();

					if (oficina != null) {
						String consejoPopular = oficina.getConsejoPopular();
						int confirmar = JOptionPane.showConfirmDialog(
								GestionOficinaTramites.this,"¿Seguro que deseas eliminar \"" + consejoPopular + "\"?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);

						if (confirmar == JOptionPane.YES_OPTION) {
							micons.getOficinaTramites().remove(oficina);
							actualizarListaOficinas();
						}
					} else {
						JOptionPane.showMessageDialog(
								GestionOficinaTramites.this,
								"Debes seleccionar una oficina para eliminar.",
								"Aviso",
								JOptionPane.WARNING_MESSAGE
								);
					}
				}
			});
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
					OficinaTramites oficina = obtenerOficinaSeleccionada();

					if (oficina != null) {
						dispose();
						GestionMateriales g= GestionMateriales.getGestionMateriales(oficina);
						g.setVisible(true);
					} else 
						JOptionPane.showMessageDialog(GestionOficinaTramites.this,"Debes seleccionar una oficina antes de continuar.","Aviso",JOptionPane.WARNING_MESSAGE);

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
					OficinaTramites oficina = obtenerOficinaSeleccionada();

					if (oficina != null) {
						dispose();			       
						GestionFichaTecnicaDO g =GestionFichaTecnicaDO.getGestionFichaTecnicaDO(oficina);
						g.setVisible(true);
					} else
						JOptionPane.showMessageDialog(GestionOficinaTramites.this,"Debes seleccionar una oficina antes de continuar.","Aviso",JOptionPane.WARNING_MESSAGE);

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
					OficinaTramites oficina = obtenerOficinaSeleccionada();

					if (oficina != null) {
						dispose();
						GestionPlantillas g = GestionPlantillas.getGestionPlantillas(oficina);
						g.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(
								GestionOficinaTramites.this,
								"Debes seleccionar una oficina antes de continuar.",
								"Aviso",
								JOptionPane.WARNING_MESSAGE
								);
					}
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
	//----------------------------------------------------------------------------------
	public void actualizarListaOficinas() {
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(OficinaTramites o :  micons.getOficinaTramites()) 
			model.addElement(o.getConsejoPopular());	  
		listOficinas.setModel(model);
	}
	private OficinaTramites obtenerOficinaSeleccionada() {
		OficinaTramites o=null;
		int pos = listOficinas.getSelectedIndex();	
		if (pos >= 0 && pos < oficinas.size()) {
			o= oficinas.get(pos);
		}
		return o;
	}
}

