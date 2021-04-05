package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.PessoaVO;
import model.vo.VacinaVO;

public class VacinaDAO implements BaseDAO<VacinaVO> {

	public VacinaVO cadastrarDAO(VacinaVO objetoVO) {
		String query = "INSERT INTO vacina (nome, pais_origem, estagio_vacina, data_inicio_pesquisa, id_pesquisador_responsavel, fase, quantidade_doses) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query)) {
			stmt.setString(1, objetoVO.getNomeVacina().toUpperCase());
			stmt.setString(2, objetoVO.getPaisOrigem().toUpperCase());
			stmt.setString(3, objetoVO.getEstagioPesquisa());
			stmt.setDate(4, java.sql.Date.valueOf(objetoVO.getDataInicio()));

			PessoaDAO pessoaDAO = new PessoaDAO();
			PessoaVO pessoaVO = pessoaDAO.consultarPesquisador(objetoVO.getPesquisador().getNome(),
					objetoVO.getPesquisador().getCpf());

			stmt.setInt(5, pessoaVO.getIdPessoa());
			stmt.setInt(6, objetoVO.getFase());
			stmt.setInt(7, objetoVO.getQuantidadeDoses());

			stmt.executeUpdate();
			ResultSet chaveGerada = stmt.getGeneratedKeys();
			if (chaveGerada.next()) {
				objetoVO.setIdVacina(chaveGerada.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa! \n" + e.getMessage());
		}
		return objetoVO;
	}

	public boolean excluirDAO(Integer idObjetoVO) {
		boolean resultado = false;
		String query = "DELETE FROM vacina WHERE id_vacina = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idObjetoVO);
			resultado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina! \n" + e.getMessage());
		}
		return resultado;
	}

	public boolean atualizarDAO(VacinaVO objetoVO) {
		boolean resultado = false;
		String query = "UPDATE vacina SET nome = ?, pais_origem = ?, estagio_vacina = ?, data_inicio_pesquisa = ?, "
				+ "id_pesquisador_responsavel = ?, fase = ?, quantidade_doses = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setString(1, objetoVO.getNomeVacina());
			stmt.setString(2, objetoVO.getPaisOrigem());
			stmt.setString(3, objetoVO.getEstagioPesquisa());
			stmt.setDate(4, java.sql.Date.valueOf(objetoVO.getDataInicio()));
			stmt.setInt(5, objetoVO.getPesquisador().getIdPessoa());
			stmt.setInt(6, objetoVO.getFase());
			stmt.setInt(7, objetoVO.getQuantidadeDoses());
			resultado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar vacina! \n" + e.getMessage());
		}
		return resultado;
	}

	public VacinaVO consultarUmDAO(Integer idObjetoVO) {
		VacinaVO vacinaVO = null;
		String query = "SELECT * FROM vacina WHERE id_vacina = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idObjetoVO);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				vacinaVO = this.converterResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoa¹ \n" + e.getMessage());
		}
		return vacinaVO;
	}

	public ArrayList<VacinaVO> consultarTodosDAO() {
		ArrayList<VacinaVO> vacinasVO = new ArrayList<VacinaVO>();
		String query = "SELECT * FROM vacina";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				VacinaVO vacinaVO = this.converterResultSet(resultado);
				vacinasVO.add(vacinaVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas vacinas! \n" + e.getMessage());
		}
		return vacinasVO;
	}

	public VacinaVO converterResultSet(ResultSet resultado) throws SQLException {
		VacinaVO vacinaVO = new VacinaVO();
		vacinaVO.setIdVacina(resultado.getInt("id_vacina"));
		vacinaVO.setNomeVacina(resultado.getString("nome"));
		vacinaVO.setPaisOrigem(resultado.getString("pais_origem"));
		vacinaVO.setEstagioPesquisa(resultado.getString("estagio_vacina"));
		vacinaVO.setDataInicio(resultado.getDate("data_inicio_pesquisa").toLocalDate());
		vacinaVO.setFase(resultado.getInt("fase"));
		vacinaVO.setQuantidadeDoses(resultado.getInt("quantidade_doses"));

		int idPesquisador = resultado.getInt("id_pesquisador_responsavel");
		PessoaDAO pessoaDAO = new PessoaDAO();
		PessoaVO pesquisador = pessoaDAO.consultarUmDAO(idPesquisador);
		vacinaVO.setPesquisador(pesquisador);
		return vacinaVO;
	}

	public VacinaVO consultarVacinaPertencePais(VacinaVO vacinaVO) {
		VacinaVO vacina = null;
		String query = "SELECT * FROM vacina WHERE nome = ? AND pais_origem = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setString(1, vacinaVO.getNomeVacina().toUpperCase());
			stmt.setString(2, vacinaVO.getPaisOrigem().toUpperCase());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				vacina = this.converterResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar vacina por pais! \n" + e.getMessage());
		}
		return vacina;
	}

}
