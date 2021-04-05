package controller;

import java.util.ArrayList;

import model.bo.VacinaBO;
import model.vo.VacinaVO;

public class ControllerVacina {

	VacinaBO vacinaBO = new VacinaBO();

	public String cadastrarVacinaController(VacinaVO vacinaVO) {
		return vacinaBO.cadastrarVacinaBO(vacinaVO);
	}

	public String excluirVacinaController(VacinaVO vacinaVO) {
		return vacinaBO.excluirVacinaBO(vacinaVO);
	}

	public ArrayList<VacinaVO> consultarTodasVacinas() {
		return vacinaBO.consultarTodosVacinaBO();
	}

}
