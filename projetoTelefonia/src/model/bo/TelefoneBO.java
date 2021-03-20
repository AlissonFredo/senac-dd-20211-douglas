package model.bo;

import exception.numeroIndisponivelException;
import model.dao.TelefoneDAO;
import model.entity.Telefone;

public class TelefoneBO {

	TelefoneDAO telefoneDAO = new TelefoneDAO();

	public Telefone cadastrar(Telefone telefone) throws numeroIndisponivelException {

		if (telefoneDAO.numeroDisponivel(telefone)) {
			telefoneDAO.cadastrar(telefone);
		} else {
			throw new numeroIndisponivelException("Numero ja existe");
		}

		return telefone;
	}

	public String excluir(Integer idTelefone) {
		String mensagem = "";
		if (telefoneDAO.excluir(idTelefone)) {
			mensagem = "Telefone excluido com sucesso";
		} else {
			mensagem = "Erro ao excluir telefone";
		}
		return mensagem;
	}
}
