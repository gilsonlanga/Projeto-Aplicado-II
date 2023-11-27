package model.dao.api;

import java.util.List;

public interface DAO<T> {
	
	public void salvar(T t);
	public void excluir(int id);
	public List<T> listarTodos(); // Aqui tem que verificar as lógicas para as pesquisas no banco de dados

}
