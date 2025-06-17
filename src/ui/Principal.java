package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Principal extends JFrame {
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu gestion = new JMenu("Gesti\u00F3n");
		gestion.setBackground(Color.DARK_GRAY);
		gestion.setForeground(Color.ORANGE);
		menuBar.add(gestion);
		
		JMenuItem mnGestionarViviendas = new JMenuItem("Gestionar Viviendas");
		mnGestionarViviendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionViviendas().setVisible(true);			
			}
		});
		mnGestionarViviendas.setBackground(Color.DARK_GRAY);
		mnGestionarViviendas.setForeground(Color.ORANGE);
		gestion.add(mnGestionarViviendas);
		
		JMenuItem mntmGestionarOficinasDe = new JMenuItem("Gestionar Oficinas de Tr\u00E1mites");
		mntmGestionarOficinasDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionOficinaTramites().setVisible(true);
			}
		});
		mntmGestionarOficinasDe.setBackground(Color.DARK_GRAY);
		mntmGestionarOficinasDe.setForeground(Color.ORANGE);
		gestion.add(mntmGestionarOficinasDe);
		
		JMenu reportes = new JMenu("Reportes");
		reportes.setBackground(Color.DARK_GRAY);
		reportes.setHorizontalAlignment(SwingConstants.CENTER);
		reportes.setForeground(Color.ORANGE);
		menuBar.add(reportes);
		
		JMenuItem mntmDistribucinPorcentualDe = new JMenuItem("Distribuci\u00F3n porcentual de da\u00F1os en viviendas (Tipo I-IV)");
		mntmDistribucinPorcentualDe.setForeground(Color.ORANGE);
		mntmDistribucinPorcentualDe.setBackground(Color.DARK_GRAY);
		reportes.add(mntmDistribucinPorcentualDe);
		
		JMenuItem mntmViviendasConMayor = new JMenuItem("Viviendas con mayor n\u00FAmero de habitantes vulnerables");
		mntmViviendasConMayor.setForeground(Color.ORANGE);
		mntmViviendasConMayor.setBackground(Color.DARK_GRAY);
		reportes.add(mntmViviendasConMayor);
		
		JMenuItem mntmElementoAfectadoMs = new JMenuItem("Elemento afectado m\u00E1s frecuente (techo/pared)");
		mntmElementoAfectadoMs.setForeground(Color.ORANGE);
		mntmElementoAfectadoMs.setBackground(Color.DARK_GRAY);
		reportes.add(mntmElementoAfectadoMs);
		
		JMenuItem mntmCubicacionesConMayor = new JMenuItem("Cubicaciones con mayor costo por material");
		mntmCubicacionesConMayor.setForeground(Color.ORANGE);
		mntmCubicacionesConMayor.setBackground(Color.DARK_GRAY);
		reportes.add(mntmCubicacionesConMayor);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login().setVisible(true);
			}
		});
		mntmCerrarSesion.setBackground(Color.DARK_GRAY);
		mntmCerrarSesion.setForeground(Color.ORANGE);
		mntmCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHacerLevantamiento = new JButton("Hacer Levantamiento");
		btnHacerLevantamiento.setBackground(Color.DARK_GRAY);
		btnHacerLevantamiento.setForeground(Color.ORANGE);
		btnHacerLevantamiento.setBounds(364, 266, 170, 23);
		contentPane.add(btnHacerLevantamiento);
	}
}
