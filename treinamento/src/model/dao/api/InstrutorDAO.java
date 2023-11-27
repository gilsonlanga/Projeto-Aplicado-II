package model.dao.api;


import model.entidade.Instrutor;

public interface InstrutorDAO extends DAO<Instrutor> {
	
	public Instrutor buscarPorId(int id);

}