package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import clases.Afectacion;
import clases.AfectacionPared;
import clases.AfectacionTecho;
import clases.Cubicacion;
import clases.FichaTecnicaDO;
import clases.MICONS;
import clases.Material;
import clases.Plantilla;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.UUID;

import javax.swing.JTextPane;

public class Buscar extends JFrame {
	private static Buscar buscar;
	private MICONS micons;

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;
	private JLabel lblIngreseElId;
	private JTextField textField;
	private JButton btnBuscar;
	private JTextPane txtpn;

public static Buscar getBuscar(){
	if(buscar==null)
		buscar=new Buscar();
	return buscar;
}
	private Buscar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 240);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIngreseElId());
		contentPane.add(getTextField());
		contentPane.add(getBtnBuscar());
		contentPane.add(getTxtpn());
		micons=MICONS.getMICONS();
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
					dispose();
				}
			});
		}
		return mntmRegresar;
	}
	public JLabel getLblIngreseElId() {
		if (lblIngreseElId == null) {
			lblIngreseElId = new JLabel("Ingrese el ID del objeto a buscar:");
			lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreseElId.setBounds(10, 11, 264, 22);
		}
		return lblIngreseElId;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(10, 38, 264, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	public JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

				}
			});
			btnBuscar.setForeground(Color.ORANGE);
			btnBuscar.setBackground(Color.DARK_GRAY);
			btnBuscar.setBounds(185, 143, 89, 23);
		}
		return btnBuscar;
	}

	//Metodos
	public void buscarID(){
		UUID id=UUID.fromString(getTextField().getText().trim());
		if(id!=null)			
			if(micons.getListaId().containsKey(id))
				switch(micons.getListaId().get(id).getClass().toString()){
				case "Material":mostrarMaterial((Material)micons.getListaId().get(id));
				break;
				case "Afectacion": mostrarAfectacion((Afectacion)micons.getListaId().get(id));
				break;
				case "Plantilla": MostrarPlantilla.getMostrarPlantilla((Plantilla)micons.getListaId().get(id));
				break;
				case "FichaTecnicaDO": MostrarFichaTecnicaDO.getMostrarFichaTecnicaDO((FichaTecnicaDO)micons.getListaId().get(id));
				break;
				/*TODO: Implementar
				case "Cubicacion": MostrarCubicacion.getMostrarCubicacion((Cubicacion)micons.getListaId().get(id));
				break;
				 */
				}
			else
				JOptionPane.showMessageDialog(buscar, "El id ingresado es incorrecto.", "Aviso", JOptionPane.WARNING_MESSAGE);
			else 
				JOptionPane.showMessageDialog(buscar, "Ingresado un id.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}

	public void mostrarMaterial(Material m){		
		getTxtpn().setText("\tMaterial\nNombre:"+m.getNombre()+"\nUnidad de Medida: "+m.getUnidadMedida()+"\nPrecio Unitario: "+m.getPrecioUnitario());
	}

	public void mostrarAfectacion(Afectacion a){	
		if(a instanceof AfectacionTecho)
			getTxtpn().setText("\tAfectacion\nTipo: Techo"+"nMaterial Predominante: "+a.getMaterialPredominante());
		else if(((AfectacionPared)a).getEsDeCarga())
			getTxtpn().setText("\tAfectacion\nTipo: Pared de carga"+"nMaterial Predominante: "+a.getMaterialPredominante());
		else
			getTxtpn().setText("\tAfectacion\nTipo: Pared"+"nMaterial Predominante: "+a.getMaterialPredominante());
	}


	public JTextPane getTxtpn() {
		if (txtpn == null) {
			txtpn = new JTextPane();
			txtpn.setEditable(false);
			txtpn.setBackground(Color.DARK_GRAY);
			txtpn.setForeground(Color.ORANGE);
			txtpn.setBounds(10, 69, 155, 97);
		}
		return txtpn;
	}
}
