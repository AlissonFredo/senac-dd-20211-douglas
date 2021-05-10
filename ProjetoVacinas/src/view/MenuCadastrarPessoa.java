package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerPessoa;
import model.vo.PessoaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class MenuCadastrarPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textDataNasc;

	ControllerPessoa controllerPessoa = new ControllerPessoa();
	PessoaVO pessoaVO = new PessoaVO();
	private JComboBox comboBoxTipoPessoa;
	private JComboBox comboBoxSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCadastrarPessoa frame = new MenuCadastrarPessoa();
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
	public MenuCadastrarPessoa() {
		setTitle("Cadastro Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 40, 70, 15);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(114, 38, 237, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(26, 67, 70, 15);
		contentPane.add(lblSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(114, 62, 168, 20);
		contentPane.add(comboBoxSexo);
		comboBoxSexo.addItem("<selecione opção>");
		comboBoxSexo.addItem("Masculino");
		comboBoxSexo.addItem("Feminino");

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(26, 94, 70, 15);
		contentPane.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setBounds(114, 92, 114, 19);
		contentPane.add(textCpf);
		textCpf.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data nasc:");
		lblDataNasc.setBounds(26, 121, 83, 15);
		contentPane.add(lblDataNasc);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(114, 119, 114, 19);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(26, 148, 70, 15);
		contentPane.add(lblTipo);

		comboBoxTipoPessoa = new JComboBox();
		comboBoxTipoPessoa.setBounds(114, 146, 168, 19);
		contentPane.add(comboBoxTipoPessoa);
		comboBoxTipoPessoa.addItem("<selecione opção>");
		comboBoxTipoPessoa.addItem("Pesquisador");
		comboBoxTipoPessoa.addItem("Não pesquisador");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPessoa();
			}
		});
		btnSalvar.setBounds(321, 169, 117, 25);
		contentPane.add(btnSalvar);
	}

	protected void cadastrarPessoa() {
		boolean validacao = true;
		String mensagem = "";
		if(comboBoxSexo.getSelectedIndex() == 0) {
			mensagem += "\nSelecione o sexo!";
			validacao = false;
		}
		if(comboBoxTipoPessoa.getSelectedIndex() == 0) {
			mensagem += "\nSelecione o tipo pessoa!";
			validacao = false;
		}
		
		if(validacao) {
			pessoaVO.setNome(textNome.getText());
			pessoaVO.setSexo(comboBoxSexo.getSelectedItem().toString());
			pessoaVO.setCpf(textCpf.getText());
			pessoaVO.setDataNacimento(LocalDate.parse(textDataNasc.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			
			switch (comboBoxTipoPessoa.getSelectedItem().toString()) {
			case "Pesquisador": {
				pessoaVO.setTipo(1);
				break;
			}
			case "Não pesquisador": {
				pessoaVO.setTipo(2);
				break;
			}
			}
			String resultado = controllerPessoa.cadastrarPessoaController(pessoaVO);
			JOptionPane.showMessageDialog(null, resultado);
		}
		
	}
}
