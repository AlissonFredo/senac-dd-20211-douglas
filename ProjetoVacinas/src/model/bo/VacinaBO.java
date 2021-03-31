package model.bo;

import java.util.ArrayList;

import model.dao.VacinaDAO;
import model.vo.VacinaVO;

public class VacinaBO {

	private VacinaDAO vacinaDAO = new VacinaDAO();

	public String cadastrarVacinaBO(VacinaVO vacinaVO) {
		String resultado = "";
		vacinaDAO.cadastrarVacinaDAO(vacinaVO);
		return resultado;
	}

	public String excluirVacinaBO(VacinaVO vacinaVO) {
		String resultado = "";
		vacinaDAO.excluirVacinaDAO(vacinaVO.getIdVacina());
		return resultado;
	}

	public String atualizarVacinaBO(VacinaVO vacinaVO) {
		String resultado = "";
		vacinaDAO.atualizarVacinaDAO(vacinaVO);
		return resultado;
	}

	public VacinaVO consultarPessoaBO(VacinaVO vacinaVO) {
		return vacinaDAO.consultarUmaVacinaDAO(vacinaVO.getIdVacina());
	}

	public ArrayList<VacinaVO> consultarTodosVacinaBO() {
		return vacinaDAO.consultarTodosVacinaDAO();
	}

}
