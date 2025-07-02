package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cubicacion;
import clases.MaterialACubicar;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarCubicacion extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static MostrarCubicacion mostrarCubicacion=null;
	private Cubicacion cubicacion;

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField label;
	private JTable tableCubicacion;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;

	//Singleton
	public static MostrarCubicacion getMostrarCubicacion(Cubicacion cubicacion){
		if(mostrarCubicacion==null
				|| !mostrarCubicacion.cubicacion.equals(cubicacion))
			mostrarCubicacion= new MostrarCubicacion(cubicacion);
		return mostrarCubicacion;
	}

	//Constructor
	private MostrarCubicacion(Cubicacion cubicacion) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 270);
		this.cubicacion=cubicacion;
		setJMenuBar(getMenuBar_1());
		setContentPane(getContentPane());
		actualizarTableCubicacion(cubicacion);

	}

	//Atributos
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getScrollPane());
			contentPane.add(getLabel());
		}
		return contentPane;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 34, 490, 165);
			scrollPane.setViewportView(getTableCubicacion());
		}
		return scrollPane;
	}
	public JTextField getLabel() {
		if (label == null) {
			label = new JTextField("Cubicaci\u00F3n: "+cubicacion.getId().toString());
			label.setForeground(Color.ORANGE);
			label.setBackground(Color.DARK_GRAY);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(10, 11, 490, 24);
		}
		return label;
	}
	public JTable getTableCubicacion() {
		if (tableCubicacion == null) {
			tableCubicacion = new JTable();
			tableCubicacion.setBackground(Color.DARK_GRAY);
			tableCubicacion.setForeground(Color.ORANGE);
			tableCubicacion.setFillsViewportHeight(true);
			tableCubicacion.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nombre", "u/medida", "Precio unitario", "Cantidad", "Precio Total"}));
		}
		return tableCubicacion;
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
				regresar();
				}
			});
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
		}
		return mntmRegresar;
	}
	
	//Metodos

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
	
	public void regresar(){
		dispose();
	}

}











