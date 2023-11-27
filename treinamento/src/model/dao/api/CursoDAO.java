package model.dao.api;

import model.entidade.Curso;

public interface CursoDAO extends DAO<Curso> {
	
	public Curso buscarPorId(int id);

}
