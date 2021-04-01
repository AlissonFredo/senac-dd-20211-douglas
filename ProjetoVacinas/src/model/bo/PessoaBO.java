package model.bo;

import java.util.ArrayList;

import model.dao.PessoaDAO;
import model.vo.PessoaVO;

public class PessoaBO {

	private PessoaDAO pessoaDAO = new PessoaDAO();

	public String cadastrarPessoaBO(PessoaVO pessoaVO) {
		String resultado = "";
		pessoaDAO.cadastrarDAO(pessoaVO);
		return resultado;
	}

	public String excluirPessoaBO(PessoaVO pessoaVO) {
		String resultado = "";
		pessoaDAO.excluirDAO(pessoaVO.getIdPessoa());
		return resultado;
	}

	public String atualizarPessoaBO(PessoaVO pessoaVO) {
		String resultado = "";
		pessoaDAO.atualizarDAO(pessoaVO);
		return resultado;
	}

	public PessoaVO consultarPessoaBO(PessoaVO pessoaVO) {
		return pessoaDAO.consultarUmDAO(pessoaVO.getIdPessoa());
	}

	public ArrayList<PessoaVO> consultarTodosPessoaBO() {
		return pessoaDAO.consultarTodosDAO();
	}

}
