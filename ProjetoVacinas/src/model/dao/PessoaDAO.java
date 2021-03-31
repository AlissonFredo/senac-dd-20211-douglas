package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.PessoaVO;

public class PessoaDAO {

	public PessoaVO cadastrarPessoaDAO(PessoaVO pessoaVO) {
		String query = "INSERT INTO pessoa (nome, sexo, cpf, tipo) VALUES (?, ?, ?, ?)";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query)) {
			stmt.setString(1, pessoaVO.getNome());
			stmt.setString(2, pessoaVO.getSexo());
			stmt.setString(3, pessoaVO.getCpf());
			stmt.setInt(4, pessoaVO.getTipo());
			stmt.executeUpdate();
			ResultSet chaveGerada = stmt.getGeneratedKeys();
			if (chaveGerada.next()) {
				pessoaVO.setIdPessoa(chaveGerada.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa! \n" + e.getMessage());
		}
		return pessoaVO;
	}

	public boolean atualizarPessoaDAO(PessoaVO pessoaVO) {
		boolean resultado = false;
		String query = "UPDATE pessoa SET nome = ?, sexo = ?, cpf = ?, tipo = ? WHERE id_pessoa = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setString(1, pessoaVO.getNome());
			stmt.setString(2, pessoaVO.getSexo());
			stmt.setString(3, pessoaVO.getCpf());
			stmt.setInt(4, pessoaVO.getTipo());
			stmt.setInt(5, pessoaVO.getIdPessoa());
			resultado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pessoa! \n" + e.getMessage());
		}
		return resultado;
	}

	public boolean excluirPessoaDAO(Integer idPessoa) {
		boolean resultado = false;
		String query = "DELETE FROM pessoa WHERE id_pessoa = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idPessoa);
			resultado = stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao excluir pessoa: \n" + e.getMessage());
		}
		return resultado;
	}

	public PessoaVO consultarUmaPessoaDAO(Integer idPessoa) {
		PessoaVO pessoaVO = null;
		String query = "SELECT * FROM pessoa WHERE id_pessoa = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idPessoa);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				pessoaVO = this.converterResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoa! \n" + e.getMessage());
		}
		return pessoaVO;
	}

	public ArrayList<PessoaVO> consultarTodosPessoaDAO() {
		ArrayList<PessoaVO> pessoasVO = new ArrayList<PessoaVO>();
		String query = "SELECT * FROM pessoa";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				PessoaVO pessoaVO = this.converterResultSet(resultado);
				pessoasVO.add(pessoaVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas pessoas! \n" + e.getMessage());
		}
		return pessoasVO;
	}

	private PessoaVO converterResultSet(ResultSet resultado) throws SQLException {
		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO.setIdPessoa(resultado.getInt("id_pessoa"));
		pessoaVO.setNome(resultado.getString("nome"));
		pessoaVO.setSexo(resultado.getString("sexo"));
		pessoaVO.setCpf(resultado.getString("cpf"));
		pessoaVO.setTipo(resultado.getInt("tipo"));
		return pessoaVO;
	}

}
