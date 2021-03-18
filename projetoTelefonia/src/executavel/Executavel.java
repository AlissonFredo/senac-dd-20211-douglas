package executavel;

import exception.EnderecoNaoInformadoException;
import model.bo.ClienteBO;
import model.dao.ClienteDAO;
import model.entity.Cliente;
import model.entity.Endereco;

public class Executavel {

	public static void main(String[] args) {

		Endereco endereco1 = new Endereco("servidão nova era", "100", "Florianópolis", "SC", "88123456");
		/*
		 * EnderecoDAO enderecoDao = new EnderecoDAO();
		 * enderecoDao.cadastrar(endereco1); 
		 * endereco1.setLogradouro("av mauro ramos");
		 * enderecoDao.atualizar(endereco1); 
		 * enderecoDao.excluir(7); 
		 * Endereco enderecoConsultado = enderecoDao.consultarUmEndereco(8);
		 * System.out.println(enderecoConsultado);
		 *  List<Endereco> enderecos = enderecoDao.consultarTodosEnderecos(); 
		 *  for (Endereco enderecosBuscados : enderecos) { 
		 *  System.out.println(enderecosBuscados); 
		 *  }
		 */

		Cliente cliente1 = new Cliente("douglas", "12345678912", endereco1, null, true);
		//ClienteBO clienteBO = new ClienteBO();
		//try {
		//	clienteBO.salvar(cliente1);
		//} catch (EnderecoNaoInformadoException e) {
		//	System.out.println("Cliente sem endereço" + e.getMessage());
		//}
		ClienteDAO clienteDAO = new ClienteDAO();
		//Cliente enderecoConsultado = clienteDAO.consultarUmCliente(1);
		//System.out.println(enderecoConsultado);
		clienteDAO.excluir(1);
	}

}
