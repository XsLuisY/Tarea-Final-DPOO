package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UIAfectacionInmueble extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldInmueble;
	private JTextField textFieldCant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIAfectacionInmueble frame = new UIAfectacionInmueble();
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
	public UIAfectacionInmueble() {
		setTitle("Afectaci\u00F3n al Inmueble");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setToolTipText("");
		list.setBounds(10, 85, 264, 131);
		contentPane.add(list);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregar.setBounds(185, 42, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 227, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(185, 227, 89, 23);
		contentPane.add(btnEnviar);
		
		textFieldInmueble = new JTextField();
		textFieldInmueble.setBounds(115, 11, 159, 20);
		contentPane.add(textFieldInmueble);
		textFieldInmueble.setColumns(10);
		
		textFieldCant = new JTextField();
		textFieldCant.setBounds(115, 42, 20, 20);
		contentPane.add(textFieldCant);
		textFieldCant.setColumns(10);
		
		JLabel lblInmuebleAfectado = new JLabel("Inmueble afectado:");
		lblInmuebleAfectado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInmuebleAfectado.setBounds(10, 14, 95, 14);
		contentPane.add(lblInmuebleAfectado);
		
		JLabel lblCantidad = new JLabel("Cantidad afectada:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(10, 45, 95, 14);
		contentPane.add(lblCantidad);
	}
}
