package controller.api;

import java.util.ArrayList;
import java.util.List;

import model.entidade.Treinamento;
import model.exception.TreinamentoInexistenteException;

public interface TreinamentoController {
	
	public void salvar(Treinamento treinamento);
	public void excluir(int id) throws TreinamentoInexistenteException; //para mandar a execption pra visão
	public List<Treinamento> listarTodos();
	public Treinamento buscarPorId(int id);
	public List<Treinamento> listarNome(String nomeCurso);
	public List<Treinamento> listarVigencia(String dataVigencia);
	public List<Treinamento> listarFuncionario(String funcionario);
	public List<Treinamento> listarDataTermino(String dataTermino);
	

}