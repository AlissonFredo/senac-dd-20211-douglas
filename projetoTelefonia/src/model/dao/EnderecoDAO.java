package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Endereco;

public class EnderecoDAO {

	public Endereco cadastrar(Endereco endereco) {
		String sql = "INSERT INTO endereco (CEP, LOGRADOURO, NUMERO, UF, CIDADE) VALUES (?, ?, ?, ?, ?)";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		try {
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getLogradouro());
			stmt.setString(3, endereco.getNumero());
			stmt.setString(4, endereco.getUf());
			stmt.setString(5, endereco.getCidade());
			stmt.executeUpdate();
			ResultSet chavesGeradas = stmt.getGeneratedKeys();
			if (chavesGeradas.next()) {
				endereco.setId(chavesGeradas.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar endereço: \n" + e.getMessage());
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão" + e.getMessage());
			}
		}
		return endereco;
	}

	public boolean atualizar(Endereco endereco) {
		boolean atualizado = false;
		String sql = "UPDATE endereco SET CEP = ?, LOGRADOURO = ?, NUMERO = ?, UF = ?, CIDADE = ? WHERE IDENDERECO = ?";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getLogradouro());
			stmt.setString(3, endereco.getNumero());
			stmt.setString(4, endereco.getUf());
			stmt.setString(5, endereco.getCidade());
			stmt.setInt(6, endereco.getId());
			atualizado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar endereço: \n" + e.getMessage());
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão" + e.getMessage());
			}
		}
		return atualizado;
	}

	public boolean excluir(Integer idEndereco) {
		boolean excluir = false;
		String sql = "DELETE FROM endereco WHERE IDENDERECO = ?";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setInt(1, idEndereco);
			excluir = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir endereço: \n" + e.getMessage());
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão" + e.getMessage());
			}
		}
		return excluir;
	}

	public Endereco consultarUmEndereco(Integer idEndereco) {
		Endereco endereco = null;
		String sql = "SELECT * FROM endereco WHERE IDENDERECO = ? ";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			stmt.setInt(1, idEndereco);
			ResultSet resultadoConsulta = stmt.executeQuery();
			if (resultadoConsulta.next()) {
				endereco = new Endereco();
				endereco.setId(resultadoConsulta.getInt("idEndereco"));
				endereco.setLogradouro(resultadoConsulta.getString("logradouro"));
				endereco.setNumero(resultadoConsulta.getString("numero"));
				endereco.setCidade(resultadoConsulta.getString("cidade"));
				endereco.setUf(resultadoConsulta.getString("uf"));
				endereco.setCep(resultadoConsulta.getString("cep"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereço: \n" + e.getMessage());
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão" + e.getMessage());
			}
		}
		return endereco;
	}

	public List<Endereco> consultarTodosEnderecos() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		String sql = "SELECT * FROM endereco";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultadoConsulta = stmt.executeQuery();
			while (resultadoConsulta.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(resultadoConsulta.getInt("idEndereco"));
				endereco.setLogradouro(resultadoConsulta.getString("logradouro"));
				endereco.setNumero(resultadoConsulta.getString("numero"));
				endereco.setCidade(resultadoConsulta.getString("cidade"));
				endereco.setUf(resultadoConsulta.getString("uf"));
				endereco.setCep(resultadoConsulta.getString("cep"));
				enderecos.add(endereco);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereço: \n" + e.getMessage());
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão" + e.getMessage());
			}
		}
		return enderecos;
	}
}
