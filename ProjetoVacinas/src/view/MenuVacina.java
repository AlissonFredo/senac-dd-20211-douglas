package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ControllerVacina;
import model.vo.PessoaVO;
import model.vo.VacinaVO;

public class MenuVacina {

	private static final int OPCAO_MENU_VACINA_CADASTRAR = 1;
	private static final int OPCAO_MENU_VACINA_CONSULTAR = 2;
	private static final int OPCAO_MENU_VACINA_ATUALIZAR = 3;
	private static final int OPCAO_MENU_VACINA_EXCLUIR = 4;
	private static final int VOLTAR = 5;

	private static final int OPCAO_MENU_CONSULTA_UMA_VACINA = 1;
	private static final int OPCAO_MENU_CONSULTA_TODAS_VACINAS = 2;
	private static final int OPCAO_MENU_CONSULTA_VACINA_VOLTAR = 3;

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void apresentarMenuVacina() {
		int opcao = this.apresentarOpcoesMenuVacina();
		while (opcao != VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_VACINA_CADASTRAR: {
				this.cadastrarVacina();
				break;
			}
			case OPCAO_MENU_VACINA_CONSULTAR: {
				this.consultarVacina();
				break;
			}
			case OPCAO_MENU_VACINA_ATUALIZAR: {
				JOptionPane.showMessageDialog(null, "FUNÇÃO INDISPONIVEL NO MOMENTO", "GERENCIADOR VACINAS",
						JOptionPane.ERROR_MESSAGE);
				this.apresentarMenuVacina();
			}
			case OPCAO_MENU_VACINA_EXCLUIR: {
				this.excluirVacina();
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "OPCÃO INVÁLIDA", "GERENCIADOR VACINAS", JOptionPane.ERROR_MESSAGE);
			}
			}
			this.apresentarMenuVacina();
		}
	}

	private void consultarVacina() {
		int opcao = this.apresentarOpcoesConsultaVacina();
		ControllerVacina controllerVacina = new ControllerVacina();
		while (opcao != OPCAO_MENU_CONSULTA_VACINA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTA_UMA_VACINA: {
				opcao = OPCAO_MENU_CONSULTA_VACINA_VOLTAR;
				JOptionPane.showMessageDialog(null, "FUNÇÃO INDISPONIVEL NO MOMENTO", "GERENCIADOR VACINAS",
						JOptionPane.ERROR_MESSAGE);
				break;
			}
			case OPCAO_MENU_CONSULTA_TODAS_VACINAS: {
				opcao = OPCAO_MENU_CONSULTA_VACINA_VOLTAR;
				String mensagem = "";
				ArrayList<VacinaVO> listaVacinaVO = controllerVacina.consultarTodasVacinas();
				if (listaVacinaVO.isEmpty()) {
					mensagem = "LISTA DE VACINAS NÃO LOCALIZADA!";
				}
				mensagem += "RESULTADO DA CONSULTA\n";
				for (int i = 0; i < listaVacinaVO.size(); i++) {
					mensagem += listaVacinaVO.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null, mensagem);
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "DIGITE UM NUMERO VALIDO!", "GERENCIADOR VACINAS",
						JOptionPane.ERROR_MESSAGE);
			}
			}
			opcao = this.apresentarOpcoesConsultaVacina();
		}
	}

	private int apresentarOpcoesConsultaVacina() {
		String mensagem = "OPÇÕES DE CONSULTA\n";
		mensagem += OPCAO_MENU_CONSULTA_UMA_VACINA + " - CONSULTAR UMA VACINA\n";
		mensagem += OPCAO_MENU_CONSULTA_TODAS_VACINAS + " - CONSULTAR TODAS VACINAS\n";
		mensagem += OPCAO_MENU_CONSULTA_VACINA_VOLTAR + " - VOLTAR\n";
		mensagem += "DIGITE SUA OPÇÃO:";
		String opcao = JOptionPane.showInputDialog(null, mensagem, "GERENCIADOR VACINAS",
				JOptionPane.INFORMATION_MESSAGE);
		int resultado = 0;
		try {
			resultado = Integer.parseInt(opcao);
		} catch (NumberFormatException e) {
			System.out.println("DIGITE UM NUMERO!" + e.getMessage());
		}
		return resultado;
	}

	private void excluirVacina() {
		VacinaVO vacinaVO = new VacinaVO();
		vacinaVO.setNomeVacina(JOptionPane.showInputDialog("DIGITE O NOME DA VACINA:"));
		vacinaVO.setPaisOrigem(JOptionPane.showInputDialog("DIGITE O PAIS DE ORIGEM:"));

		ControllerVacina controllerVacina = new ControllerVacina();
		String resultado = controllerVacina.excluirVacinaController(vacinaVO);
		JOptionPane.showMessageDialog(null, resultado);
	}

	private void cadastrarVacina() {
		VacinaVO vacinaVO = new VacinaVO();
		vacinaVO.setNomeVacina(JOptionPane.showInputDialog("DIGITE O NOME DA VACINA:"));
		vacinaVO.setPaisOrigem(JOptionPane.showInputDialog("DIGITE O PAIS DE ORIGEM:"));
		vacinaVO.setEstagioPesquisa((String) JOptionPane.showInputDialog(null, "SELECIONE O ESTAGIO DA VACINA:", null,
				JOptionPane.QUESTION_MESSAGE, null, new String[] { "INICIAL", "TESTA", "POPULAÇÃO" }, "INICIAL"));
		vacinaVO.setDataInicio(LocalDate.parse(JOptionPane.showInputDialog("DIGITE A DATA DE INICIO:"), dataFormatter));
		vacinaVO.setFase(Integer.parseInt(JOptionPane.showInputDialog("DIGITE A FASE:")));
		vacinaVO.setQuantidadeDoses(Integer.parseInt(JOptionPane.showInputDialog("DIGITE A QUANTIDADE DE DOSES:")));

		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO.setNome(JOptionPane.showInputDialog("DIGITE O NOME DO PESQUISADOR RESPONSAVEL:"));
		pessoaVO.setCpf(JOptionPane.showInputDialog("DIGITE O CPF DO PESQUISADOR RESPONSAVEL:"));

		vacinaVO.setPesquisador(pessoaVO);

		ControllerVacina controllerVacina = new ControllerVacina();
		String resultado = controllerVacina.cadastrarVacinaController(vacinaVO);
		JOptionPane.showConfirmDialog(null, resultado);
	}

	private int apresentarOpcoesMenuVacina() {
		String mensagem = OPCAO_MENU_VACINA_CADASTRAR + " - CADASTRAR VACINA\n";
		mensagem += OPCAO_MENU_VACINA_CONSULTAR + " - CONSULTAR VACINA\n";
		mensagem += OPCAO_MENU_VACINA_ATUALIZAR + " - ATUALIZAR VACINA\n";
		mensagem += OPCAO_MENU_VACINA_EXCLUIR + " - EXCLUIR VACINA\n";
		mensagem += VOLTAR + " - VOLTAR\nDIGITE A OPÇÃO:";
		String opcao = JOptionPane.showInputDialog(null, mensagem, "GERENCIADOR VACINAS",
				JOptionPane.INFORMATION_MESSAGE);
		int resultado = 0;
		try {
			resultado = Integer.parseInt(opcao);
		} catch (NumberFormatException e) {
			System.out.println("DIGITE UM NUMERO!" + e.getMessage());
		}
		return resultado;
	}

}
