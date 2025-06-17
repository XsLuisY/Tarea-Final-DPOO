package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class ModificarFichaTecnicaDO extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarFichaTecnicaDO frame = new ModificarFichaTecnicaDO();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarFichaTecnicaDO() {
		setType(Type.UTILITY);
		setTitle("Ficha T\u00E9cnica de Da\u00F1os Ocacionados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.setBackground(Color.DARK_GRAY);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 282, 139);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "Material Predominante"
			}
		));
		table_2.setFillsViewportHeight(true);
		table_2.setForeground(Color.ORANGE);
		table_2.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table_2);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table_2, popupMenu);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmAgregar.setBackground(Color.DARK_GRAY);
		mntmAgregar.setForeground(Color.ORANGE);
		popupMenu.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmModificar.setBackground(Color.DARK_GRAY);
		mntmModificar.setForeground(Color.ORANGE);
		popupMenu.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmEliminar.setBackground(Color.DARK_GRAY);
		mntmEliminar.setForeground(Color.ORANGE);
		popupMenu.add(mntmEliminar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 212, 282, 139);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mueble", "Cantidad"
			}
		));
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(Color.ORANGE);
		table_1.setBackground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(table_1);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(table_1, popupMenu_1);
		
		JMenuItem mntmAgregar_1 = new JMenuItem("Agregar");
		mntmAgregar_1.setBackground(Color.DARK_GRAY);
		mntmAgregar_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmAgregar_1.setForeground(Color.ORANGE);
		popupMenu_1.add(mntmAgregar_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mntmModificar_1.setBackground(Color.DARK_GRAY);
		mntmModificar_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmModificar_1.setForeground(Color.ORANGE);
		popupMenu_1.add(mntmModificar_1);
		
		JMenuItem mntmEliminar_1 = new JMenuItem("Eliminar");
		mntmEliminar_1.setBackground(Color.DARK_GRAY);
		mntmEliminar_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmEliminar_1.setForeground(Color.ORANGE);
		popupMenu_1.add(mntmEliminar_1);
		
		JLabel lblAfectacinAlInmueble = new JLabel("Afectaci\u00F3n al Inmueble:");
		lblAfectacinAlInmueble.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfectacinAlInmueble.setBounds(10, 187, 292, 14);
		contentPane.add(lblAfectacinAlInmueble);
		
		JLabel lblAfectacinALa = new JLabel("Afectaci\u00F3n a la vivienda:");
		lblAfectacinALa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfectacinALa.setBounds(10, 11, 284, 15);
		contentPane.add(lblAfectacinALa);
		
		JLabel label = new JLabel("Fecha Levantamiento:");
		label.setBounds(10, 365, 133, 14);
		contentPane.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(142, 362, 40, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(192, 362, 40, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(242, 362, 50, 20);
		contentPane.add(spinner_2);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.ORANGE);
		btnModificar.setBackground(Color.DARK_GRAY);
		btnModificar.setBounds(203, 403, 89, 23);
		contentPane.add(btnModificar);
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
