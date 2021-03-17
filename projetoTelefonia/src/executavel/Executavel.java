package executavel;

import java.util.List;

import model.dao.EnderecoDAO;
import model.entity.Endereco;

public class Executavel {

	public static void main(String[] args) {

		// Endereco endereco1 = new Endereco("servidão nova era", "100",
		// "Florianópolis", "SC", "88123456");
		EnderecoDAO enderecoDao = new EnderecoDAO();
		// enderecoDao.cadastrar(endereco1);
		// endereco1.setLogradouro("av mauro ramos");
		// enderecoDao.atualizar(endereco1);
		// enderecoDao.excluir(7);
		// Endereco enderecoConsultado = enderecoDao.consultarUmEndereco(8);
		// System.out.println(enderecoConsultado);
		List<Endereco> enderecos = enderecoDao.consultarTodosEnderecos();
		for (Endereco enderecosBuscados : enderecos) {
			System.out.println(enderecosBuscados);
		}
	}

}
