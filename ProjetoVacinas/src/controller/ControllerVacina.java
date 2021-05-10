package controller;

import java.util.ArrayList;

import model.bo.VacinaBO;
import model.dao.PessoaDAO;
import model.vo.PessoaVO;
import model.vo.VacinaVO;

public class ControllerVacina {

	VacinaBO vacinaBO = new VacinaBO();
	PessoaDAO pessoaDAO = new PessoaDAO();

	public String cadastrarVacinaController(VacinaVO vacinaVO) {
		String mensagemErro = "";
		if(vacinaVO == null) {
			mensagemErro = "Informar Pessoa!\n";
			
		}
		
		if(!mensagemErro.isEmpty()) {
		}
		
		
		return vacinaBO.cadastrarVacinaBO(vacinaVO);
	}

	public String excluirVacinaController(VacinaVO vacinaVO) {
		return vacinaBO.excluirVacinaBO(vacinaVO);
	}

	public ArrayList<VacinaVO> consultarTodasVacinas() {
		return vacinaBO.consultarTodosVacinaBO();
	}

	public PessoaVO consultarPesquisador(String cpf, String nome) {
		return pessoaDAO.consultarPesquisador(nome, cpf);
	}

}
