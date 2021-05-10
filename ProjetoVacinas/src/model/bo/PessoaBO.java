package model.bo;

import java.util.ArrayList;

import model.dao.PessoaDAO;
import model.vo.PessoaVO;

public class PessoaBO {

	PessoaDAO pessoaDAO = new PessoaDAO();
	PessoaVO pessoaVO = new PessoaVO();

	public String cadastrarPessoaBO(PessoaVO pessoaVO) {
		String resultado = "Erro ao cadastrar pessoa!";
		if(!pessoaDAO.consultarPessoaCpf(pessoaVO.getCpf())) {
			pessoaVO = pessoaDAO.cadastrarDAO(pessoaVO);
			if(pessoaVO != null) {
				resultado = "Pesssoa cadastrada com sucesso!";
			}
		}else {
			resultado = "Pessoa ja existe no banco de dados!";
		}
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
