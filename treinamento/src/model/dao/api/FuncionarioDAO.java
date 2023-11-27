package model.dao.api;

import model.entidade.Funcionario;

public interface FuncionarioDAO extends DAO<Funcionario> {
	
	public Funcionario buscarPorId(int id);

}