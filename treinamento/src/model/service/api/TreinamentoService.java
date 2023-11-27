package model.service.api;

import java.util.ArrayList;
import java.util.List;


import model.entidade.Treinamento;

public interface TreinamentoService {
	
	public void salvar(Treinamento treinamento);
	public void excluir(int id);
	public List<Treinamento> listarTodos();
	public Treinamento buscarPorId(int id);
	public List<Treinamento> listarNome(String nomeCurso);
	public List<Treinamento> listarVigencia(String dataVigencia);
	public List<Treinamento> listarFuncionario(String funcionario);
	public List<Treinamento> listarDataTermino(String dataTermino);
	
	// é aqui no service que podem ser incluidos outros métodos,
	//como regras de negócio (cálculos, por exemplo);

}