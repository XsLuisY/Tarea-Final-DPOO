package utils;

import interfaces.AsignableVivienda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import clases.FichaTecnicaDO;
import clases.MICONS;
import clases.Vivienda;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import ui.CrearFichaTecnicaDO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarViviendas extends JFrame {
	private static SeleccionarViviendas  seleccionarViviendas=null; 
	private FichaTecnicaDO ficha;
	private AsignableVivienda gestion;

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private MICONS micons;
	private ArrayList<Vivienda> viviendas;
	private JPopupMenu popupMenu;
	private JMenuItem mntmSeleccionar;

	//Singleton 
	public static SeleccionarViviendas getSeleccionarViviendas(AsignableVivienda gestion,  FichaTecnicaDO ficha){
		if(seleccionarViviendas==null
				||	seleccionarViviendas.gestion.equals(gestion) 
				||	seleccionarViviendas.ficha.equals(ficha))
			seleccionarViviendas= new SeleccionarViviendas(gestion,ficha);
		return seleccionarViviendas;
	}
	//Constructor
	public  SeleccionarViviendas(AsignableVivienda gestion,  FichaTecnicaDO ficha) {		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(getContentPane());	
		micons=MICONS.getMICONS();
		viviendas=micons.getViviendas();
		this.gestion=gestion;
		this.ficha=ficha;	
		actualizarTableViviendas();
	}
	
	//Atributos
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();	
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			contentPane.add(getScrollPane());
		}
		return contentPane ;
	}

	public JTable getTableViviendas(){
		if(table==null){
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setForeground(Color.ORANGE);
			table.setBackground(Color.DARK_GRAY);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(new DefaultTableModel(
					new Object[][] {},new String[] {"Jefe de Nucleo", "Direccion", "CI"}));
			addPopup(table, getPopupMenu());
		}
		return table;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 239);
			scrollPane.setViewportView(getTableViviendas());
		}
		return scrollPane;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmSeleccionar());
		}
		return popupMenu;
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
	private JMenuItem getMntmSeleccionar() {
		if (mntmSeleccionar == null) {
			mntmSeleccionar = new JMenuItem("Seleccionar");
			mntmSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					asignar();
				}
			});
		}
		return mntmSeleccionar;
	}


	//Metodos
	public Vivienda obtenerViviendaSeleccionada(){
		Vivienda v = null;
		int pos = getTableViviendas().getSelectedRow();
		if (pos >= 0 && pos < micons.getViviendas().size()) {
			v=micons.getViviendas().get(pos);
		}
		return v;
	}	
	public void actualizarTableViviendas() {
		DefaultTableModel model = (DefaultTableModel) getTableViviendas().getModel();
		model.setRowCount(0);

		for(Vivienda v:  viviendas){
			Object[] newRow = new Object[]{v.getJefeNucleo().getNombre(),v.getDireccion(), v.getJefeNucleo().getCI()};
			model.addRow(newRow);			
		}
		getTableViviendas().setModel(model);
	}

	public void asignar(){
		Vivienda v = obtenerViviendaSeleccionada();
		if (v != null) {
			gestion.setVivienda(v);	
			gestion.actualizarViviendaAsociada();
			dispose();
		} else 
			JOptionPane.showMessageDialog(seleccionarViviendas,"Debes seleccionar una vivienda antes de continuar.","Aviso",JOptionPane.WARNING_MESSAGE);


	}
}
