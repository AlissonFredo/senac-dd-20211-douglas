package executavel;

import java.util.List;

import exception.EnderecoNaoInformadoException;
import exception.numeroIndisponivelException;
import model.bo.ClienteBO;
import model.bo.TelefoneBO;
import model.dao.ClienteDAO;
import model.dao.TelefoneDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class Executavel {

	public static void main(String[] args) {

		TelefoneBO telefoneBO = new TelefoneBO();
		Telefone telefone = new Telefone("70", "20", "988448844", null, true);
		try {
			telefoneBO.cadastrar(telefone);
		} catch (numeroIndisponivelException e) {
			System.out.println(e.getMessage());
		}
		
		// System.out.println(telefone);

		// List<Telefone> telefones = telefoneDAO.consultarTodosTelefones();
		// for (Telefone telefonesBuscados : telefones) {
		// System.out.println(telefonesBuscados);
		// }

		//Telefone telefone = new Telefone();
		// telefone = telefoneDAO.consultarUmTelefone(1);
		// System.out.println(telefone);

		// telefone.setId(1);
		// telefone.setCodigoInternacional("55");
		// telefone.setDdd("48");
		// telefone.setNumero("988448844");
		// telefone.setIdCliente(null);
		// telefone.setMovel(false);
		// telefone.setAtivo(false);
		// telefoneDAO.atualizar(telefone);
		// System.out.println(telefone);

		// Endereco endereco1 = new Endereco("servidão nova era", "100",
		// "Florianópolis", "SC", "88123456");
		/*
		 * EnderecoDAO enderecoDao = new EnderecoDAO();
		 * enderecoDao.cadastrar(endereco1); endereco1.setLogradouro("av mauro ramos");
		 * enderecoDao.atualizar(endereco1); enderecoDao.excluir(7); Endereco
		 * enderecoConsultado = enderecoDao.consultarUmEndereco(8);
		 * System.out.println(enderecoConsultado); List<Endereco> enderecos =
		 * enderecoDao.consultarTodosEnderecos(); for (Endereco enderecosBuscados :
		 * enderecos) { System.out.println(enderecosBuscados); }
		 */

		// Cliente cliente1 = new Cliente("douglas", "12345678912", endereco1, null,
		// true);
		// ClienteBO clienteBO = new ClienteBO();
		// try {
		// clienteBO.salvar(cliente1);
		// } catch (EnderecoNaoInformadoException e) {
		// System.out.println("Cliente sem endereço" + e.getMessage());
		// }
		// ClienteDAO clienteDAO = new ClienteDAO();
		// Cliente enderecoConsultado = clienteDAO.consultarUmCliente(1);
		// System.out.println(enderecoConsultado);
		// clienteDAO.excluir(1);
	}

}
