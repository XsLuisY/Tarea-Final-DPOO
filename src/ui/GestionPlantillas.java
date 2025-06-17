package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.ListSelectionModel;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;

public class GestionPlantillas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_2;
	private JMenuItem menuItem_3;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;
	private JMenuItem mntmMostrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPlantillas frame = new GestionPlantillas();
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
	public GestionPlantillas() {
		setTitle("Plantillas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBackground(Color.DARK_GRAY);
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
		scrollPane.setBounds(10, 11, 490, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Dirección","Fecha Levantamiento", "ID", "Precio Total"
				}
			));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.ORANGE);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);
		
		popupMenu = new JPopupMenu();
		popupMenu.setForeground(Color.ORANGE);
		popupMenu.setBackground(Color.DARK_GRAY);
		addPopup(table, popupMenu);
		
		menuItem = new JMenuItem("A\u00F1adir");
		menuItem.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem.setForeground(Color.ORANGE);
		menuItem.setBackground(Color.DARK_GRAY);
		popupMenu.add(menuItem);
		
		mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmMostrar.setForeground(Color.ORANGE);
		mntmMostrar.setBackground(Color.DARK_GRAY);
		popupMenu.add(mntmMostrar);
		
		menuItem_2 = new JMenuItem("Modificar");
		menuItem_2.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_2.setForeground(Color.ORANGE);
		menuItem_2.setBackground(Color.DARK_GRAY);
		popupMenu.add(menuItem_2);
		
		menuItem_3 = new JMenuItem("Eliminar");
		menuItem_3.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem_3.setForeground(Color.ORANGE);
		menuItem_3.setBackground(Color.DARK_GRAY);
		popupMenu.add(menuItem_3);
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