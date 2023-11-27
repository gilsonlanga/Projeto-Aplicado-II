package model.dao.api;

import java.util.ArrayList;
import java.util.List;

import model.entidade.Treinamento;

public interface TreinamentoDAO extends DAO<Treinamento> {
	
	public Treinamento buscarPorId(int id);

	public List<Treinamento> listarNome(String nomeCurso);
	public List<Treinamento> listarVigencia(String dataVigencia);
	public List<Treinamento> listarFuncionario(String funcionario);
	public List<Treinamento> listarDataTermino(String dataTermino);

}
