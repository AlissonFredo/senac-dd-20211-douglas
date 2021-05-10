package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerPessoa;
import controller.ControllerVacina;
import model.vo.PessoaVO;
import model.vo.VacinaVO;

public class MenuCadastrarVacina extends JFrame {

	private static final int UMA_DOSE_VACINA = 1;
	private static final int DUAS_DOSE_VACINA = 2;

	private static final int FASE_UM_VACINA = 1;
	private static final int FASE_DOIS_VACINA = 2;
	private static final int FASE_TRES_VACINA = 3;

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPaisOrigem;
	private JTextField textFieldNomePesquisador;
	private JTextField textFieldCpf;
	private JComboBox comboBoxFase;
	private JComboBox comboBoxEstagioPesquisa;
	private JComboBox comboBoxDoses;
	private VacinaVO vacina;

	VacinaVO vacinaVO = new VacinaVO();
	ControllerVacina controllerVacina = new ControllerVacina();
	private JTextField textData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCadastrarVacina frame = new MenuCadastrarVacina();
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
	public MenuCadastrarVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);

		textFieldName = new JTextField();
		textFieldName.setBounds(190, 10, 268, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblPaisOrigem = new JLabel("Pais origem:");
		lblPaisOrigem.setBounds(12, 38, 98, 15);
		contentPane.add(lblPaisOrigem);

		textFieldPaisOrigem = new JTextField();
		textFieldPaisOrigem.setBounds(190, 36, 268, 19);
		contentPane.add(textFieldPaisOrigem);
		textFieldPaisOrigem.setColumns(10);

		JLabel lblEstagioPesquisa = new JLabel("Estagio pesquisa:");
		lblEstagioPesquisa.setBounds(12, 65, 144, 15);
		contentPane.add(lblEstagioPesquisa);

		JLabel lblDataInicio = new JLabel("Data inicio:");
		lblDataInicio.setBounds(12, 92, 98, 15);
		contentPane.add(lblDataInicio);

		JLabel lblPesquisador = new JLabel("Nome do pesquisador:");
		lblPesquisador.setBounds(12, 118, 171, 15);
		contentPane.add(lblPesquisador);

		textFieldNomePesquisador = new JTextField();
		textFieldNomePesquisador.setBounds(190, 116, 268, 19);
		contentPane.add(textFieldNomePesquisador);
		textFieldNomePesquisador.setColumns(10);

		JLabel lblFase = new JLabel("Fase:");
		lblFase.setBounds(12, 172, 70, 15);
		contentPane.add(lblFase);

		JLabel lblQuantidadesDeDoses = new JLabel("Quantidades de doses:");
		lblQuantidadesDeDoses.setBounds(12, 210, 171, 15);
		contentPane.add(lblQuantidadesDeDoses);

		comboBoxEstagioPesquisa = new JComboBox();
		comboBoxEstagioPesquisa.setBounds(190, 60, 268, 24);
		contentPane.add(comboBoxEstagioPesquisa);
		comboBoxEstagioPesquisa.addItem("<Selecione opção>");
		comboBoxEstagioPesquisa.addItem("Inicial");
		comboBoxEstagioPesquisa.addItem("Testes");
		comboBoxEstagioPesquisa.addItem("Aplicação em massa");

		comboBoxFase = new JComboBox();
		comboBoxFase.setBounds(190, 167, 268, 24);
		contentPane.add(comboBoxFase);
		comboBoxFase.addItem("<Selecione opção>");
		comboBoxFase.addItem("Fase 01");
		comboBoxFase.addItem("Fase 02");
		comboBoxFase.addItem("Fase 03");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarVacina();
			}
		});
		btnSalvar.setBounds(341, 254, 117, 25);
		contentPane.add(btnSalvar);

		JLabel lblCpfDoPesquisador = new JLabel("Cpf do pesquisador:");
		lblCpfDoPesquisador.setBounds(12, 145, 171, 15);
		contentPane.add(lblCpfDoPesquisador);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(190, 143, 268, 19);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		comboBoxDoses = new JComboBox();
		comboBoxDoses.setBounds(190, 205, 268, 24);
		contentPane.add(comboBoxDoses);
		comboBoxDoses.addItem("<selecione opção>");
		comboBoxDoses.addItem(1);
		comboBoxDoses.addItem(2);

		textData = new JTextField();
		textData.setBounds(190, 90, 268, 19);
		contentPane.add(textData);
		textData.setColumns(10);
	}

	protected void cadastrarVacina() {
		boolean validacao = true;

		if (comboBoxEstagioPesquisa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um estagio da pesquisa!");
			validacao = false;
		}
		if (comboBoxFase.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma fase!");
			validacao = false;
		}
		if (comboBoxDoses.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione a quantidade de doses!");
			validacao = false;
		}

		if (validacao) {
			vacinaVO.setNomeVacina(textFieldName.getText());
			vacinaVO.setPaisOrigem(textFieldPaisOrigem.getText());
			vacinaVO.setEstagioPesquisa(comboBoxEstagioPesquisa.getSelectedItem().toString());
			vacinaVO.setDataInicio(LocalDate.parse(textData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			PessoaVO pesquisador = new PessoaVO();
			pesquisador.setCpf(textFieldCpf.getText());
			pesquisador.setNome(textFieldNomePesquisador.getText());
			vacinaVO.setPesquisador(pesquisador);
			switch (comboBoxFase.getSelectedItem().toString()) {
			case "Fase 01": {
				vacinaVO.setFase(FASE_UM_VACINA);
				break;
			}
			case "Fase 02": {
				vacinaVO.setFase(FASE_DOIS_VACINA);
				break;
			}
			case "Fase 03": {
				vacinaVO.setFase(FASE_TRES_VACINA);
				break;
			}
			}

			switch (Integer.parseInt(comboBoxDoses.getSelectedItem().toString())) {
			case UMA_DOSE_VACINA: {
				vacinaVO.setQuantidadeDoses(UMA_DOSE_VACINA);
				break;
			}
			case DUAS_DOSE_VACINA: {
				vacinaVO.setQuantidadeDoses(DUAS_DOSE_VACINA);
				break;
			}
			}

			String mensagem = controllerVacina.cadastrarVacinaController(vacinaVO);
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
}
