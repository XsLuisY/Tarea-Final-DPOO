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

public class GestionOficinaTramites extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionOficinaTramites frame = new GestionOficinaTramites();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public GestionOficinaTramites() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Oficinas de Tramites");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 270);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.setBackground(Color.DARK_GRAY);
		mntmRegresar.setForeground(Color.ORANGE);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 214, 195);
		contentPane.add(scrollPane);
		
		//PONER ARRAY CON NOMBRES DE LOSCONSEJOS POPULARES
		String[] consejosPopulares={"Prueba","Habana","Hola"};
		JList list = new JList(consejosPopulares);
		list.setForeground(Color.ORANGE);
		list.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(list);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(list, popupMenu);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		popupMenu.add(mntmAgregar);
		
		JMenu mntmGestionar = new JMenu("Gestionar");
		popupMenu.add(mntmGestionar);
		
		JMenuItem mntmMateriales = new JMenuItem("Materiales");
		mntmGestionar.add(mntmMateriales);
		
		JMenuItem mntmFtdos = new JMenuItem("FTDOs");
		mntmGestionar.add(mntmFtdos);
		
		JMenuItem mntmPlantillas = new JMenuItem("Plantillas");
		mntmGestionar.add(mntmPlantillas);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		popupMenu.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		popupMenu.add(mntmEliminar);
		
	
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
