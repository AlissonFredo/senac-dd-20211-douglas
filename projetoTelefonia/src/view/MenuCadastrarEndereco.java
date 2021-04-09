package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerEndereco;
import model.entity.Endereco;

public class MenuCadastrarEndereco extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogradouro;
	private JTextField textCidade;
	private JTextField textUf;
	private JTextField textCep;
	private JTextField textNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCadastrarEndereco frame = new MenuCadastrarEndereco();
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
	public MenuCadastrarEndereco() {
		setTitle("Cadastro Endereço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(79, 112, 99, 15);
		contentPane.add(lblLogradouro);

		textLogradouro = new JTextField();
		textLogradouro.setBounds(196, 110, 114, 19);
		contentPane.add(textLogradouro);
		textLogradouro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(79, 140, 89, 15);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setBounds(196, 138, 114, 19);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(79, 169, 70, 15);
		contentPane.add(lblUf);

		textUf = new JTextField();
		textUf.setBounds(196, 167, 114, 19);
		contentPane.add(textUf);
		textUf.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(79, 85, 70, 15);
		contentPane.add(lblCep);

		textCep = new JTextField();
		textCep.setBounds(196, 83, 114, 19);
		contentPane.add(textCep);
		textCep.setColumns(10);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(79, 197, 70, 15);
		contentPane.add(lblNumero);

		textNumero = new JTextField();
		textNumero.setBounds(196, 195, 114, 19);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarEndereco();
			}

			private void cadastrarEndereco() {
				Endereco endereco = new Endereco();
				endereco.setCep(textCep.getText());
				endereco.setLogradouro(textLogradouro.getText());
				endereco.setCidade(textCidade.getText());
				endereco.setUf(textUf.getText());
				endereco.setNumero(textNumero.getText());

				ControllerEndereco controllerEndereco = new ControllerEndereco();
				String mensagem = controllerEndereco.cadastrarEnderecoController(endereco);

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnSalvar.setBounds(196, 226, 117, 25);
		contentPane.add(btnSalvar);
	}
}
