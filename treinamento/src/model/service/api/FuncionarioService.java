package model.service.api;

import java.util.List;


import model.entidade.Funcionario;

public interface FuncionarioService {
	
	public void salvar(Funcionario funcionario);
	public void excluir(int id);
	public List<Funcionario> listarTodos();
	public Funcionario buscarPorId(int id);
	
	// é aqui no service que podem ser incluidos outros métodos,
	//como regras de negócio (cálculos, por exemplo);

}