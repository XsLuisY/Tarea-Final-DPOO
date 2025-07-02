package ui;

import interfaces.Identificable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import clases.Afectacion;
import clases.AfectacionPared;
import clases.AfectacionTecho;
import clases.Cubicacion;
import clases.FichaTecnicaDO;
import clases.MICONS;
import clases.Material;
import clases.OficinaTramites;
import clases.Plantilla;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.UUID;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Buscar extends JFrame {

	private static Buscar buscar;
	private MICONS micons;

	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;	
	private JPanel contentPane;
	private JLabel lblIngreseElId;	
	private JTextField textField;	
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JList listID;
	private JTextPane textPane;

	//Singleton
	public static Buscar getBuscar(){
		if(buscar==null)
			buscar=new Buscar();
		return buscar;
	}

	//Constructor
	private Buscar() {
		micons=MICONS.getMICONS();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 500);
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
			contentPane.add(getLblIngreseElId());
			contentPane.add(getTextField());
			contentPane.add(getBtnBuscar());
			contentPane.add(getScrollPane());
			contentPane.add(getTextPane());
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
			mntmRegresar.setBackground(Color.DARK_GRAY);
			mntmRegresar.setForeground(Color.ORANGE);
			mntmRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					regresar();
				}
			});
		}
		return mntmRegresar;
	}
	public JLabel getLblIngreseElId() {
		if (lblIngreseElId == null) {
			lblIngreseElId = new JLabel("Ingrese el ID del objeto a buscar:");
			lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreseElId.setBounds(10, 11, 302, 22);
		}
		return lblIngreseElId;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(10, 38, 302, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	

	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setForeground(Color.ORANGE);
			textPane.setBackground(Color.DARK_GRAY);
			textPane.setBounds(10, 69, 302, 90);
		}
		return textPane;
	}
	
	public JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buscarID();				
				}
			});
			btnBuscar.setForeground(Color.ORANGE);
			btnBuscar.setBackground(Color.DARK_GRAY);
			btnBuscar.setBounds(112, 403, 89, 23);
		}
		return btnBuscar;
	}


	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 170, 302, 222);
			scrollPane.setViewportView(getListID());
		}
		return scrollPane;
	}
	public JList getListID() {

		if(listID==null){
			DefaultListModel<String> model = new DefaultListModel<String>();
			for(UUID id:  micons.getListaId().keySet())
				model.addElement(id.toString());
			listID = new JList<String>(model);
			listID.setForeground(Color.ORANGE);
			listID.setBackground(Color.DARK_GRAY);
			listID.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			if (model.isEmpty()) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JOptionPane.showMessageDialog(buscar,
								"No hay objetos registrados todavia.",
								"Información", JOptionPane.INFORMATION_MESSAGE);
					}
				});
			}
		}
		return listID;
	}

	//Metodos
	public void regresar(){
		dispose();
		limpiarCampos();
	}
	public void buscarID(){
		if(getTextField().getText().isEmpty())
			JOptionPane.showMessageDialog(buscar, "Debes ingresar un ID para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
		else{
			try{
				UUID id=UUID.fromString(getTextField().getText().trim());			
				Identificable doc = micons.getListaId().get(id);

				if(doc instanceof Material)
					mostrarMaterial((Material)micons.getListaId().get(id));
				else if(doc instanceof Afectacion)
					mostrarAfectacion((Afectacion)micons.getListaId().get(id));
				else if(doc instanceof Plantilla)
					MostrarPlantilla.getMostrarPlantilla((Plantilla)micons.getListaId().get(id)).setVisible(true);
				else if(doc instanceof FichaTecnicaDO)
					MostrarFichaTecnicaDO.getMostrarFichaTecnicaDO((FichaTecnicaDO)micons.getListaId().get(id)).setVisible(true);
				else if(doc instanceof Cubicacion)
					MostrarCubicacion.getMostrarCubicacion((Cubicacion)micons.getListaId().get(id)).setVisible(true);
				else JOptionPane.showMessageDialog(buscar, "El ID ingresado no esta registrado.", "Aviso", JOptionPane.WARNING_MESSAGE);		
			}catch(IllegalArgumentException e){
				 JOptionPane.showMessageDialog(buscar, "El ID ingresado no tiene el formato correcto de UUID.","Error de formato", JOptionPane.ERROR_MESSAGE);		
			}
		}
	}
	public void mostrarMaterial(Material m){		
		getTextPane().setText("\t   Material\n   Nombre:"+m.getNombre()+"\n   Unidad de Medida: "+m.getUnidadMedida()+"\n\tPrecio Unitario: "+m.getPrecioUnitario());
	}
	public void mostrarAfectacion(Afectacion a){	
		if(a instanceof AfectacionTecho)
			getTextPane().setText("\t   Afectacion\nTipo: Techo"+"\n   Material Predominante: "+a.getMaterialPredominante());
		else if(((AfectacionPared)a).getEsDeCarga())
			getTextPane().setText("\t   Afectacion\nTipo: Pared de carga"+"\n   Material Predominante: "+a.getMaterialPredominante());
		else
			getTextPane().setText("\t   Afectacion\nTipo: Pared"+"\n   Material Predominante: "+a.getMaterialPredominante());
	}

	private void limpiarCampos() {
		getTextField().setText("");
		getTextPane().setText("");
	}


	
	
	
	
	
}
