package view;

import javax.swing.JOptionPane;

public class Menu {

	private static final int OPCAO_MENU_PESSOA = 1;
	private static final int OPCAO_MENU_VACINA = 2;
	private static final int OPCAO_MENU_SAIR = 3;

	public void apresentarMenu() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR) {
			switch (opcao) {
			case OPCAO_MENU_PESSOA: {
				System.out.println("menu pessoa");
				break;
			}
			case OPCAO_MENU_VACINA: {
				MenuVacina menuVacina = new MenuVacina();
				menuVacina.apresentarMenuVacina();
				break;
			}
			default: {
				String mensagem = "OPÇÃO INVÁLIDA!\n";
				mensagem += "DIGITE UM NUMERO VALIDO";
				JOptionPane.showMessageDialog(null, mensagem, "GERENCIADOR VACINAS", JOptionPane.ERROR_MESSAGE);
			}
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}

	private int apresentarOpcoesMenu() {
		String mensagem = OPCAO_MENU_PESSOA + " - MENU PESSOA\n";
		mensagem += OPCAO_MENU_VACINA + " - MENU VACINA\n";
		mensagem += OPCAO_MENU_SAIR + " - SAIR \nDIGITE A OPÇÃO:";
		String opcao = JOptionPane.showInputDialog(null, mensagem, "GERENCIADOR VACINAS", JOptionPane.INFORMATION_MESSAGE);
		int resultado = 0;
		try {
			resultado = Integer.parseInt(opcao);
		} catch (NumberFormatException e) {
			System.out.println("DIGITE UM NUMERO!" + e.getMessage());
		}
		return resultado;
	}

}
