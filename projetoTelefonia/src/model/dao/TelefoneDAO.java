package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Telefone;

public class TelefoneDAO {

	public static final int CODIGO_TELEFONE_SEM_CLIENTE = 0;

	public Telefone cadastrar(Telefone telefone) {
		String sql = "INSERT INTO telefone  (codigo_internacional, ddd, numero, id_cliente, movel, ativo) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);) {
			stmt.setString(1, telefone.getCodigoInternacional());
			stmt.setString(2, telefone.getDdd());
			stmt.setString(3, telefone.getNumero());

			if (telefone.getIdCliente() == null) {
				stmt.setInt(4, CODIGO_TELEFONE_SEM_CLIENTE);
				stmt.setBoolean(6, false);
			} else {
				stmt.setInt(4, telefone.getIdCliente());
				stmt.setBoolean(6, true);
			}

			stmt.setBoolean(5, telefone.isMovel());
			stmt.executeUpdate();
			ResultSet chaveGerada = stmt.getGeneratedKeys();
			if (chaveGerada.next()) {
				telefone.setIdCliente(chaveGerada.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar telefone: \n" + e.getMessage());
		}
		return telefone;
	}

	public boolean atualizar(Telefone telefone) {
		boolean atualizado = false;
		String sql = "UPDATE telefone SET codigo_internacional = ?, ddd = ?, numero = ?, id_cliente = ?, movel = ?, ativo = ? WHERE id_telefone = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setString(1, telefone.getCodigoInternacional());
			stmt.setString(2, telefone.getDdd());
			stmt.setString(3, telefone.getNumero());

			if (telefone.getIdCliente() == null) {
				stmt.setInt(4, CODIGO_TELEFONE_SEM_CLIENTE);
				stmt.setBoolean(6, false);
			} else {
				stmt.setInt(4, telefone.getIdCliente());
				stmt.setBoolean(6, true);
			}

			stmt.setBoolean(5, telefone.isMovel());
			stmt.setInt(7, telefone.getId());
			atualizado = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar telefone: \n" + e.getMessage());
		}
		return atualizado;
	}

	public boolean excluir(Integer idTelefone) {
		boolean excluir = false;
		String sql = "DELETE FROM telefone WHERE id_telefone = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setInt(1, idTelefone);
			excluir = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir telefone: \n" + e.getMessage());
		}
		return excluir;
	}

	public Telefone consultarUmTelefone(Integer idTelefone) {
		Telefone telefone = null;
		String sql = "SELECT * FROM telefone WHERE id_telefone = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setInt(1, idTelefone);
			ResultSet resultadoConsulta = stmt.executeQuery();
			if (resultadoConsulta.next()) {
				telefone = this.converterDoResultSet(resultadoConsulta);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar telefone: \n" + e.getMessage());
		}
		return telefone;
	}

	public List<Telefone> consultarTodosTelefones() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		String sql = "SELECT * FROM telefone";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			ResultSet resultadoConsulta = stmt.executeQuery();
			while (resultadoConsulta.next()) {
				Telefone telefone = this.converterDoResultSet(resultadoConsulta);
				telefones.add(telefone);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente: \n" + e.getMessage());
		}
		return telefones;
	}

	private Telefone converterDoResultSet(ResultSet resultadoConsulta) throws SQLException {
		Telefone telefone = new Telefone();
		telefone.setId(resultadoConsulta.getInt("id_telefone"));
		telefone.setCodigoInternacional(resultadoConsulta.getString("codigo_internacional"));
		telefone.setDdd(resultadoConsulta.getString("ddd"));
		telefone.setNumero(resultadoConsulta.getString("numero"));
		telefone.setIdCliente(resultadoConsulta.getInt("id_cliente"));
		telefone.setMovel(resultadoConsulta.getBoolean("movel"));
		telefone.setAtivo(resultadoConsulta.getBoolean("ativo"));
		return telefone;
	}

	public boolean numeroDisponivel(Telefone telefone) {
		String sql = "SELECT COUNT(id_telefone) FROM telefone WHERE ddd = ? AND numero = ?";
		boolean numeroDisponivel = false;
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setString(1, telefone.getDdd());
			stmt.setString(2, telefone.getNumero());
			ResultSet resultadoConsulta = stmt.executeQuery();
			if (resultadoConsulta.next()) {
				numeroDisponivel = resultadoConsulta.getInt(1) == 0;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar disponibilidade numero" + e.getMessage());
		}
		return numeroDisponivel;
	}

	public List<Telefone> consultarPorIdCliente(Integer idCliente) {
		List<Telefone> telefones = new ArrayList<Telefone>();
		String sql = "SELECT * FROM telefone WHERE id_cliente = ?";
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setInt(1, idCliente);
			ResultSet resultadoConsulta = stmt.executeQuery();
			while (resultadoConsulta.next()) {
				Telefone telefone = this.converterDoResultSet(resultadoConsulta);
				telefones.add(telefone);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar telefone por id do cliente: \n" + e.getMessage());
		}
		return telefones;
	}
}
