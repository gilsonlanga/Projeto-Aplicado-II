package model.service.api;

import java.util.List;


import model.entidade.Instrutor;

public interface InstrutorService {
	
	public void salvar(Instrutor instrutor);
	public void excluir(int id);
	public List<Instrutor> listarTodos();
	public Instrutor buscarPorId(int id);
	
	// é aqui no service que podem ser incluidos outros métodos,
	//como regras de negócio (cálculos, por exemplo);

}