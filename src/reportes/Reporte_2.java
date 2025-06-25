package reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import clases.Vivienda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte_2 extends JFrame {

	private static Reporte_2 reporte_2;
	private ArrayList<Vivienda> viviendas;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;
	private JTextField txtViviendasConMayor;
	private JScrollPane scrollPane;
	private JTable tableViviendas;

	//Singleton 
	public static Reporte_2 getReporte_2(ArrayList<Vivienda> viviendas){
		if(reporte_2==null)
			reporte_2=new Reporte_2(viviendas);
		return reporte_2;
	}
	
	//Constructor
	private Reporte_2(ArrayList<Vivienda> viviendas) {
		setResizable(false);
		this.viviendas=viviendas;
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 265);
		setJMenuBar(getMenuBar_1());
		setContentPane(getContentPane());	
		actualizarTableViviendas();		
		
	}
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getTxtViviendasConMayor());
			contentPane.add(getScrollPane());
		}
		return contentPane;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setForeground(Color.ORANGE);
			menuBar.setBackground(Color.DARK_GRAY);
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
			mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return mntmRegresar;
	}
	public JTextField getTxtViviendasConMayor() {
		if (txtViviendasConMayor == null) {
			txtViviendasConMayor = new JTextField();
			txtViviendasConMayor.setHorizontalAlignment(SwingConstants.CENTER);
			txtViviendasConMayor.setBackground(Color.DARK_GRAY);
			txtViviendasConMayor.setForeground(Color.ORANGE);
			txtViviendasConMayor.setText("Viviendas con mayor concentraci\u00F3n de personas vulnerables");
			txtViviendasConMayor.setBounds(10, 11, 354, 20);
			txtViviendasConMayor.setColumns(10);
		}
		return txtViviendasConMayor;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 30, 354, 171);
			scrollPane.setRowHeaderView(getTableViviendas());
		}
		return scrollPane;
	}
	public JTable getTableViviendas() {
		if (tableViviendas == null) {
			tableViviendas = new JTable();
			tableViviendas.setModel(new DefaultTableModel(
					new Object[][] {},new String[] {"Jefe de Nucleo", "Direccion", "CI"}));
		}
		return tableViviendas;
	}

	//Metodos
	public void actualizarTableViviendas() {
		DefaultTableModel model = (DefaultTableModel) getTableViviendas().getModel();
		model.setRowCount(0);

		for(Vivienda v:  viviendas){
			Object[] newRow = new Object[]{v.getJefeNucleo().getNombre(),v.getDireccion(), v.getJefeNucleo().getCI()};
			model.addRow(newRow);			
		}
		getTableViviendas().setModel(model);
	}
}
