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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarFichaTecnicaDO extends JFrame {

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
					MostrarFichaTecnicaDO frame = new MostrarFichaTecnicaDO();
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
	public MostrarFichaTecnicaDO() {
		setType(Type.UTILITY);
		setTitle("Ficha T\u00E9cnica de Da\u00F1os Ocacionados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar");
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mntmRegresar.setForeground(Color.ORANGE);
		mntmRegresar.setBackground(Color.DARK_GRAY);
		menuBar.add(mntmRegresar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 282, 139);
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 292, 282, 139);
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
		
		JLabel lblAfectacinAlInmueble = new JLabel("Afectaci\u00F3n al Inmueble:");
		lblAfectacinAlInmueble.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfectacinAlInmueble.setBounds(10, 267, 292, 14);
		contentPane.add(lblAfectacinAlInmueble);
		
		JLabel lblAfectacinALa = new JLabel("Afectaci\u00F3n a la vivienda:");
		lblAfectacinALa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfectacinALa.setBounds(10, 91, 284, 15);
		contentPane.add(lblAfectacinALa);
		
		JLabel label = new JLabel("Fecha Levantamiento:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(10, 442, 282, 14);
		contentPane.add(label);
		
		JLabel lblId = new JLabel("ID: 4587-4658-4958-4612");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(0, 467, 159, 20);
		contentPane.add(lblId);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la vivienda asociada:");
		lblDatosDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeLa.setBounds(10, 11, 284, 14);
		contentPane.add(lblDatosDeLa);
		
		JLabel lblJefeDeNcleo = new JLabel("Jefe de n\u00FAcleo:");
		lblJefeDeNcleo.setBounds(10, 36, 282, 14);
		contentPane.add(lblJefeDeNcleo);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 61, 282, 14);
		contentPane.add(lblDireccin);
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
