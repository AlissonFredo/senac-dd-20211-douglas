package model.bo;

import java.util.ArrayList;

import model.dao.VacinaDAO;
import model.vo.VacinaVO;

public class VacinaBO {

	private VacinaDAO vacinaDAO = new VacinaDAO();

	public String cadastrarVacinaBO(VacinaVO vacinaVO) {
		String resultado = "";
		vacinaDAO.cadastrarDAO(vacinaVO);
		return resultado;
	}

	public String excluirVacinaBO(VacinaVO vacinaVO) {
		String resultado = "";
		vacinaDAO.excluirDAO(vacinaVO.getIdVacina());
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
