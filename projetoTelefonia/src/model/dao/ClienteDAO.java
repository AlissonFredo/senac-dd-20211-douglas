package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;
import model.entity.Endereco;

public class ClienteDAO {

	public Cliente cadastrar(Cliente cliente) {
		String sql = "INSERT INTO cliente  (NOME, CPF, ID_ENDERECO, ATIVO) VALUES (?, ?, ?, ?)";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setInt(3, cliente.getEndereco().getId());
			stmt.setBoolean(4, false);
			stmt.executeUpdate();
			ResultSet chaveGerada = stmt.getGeneratedKeys();
			if (chaveGerada.next()) {
				cliente.setIdCliente(chaveGerada.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar cliente: \n" + e.getMessage());
		}
		return cliente;
	}

	public boolean atualizar(Cliente cliente) {
		boolean atualizado = false;
		String sql = "UPDATE cliente SET NOME = ?, CPF = ?, ID_ENDERECO = ?, ATIVO = ? WHERE ID_CLIENTE = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setInt(3, cliente.getEndereco().getId());
			stmt.setBoolean(4, cliente.isAtivo());
			stmt.setInt(5, cliente.getIdCliente());
			atualizado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar cliente: \n" + e.getMessage());
		}
		return atualizado;
	}

	public boolean excluir(Integer idCliente) {
		boolean excluir = false;
		String sql = "DELETE FROM cliente WHERE ID_CLIENTE = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setInt(1, idCliente);
			excluir = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente: \n" + e.getMessage());
		}
		return excluir;
	}

	public Cliente consultarUmCliente(Integer idCliente) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE ID_CLIENTE = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setInt(1, idCliente);
			ResultSet resultadoConsulta = stmt.executeQuery();
			if (resultadoConsulta.next()) {
				cliente = this.converterDoResultSet(resultadoConsulta);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente: \n" + e.getMessage());
		}
		return cliente;
	}

	public List<Cliente> consultarTodosClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			ResultSet resultadoConsulta = stmt.executeQuery();
			while (resultadoConsulta.next()) {
				Cliente cliente = this.converterDoResultSet(resultadoConsulta);
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente: \n" + e.getMessage());
		}
		return clientes;
	}

	private Cliente converterDoResultSet(ResultSet resultadoConsulta) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(resultadoConsulta.getInt("id_cliente"));
		cliente.setNome(resultadoConsulta.getString("nome"));
		cliente.setCpf(resultadoConsulta.getString("cpf"));
		cliente.setAtivo(resultadoConsulta.getBoolean("ativo"));

		int idEndereco = resultadoConsulta.getInt("id_endereco");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco enderecoCliente = enderecoDAO.consultarUmEndereco(idEndereco);
		cliente.setEndereco(enderecoCliente);
		return cliente;
	}
}
