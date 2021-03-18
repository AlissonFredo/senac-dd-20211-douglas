package model.bo;

import exception.EnderecoNaoInformadoException;
import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.entity.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();

	public Cliente salvar(Cliente cliente) throws EnderecoNaoInformadoException {
		if (cliente.getEndereco() == null) {
			throw new EnderecoNaoInformadoException("è obrigatorio informar endereço");
		}
		if (cliente.getEndereco().getId() == null) {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.cadastrar(cliente.getEndereco());
		}
		dao.cadastrar(cliente);
		return cliente;
	}
}
