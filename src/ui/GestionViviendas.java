package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class GestionViviendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmMostrar;
	private JMenuItem mntmAadir;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionViviendas frame = new GestionViviendas();
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
	public GestionViviendas() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.setBackground(Color.DARK_GRAY);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 364, 224);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(Color.ORANGE);
		table.setBackground(Color.DARK_GRAY);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Jefe de Núcleo", "Dirección", "ID"
			}
		));
		scrollPane.setViewportView(table);
		
		popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		popupMenu.setForeground(Color.ORANGE);
		popupMenu.setBackground(Color.DARK_GRAY);
		
		mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setBackground(Color.DARK_GRAY);
		mntmAadir.setForeground(Color.ORANGE);
		mntmAadir.setHorizontalAlignment(SwingConstants.RIGHT);
		popupMenu.add(mntmAadir);
		
		mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.setBackground(Color.DARK_GRAY);
		mntmMostrar.setForeground(Color.ORANGE);
		mntmMostrar.setHorizontalAlignment(SwingConstants.RIGHT);
		popupMenu.add(mntmMostrar);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setBackground(Color.DARK_GRAY);
		mntmModificar.setForeground(Color.ORANGE);
		mntmModificar.setHorizontalAlignment(SwingConstants.RIGHT);
		popupMenu.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setBackground(Color.DARK_GRAY);
		mntmEliminar.setForeground(Color.ORANGE);
		mntmEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
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
