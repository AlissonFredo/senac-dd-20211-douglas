package model.bo;

import java.util.ArrayList;

import model.dao.PessoaDAO;
import model.dao.VacinaDAO;
import model.vo.PessoaVO;
import model.vo.VacinaVO;

public class VacinaBO {

	VacinaDAO vacinaDAO = new VacinaDAO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	PessoaVO pesquisador = new PessoaVO();

	public String cadastrarVacinaBO(VacinaVO vacinaVO) {

		pesquisador = pessoaDAO.consultarPesquisador(vacinaVO.getPesquisador().getNome(),
				vacinaVO.getPesquisador().getCpf());
		VacinaVO vacina = vacinaDAO.consultarVacinaPertencePais(vacinaVO);
		String resultado = "";

		if (pesquisador != null) {
			if (vacina == null) {
				vacinaDAO.cadastrarDAO(vacinaVO);
				resultado = "VACINA CADASTRADA COM SUCESSO!";
			} else {
				resultado = "erro ao cadastrar vacina";
			}
		} else {
			resultado = "pesquisador não cadastrado no banco de dados!";
		}
		return resultado;
	}

	public String excluirVacinaBO(VacinaVO vacinaVO) {
		VacinaVO vacina = vacinaDAO.consultarVacinaPertencePais(vacinaVO);
		String resultado = "";
		if (vacina != null) {
			vacinaDAO.excluirDAO(vacinaVO.getIdVacina());
			resultado = "VACINA EXCLUIDA COM SUCESSO!";
		} else {
			resultado = "FALHA AO EXCLUIR VACINA!";
		}
		return resultado;
	}

	public String atualizarVacinaBO(VacinaVO vacinaVO) {
		String resultado = "";
		vacinaDAO.atualizarDAO(vacinaVO);
		return resultado;
	}

	public VacinaVO consultarPessoaBO(VacinaVO vacinaVO) {
		return vacinaDAO.consultarUmDAO(vacinaVO.getIdVacina());
	}

	public ArrayList<VacinaVO> consultarTodosVacinaBO() {
		return vacinaDAO.consultarTodosDAO();
	}

}
