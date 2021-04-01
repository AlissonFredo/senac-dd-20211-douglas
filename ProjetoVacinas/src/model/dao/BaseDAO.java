package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BaseDAO<T> {

	public T cadastrarDAO(T objetoVO);

	public boolean excluirDAO(Integer idObjetoVO);

	public boolean atualizarDAO(T objetoVO);

	public T consultarUmDAO(Integer idObjetoVO);

	public ArrayList<T> consultarTodosDAO();

	public T converterResultSet(ResultSet resultado) throws SQLException;
}
