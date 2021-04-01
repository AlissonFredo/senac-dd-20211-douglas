package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.PessoaVO;

public class PessoaDAO implements BaseDAO<PessoaVO> {

	public PessoaVO cadastrarDAO(PessoaVO objetoVO) {
		String query = "INSERT INTO pessoa (nome, sexo, cpf, tipo) VALUES (?, ?, ?, ?)";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query)) {
			stmt.setString(1, objetoVO.getNome());
			stmt.setString(2, objetoVO.getSexo());
			stmt.setString(3, objetoVO.getCpf());
			stmt.setInt(4, objetoVO.getTipo());
			stmt.executeUpdate();
			ResultSet chaveGerada = stmt.getGeneratedKeys();
			if (chaveGerada.next()) {
				objetoVO.setIdPessoa(chaveGerada.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa! \n" + e.getMessage());
		}
		return objetoVO;
	}

	public boolean atualizarDAO(PessoaVO objetoVO) {
		boolean resultado = false;
		String query = "UPDATE pessoa SET nome = ?, sexo = ?, cpf = ?, tipo = ? WHERE id_pessoa = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setString(1, objetoVO.getNome());
			stmt.setString(2, objetoVO.getSexo());
			stmt.setString(3, objetoVO.getCpf());
			stmt.setInt(4, objetoVO.getTipo());
			stmt.setInt(5, objetoVO.getIdPessoa());
			resultado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pessoa! \n" + e.getMessage());
		}
		return resultado;
	}

	public boolean excluirDAO(Integer idObjetoVO) {
		boolean resultado = false;
		String query = "DELETE FROM pessoa WHERE id_pessoa = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idObjetoVO);
			resultado = stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao excluir pessoa: \n" + e.getMessage());
		}
		return resultado;
	}

	public PessoaVO consultarUmDAO(Integer idObjetoVO) {
		PessoaVO pessoaVO = null;
		String query = "SELECT * FROM pessoa WHERE id_pessoa = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idObjetoVO);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				pessoaVO = this.converterResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoa! \n" + e.getMessage());
		}
		return pessoaVO;
	}

	public ArrayList<PessoaVO> consultarTodosDAO() {
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

	public PessoaVO converterResultSet(ResultSet resultado) throws SQLException {
		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO.setIdPessoa(resultado.getInt("id_pessoa"));
		pessoaVO.setNome(resultado.getString("nome"));
		pessoaVO.setSexo(resultado.getString("sexo"));
		pessoaVO.setCpf(resultado.getString("cpf"));
		pessoaVO.setTipo(resultado.getInt("tipo"));
		return pessoaVO;
	}

}
