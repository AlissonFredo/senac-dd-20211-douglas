package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuPessoa = new JMenu("Pessoa");
		menuPessoa.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-user-24.png")));
		menuBar.add(menuPessoa);
		
		JMenuItem jMICadastrarPessoa = new JMenuItem("Cadastrar");
		jMICadastrarPessoa.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-add-user-male-24.png")));
		menuPessoa.add(jMICadastrarPessoa);
		
		JMenuItem jMIListarPessoa = new JMenuItem("Listar");
		jMIListarPessoa.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/icons8-find-user-male-24.png")));
		menuPessoa.add(jMIListarPessoa);
		
		JMenu menuVacina = new JMenu("Vacina");
		menuBar.add(menuVacina);
		
		JMenuItem jMICadastrarVacina = new JMenuItem("Cadastrar");
		menuVacina.add(jMICadastrarVacina);
		
		JMenuItem jMIListarVacinas = new JMenuItem("Listar");
		menuVacina.add(jMIListarVacinas);
		
		JMenu menuAplicaoDaVacina = new JMenu("Aplicação da vacina");
		menuBar.add(menuAplicaoDaVacina);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
