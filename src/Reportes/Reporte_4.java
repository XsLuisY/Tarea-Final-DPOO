package Reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import clases.Cubicacion;
import clases.MICONS;
import clases.MaterialACubicar;
import clases.OficinaTramites;

import javax.swing.JPopupMenu;

import ui.GestionOficinaTramites;
import ui.ModificarOficinaTramites;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Reporte_4 extends JFrame {

	private static Reporte_4 reporte_4;
	private Map<String, Integer> totalPorAfectacion;
	private MICONS micons;
	private ArrayList<Cubicacion> cubicaciones;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;
	private JTextPane txtCubicacionesConMayor;
	private JScrollPane scrollPaneCubicacion;
	private JScrollPane scrollPane;
	private JTable tableCubicacion;
	private JTextField txtCubicacion;
	private JScrollPane scrollPane_1;
	private JList list;
	private JPopupMenu popupMenu;
	private JMenuItem menuItem;

	//Singleton 
	public static Reporte_4 getReporte_4(ArrayList<Cubicacion> cubicaciones){
		if(reporte_4==null)
			reporte_4=new Reporte_4(cubicaciones);
		return reporte_4;
	}

	//Constructor
	private Reporte_4(ArrayList<Cubicacion> cubicaciones) {
		micons=MICONS.getMICONS();
		this.cubicaciones=cubicaciones;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 400);
		setJMenuBar(getMenuBar_1());
		setContentPane(getContentPane());
	}

	//Atributos 
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getTxtCubicacionesConMayor());
			contentPane.add(getScrollPaneCubicacion());
			contentPane.add(getTxtCubicacion());
			contentPane.add(getScrollPane_1());
		}
		return contentPane;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.DARK_GRAY);
			menuBar.setForeground(Color.ORANGE);
			menuBar.add(getMntmRegresar());
		}
		return menuBar;
	}
	public JMenuItem getMntmRegresar() {
		if (mntmRegresar == null) {
			mntmRegresar = new JMenuItem("Regresar");
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				}
			});
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
		}
		return mntmRegresar;
	}
	public JTextPane getTxtCubicacionesConMayor() {
		if (txtCubicacionesConMayor == null) {
			txtCubicacionesConMayor = new JTextPane();
			txtCubicacionesConMayor.setEditable(false);
			txtCubicacionesConMayor.setForeground(Color.ORANGE);
			txtCubicacionesConMayor.setBackground(Color.DARK_GRAY);
			txtCubicacionesConMayor.setText("   Cubicaciones con mayor costo por material:");
			txtCubicacionesConMayor.setBounds(10, 11, 455, 20);
		}
		return txtCubicacionesConMayor;
	}
	
	public JScrollPane getScrollPaneCubicacion(){
		if(scrollPaneCubicacion==null){
			scrollPaneCubicacion= new JScrollPane();
			scrollPaneCubicacion.setBounds(10, 174, 455, 152);
			scrollPaneCubicacion.setViewportView(getTableCubicacion());
		}
		return scrollPaneCubicacion;
	}
	public JTable getTableCubicacion() {
		if (tableCubicacion == null) {
			tableCubicacion = new JTable();
			tableCubicacion.setForeground(Color.ORANGE);
			tableCubicacion.setFillsViewportHeight(true);
			tableCubicacion.setBackground(Color.DARK_GRAY);
			tableCubicacion.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nombre", "u/medida", "Precio unitario", "Cantidad", "Precio Total"}));
		}
		return tableCubicacion;
	}
	public JTextField getTxtCubicacion() {
		if (txtCubicacion == null) {
			txtCubicacion = new JTextField();
			txtCubicacion.setEditable(false);
			txtCubicacion.setBackground(Color.DARK_GRAY);
			txtCubicacion.setForeground(Color.ORANGE);
			txtCubicacion.setText("Cubicacion: ");
			txtCubicacion.setBounds(10, 155, 455, 20);
			txtCubicacion.setColumns(10);
		}
		return txtCubicacion;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 31, 455, 113);
			scrollPane_1.setViewportView(getList());
		}
		return scrollPane_1;
	}
	public JList getList() {
		if (list == null) {
			DefaultListModel<String> model = new DefaultListModel<String>();
			for(Cubicacion c :  cubicaciones)
				model.addElement(c.getId().toString());
			list = new JList<String>(model);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			addPopup(list, getPopupMenu());
		}
		return list;
	}

	//Metodos
	private Cubicacion obtenerCubicacionSeleccionada() {
		Cubicacion c=null;
		int pos = list.getSelectedIndex();	
		if (pos >= 0 && pos < cubicaciones.size()) {
			c= cubicaciones.get(pos);
		}
		return c;
	}
	public void actualizarTableCubicacion(Cubicacion cubicacion) {
		DefaultTableModel model = (DefaultTableModel) getTableCubicacion().getModel();
		model.setRowCount(0);
		if(cubicacion!=null)
			for (int i = 0; i < cubicacion.getMateriales().size(); i++) {
				MaterialACubicar m = cubicacion.getMateriales().get(i);				
				String nombre=m.getMaterial().getNombre();
				String unidadMedida=m.getMaterial().getUnidadMedida();
				String precioUnitario=((Double)m.getMaterial().getPrecioUnitario()).toString();
				String cantidad=((Double)m.getCantidad()).toString();
				String precioTotal=((Double)m.calcularPrecioTotal()).toString();
				Object[] newRow = new Object[]{nombre, unidadMedida, precioUnitario, cantidad, precioTotal};
				model.addRow(newRow);			
			}
		getTableCubicacion().setModel(model);
	}
	private void addPopup(final JList<?> listComponent, final JPopupMenu popup) {
	    listComponent.addMouseListener(new MouseAdapter() {
	        private void showPopup(MouseEvent e) {
	            int index = listComponent.locationToIndex(e.getPoint());
	            if (index >= 0) {
	                listComponent.setSelectedIndex(index);
	                popup.show(e.getComponent(), e.getX(), e.getY());
	            }
	        }
	        @Override
	        public void mousePressed(MouseEvent e) {
	            if (e.isPopupTrigger()) {
	                showPopup(e);
	            }
	        }
	        @Override
	        public void mouseReleased(MouseEvent e) {
	            if (e.isPopupTrigger()) {
	                showPopup(e);
	            }
	        }
	    });
}
	public JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.setBackground(Color.DARK_GRAY);
			popupMenu.setForeground(Color.ORANGE);
			popupMenu.add(getMenuItem());
		}
		return popupMenu;
	}
	public JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("Mostrar");
			menuItem.setBackground(Color.DARK_GRAY);
			menuItem.setForeground(Color.ORANGE);
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cubicacion c = obtenerCubicacionSeleccionada();
					if (c != null) {
						actualizarTableCubicacion(c);	
						txtCubicacion.setText("Cubicacion: " + c.getId().toString());
					} else {
						JOptionPane.showMessageDialog(reporte_4, "Debes seleccionar una cubicacion para mostrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
		}
		return menuItem;
	}
}
