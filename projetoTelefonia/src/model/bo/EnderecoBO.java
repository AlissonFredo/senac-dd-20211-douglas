package model.bo;

import model.dao.EnderecoDAO;
import model.entity.Endereco;

public class EnderecoBO {

	EnderecoDAO enderecoDAO = new EnderecoDAO();

	public String cadastrarEnderecoBO(Endereco endereco) {
		String resultado = "Erro ao cadastrar Endereco!";
		Endereco enderecoCadastrado = enderecoDAO.cadastrar(endereco);
		if (enderecoCadastrado.getId() != null) {
			resultado = "Endereco cadastrado com sucesso";
		}
		return resultado;
	}

}
