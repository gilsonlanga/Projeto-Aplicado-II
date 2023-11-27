package model.service.api;

import java.util.List;


import model.entidade.Curso;

public interface CursoService {
	
	public void salvar(Curso curso);
	public void excluir(int id);
	public List<Curso> listarTodos();
	public Curso buscarPorId(int id);
	
	// é aqui no service que podem ser incluidos outros métodos,
	//como regras de negócio (cálculos, por exemplo);

}