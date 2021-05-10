package controller;

import java.util.List;

import model.bo.PessoaBO;
import model.vo.PessoaVO;

public class ControllerPessoa {
	
	PessoaBO pessoaBO = new PessoaBO();

	public String cadastrarPessoaController(PessoaVO pessoaVO) {
		return pessoaBO.cadastrarPessoaBO(pessoaVO);
	}

	public List<PessoaVO> consultarTodosPessoaController() {
		return pessoaBO.consultarTodosPessoaBO();
	}

}
