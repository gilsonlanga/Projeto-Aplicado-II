package model.service.api;

import java.util.List;


import model.entidade.Instituicao;

public interface InstituicaoService {
	
	public void salvar(Instituicao instituicao);
	public void excluir(int id);
	public List<Instituicao> listarTodos();
	public Instituicao buscarPorId(int id);
	
	// é aqui no service que podem ser incluidos outros métodos,
	//como regras de negócio (cálculos, por exemplo);

}