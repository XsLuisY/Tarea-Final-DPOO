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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionMateriales extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_2;
	private JMenuItem menuItem_3;
	private JMenuBar menuBar;
	private JMenuItem mntmRegresar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionMateriales frame = new GestionMateriales();
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
	public GestionMateriales() {
		setTitle("Materiales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.setBackground(Color.DARK_GRAY);
		mntmRegresar.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 364, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre", "u/medida", "Precio"
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
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CrearMaterial().setVisible(true);
			}
		});
		menuItem.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItem.setForeground(Color.ORANGE);
		menuItem.setBackground(Color.DARK_GRAY);
		popupMenu.add(menuItem);
		
		menuItem_2 = new JMenuItem("Modificar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new ModificarMaterial().setVisible(true);
			}
		});
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