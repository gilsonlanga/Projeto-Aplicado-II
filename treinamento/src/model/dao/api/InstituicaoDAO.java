package model.dao.api;

import model.entidade.Instituicao;

public interface InstituicaoDAO extends DAO<Instituicao> {
	
	public Instituicao buscarPorId(int id);

}