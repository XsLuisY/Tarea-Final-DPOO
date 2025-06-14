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

public class CrearOficinaTramites extends JFrame {

	private JPanel contentPane;
	private JTextField consejoPopular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearOficinaTramites frame = new CrearOficinaTramites();
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
	public CrearOficinaTramites() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Creaci\u00F3n de Oficina de Tramites");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		consejoPopular = new JTextField();
		consejoPopular.setBounds(119, 74, 105, 20);
		contentPane.add(consejoPopular);
		consejoPopular.setColumns(10);
		
		JLabel lblConsejoPopular = new JLabel("Consejo Popular:");
		lblConsejoPopular.setBounds(119, 47, 105, 20);
		lblConsejoPopular.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblConsejoPopular);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(137, 237, 65, 23);
		contentPane.add(btnCrear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 48, 97, 212);
		contentPane.add(scrollPane);
		
		//PONER ARRAY CON NOMBRES DE LOSCONSEJOS POPULARES
		String[] consejosPopulares={"Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola","Prueba","Habana","Hola"};
		JList list = new JList(consejosPopulares);
		scrollPane.setViewportView(list);
		
		JLabel lblConsejosExistentes = new JLabel("Consejos Existentes");
		lblConsejosExistentes.setBounds(10, 22, 97, 30);
		contentPane.add(lblConsejosExistentes);
		
	
	}
}
