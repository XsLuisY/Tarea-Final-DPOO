package reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.util.Map;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte_1 extends JFrame {

	private static Reporte_1 reporte_1;
	private Map<String, Double> porcentajes;
	
	private JPanel contentPane;
	private JLabel lblTipoI;
	private JLabel lblTipoII;
	private JLabel lblTipoIII;
	private JLabel lblTipoV;
	private JLabel lblTipov;
	private JTextPane txtpneste;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;

	//Singleton 
	public static Reporte_1 getReporte_1(Map<String, Double> porcentajes){
		if(reporte_1==null)
			reporte_1=new Reporte_1(porcentajes);
		return reporte_1;
	}
	
	//Constructor
	private Reporte_1(Map<String, Double> porcentajes) {
		setResizable(false);
		this.porcentajes=porcentajes;
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 340);
		setJMenuBar(getMenuBar_1());
		setContentPane(getContentPane());	
	}
	public JPanel getContentPane(){
		if(contentPane==null){
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.add(getLblTipoI());
			contentPane.add(getLblTipoII());
			contentPane.add(getLblTipoIII());
			contentPane.add(getLblTipoV());
			contentPane.add(getLblTipov());
			contentPane.add(getTxtpneste());
		}
		return contentPane;
	}
	public JLabel getLblTipoI() {
		if (lblTipoI == null) {
			lblTipoI = new JLabel("Tipo   I: "+porcentajes.get("Tipo I").toString()+"%");
			lblTipoI.setBounds(232, 11, 92, 14);
		}
		return lblTipoI;
	}
	public JLabel getLblTipoII() {
		if (lblTipoII == null) {
			lblTipoII = new JLabel("Tipo  II: "+porcentajes.get("Tipo II").toString()+"%");
			lblTipoII.setBounds(232, 63, 92, 14);
		}
		return lblTipoII;
	}
	public JLabel getLblTipoIII() {
		if (lblTipoIII == null) {
			lblTipoIII = new JLabel("Tipo III: "+porcentajes.get("Tipo III").toString()+"%");
			lblTipoIII.setBounds(232, 128, 92, 14);
		}
		return lblTipoIII;
	}
	public JLabel getLblTipoV() {
		if (lblTipoV == null) {
			lblTipoV = new JLabel("Tipo  IV:"+porcentajes.get("Tipo IV").toString()+"%");
			lblTipoV.setBounds(232, 201, 92, 14);
		}
		return lblTipoV;
	}
	public JLabel getLblTipov() {
		if (lblTipov == null) {
			lblTipov = new JLabel("Tipo   V:"+porcentajes.get("Tipo V").toString()+"%");
			lblTipov.setBounds(232, 262, 92, 14);
		}
		return lblTipov;
	}
	public JTextPane getTxtpneste() {
		if (txtpneste == null) {
			txtpneste = new JTextPane();
			txtpneste.setEditable(false);
			txtpneste.setForeground(Color.ORANGE);
			txtpneste.setBackground(Color.DARK_GRAY);
			txtpneste.setText(" Distribuci\u00F3n porcentual de los da\u00F1os estructurales en viviendas clasificadas como Tipos I a V seg\u00FAn su tipolog\u00EDa constructiva. \r\n \r\n  Cada categor\u00EDa representa un grupo de viviendas con caracter\u00EDsticas estructurales espec\u00EDficas, y el porcentaje indica el nivel relativo de afectaci\u00F3n que han sufrido, facilitando as\u00ED la evaluaci\u00F3n del impacto total y la planificaci\u00F3n de acciones correctivas.");
			txtpneste.setBounds(10, 11, 212, 265);
		}
		return txtpneste;
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
}
