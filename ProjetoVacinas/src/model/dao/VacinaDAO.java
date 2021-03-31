package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.PessoaVO;
import model.vo.VacinaVO;

public class VacinaDAO {

	public VacinaVO cadastrarVacinaDAO(VacinaVO vacinaVO) {
		String query = "INSERT INTO vacina (nome, pais_origem, estagio_vacina, data_inicio_pesquisa, id_pesquisador_responsavel, fase, quantidade_doses) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query)) {
			stmt.setString(1, vacinaVO.getNomeVacina());
			stmt.setString(2, vacinaVO.getPaisOrigem());
			stmt.setString(3, vacinaVO.getEstagioPesquisa());
			stmt.setDate(4, java.sql.Date.valueOf(vacinaVO.getDataInicio()));
			stmt.setInt(5, vacinaVO.getPesquisador().getIdPessoa());
			stmt.setInt(6, vacinaVO.getFase());
			stmt.setInt(7, vacinaVO.getQuantidadeDoses());

			stmt.executeUpdate();
			ResultSet chaveGerada = stmt.getGeneratedKeys();
			if (chaveGerada.next()) {
				vacinaVO.setIdVacina(chaveGerada.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa! \n" + e.getMessage());
		}
		return vacinaVO;
	}

	public boolean excluirVacinaDAO(Integer idVacina) {
		boolean resultado = false;
		String query = "DELETE FROM vacina WHERE id_vacina = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idVacina);
			resultado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina! \n" + e.getMessage());
		}
		return resultado;
	}

	public boolean atualizarVacinaDAO(VacinaVO vacinaVO) {
		boolean resultado = false;
		String query = "UPDATE vacina SET nome = ?, pais_origem = ?, estagio_vacina = ?, data_inicio_pesquisa = ?, "
				+ "id_pesquisador_responsavel = ?, fase = ?, quantidade_doses = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setString(1, vacinaVO.getNomeVacina());
			stmt.setString(2, vacinaVO.getPaisOrigem());
			stmt.setString(3, vacinaVO.getEstagioPesquisa());
			stmt.setDate(4, java.sql.Date.valueOf(vacinaVO.getDataInicio()));
			stmt.setInt(5, vacinaVO.getPesquisador().getIdPessoa());
			stmt.setInt(6, vacinaVO.getFase());
			stmt.setInt(7, vacinaVO.getQuantidadeDoses());
			resultado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar vacina! \n" + e.getMessage());
		}
		return resultado;
	}

	public VacinaVO consultarUmaVacinaDAO(Integer idVacina) {
		VacinaVO vacinaVO = null;
		String query = "SELECT * FROM vacina WHERE id_vacina = ?";
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, query);) {
			stmt.setInt(1, idVacina);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				vacinaVO = this.converterResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoa¹ \n" + e.getMessage());
		}
		return vacinaVO;
	}

	public ArrayList<VacinaVO> consultarTodosVacinaDAO() {
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

	private VacinaVO converterResultSet(ResultSet resultado) throws SQLException {
		VacinaVO vacinaVO = new VacinaVO();
		vacinaVO.setIdVacina(resultado.getInt("id_vacina"));
		vacinaVO.setNomeVacina(resultado.getString("nome"));
		vacinaVO.setPaisOrigem(resultado.getString("estagio_vacina"));
		vacinaVO.setDataInicio(resultado.getDate("data_inicio_pesquisa").toLocalDate());
		vacinaVO.setFase(resultado.getInt("fase"));
		vacinaVO.setQuantidadeDoses(resultado.getInt("quantidade_doses"));
		int idPesquisador = resultado.getInt("id_pesquisador_responsavel");
		PessoaDAO pessoaDAO = new PessoaDAO();
		PessoaVO pesquisador = pessoaDAO.consultarUmaPessoaDAO(idPesquisador);
		vacinaVO.setPesquisador(pesquisador);
		return vacinaVO;
	}

}
