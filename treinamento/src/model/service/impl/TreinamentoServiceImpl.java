package model.service.impl;

import java.util.ArrayList;
import java.util.List;

import model.dao.api.TreinamentoDAO;
import model.dao.impl.TreinamentoDaoImpl;
import model.entidade.Treinamento;
import model.exception.TreinamentoInexistenteException;
import model.service.api.TreinamentoService;

// É NO SERVICE QUE SÃO IMPLEMENTADAS AS REGRAS DE NEGÓCIO
// É NO SERVICE QUE SÃO FEITAS AS VALIDAÇÕES
// O SERVICE REALIZA A COMUNICAÇÃO COM A CAMADA DAO
// NEM O CONTROLLER NEM A VISÃO PODEM ACESSAR O DAO DIRETAMENTE, SOMENTE ATRAVES DO SERVICE

public class TreinamentoServiceImpl implements TreinamentoService {
	
	private TreinamentoDAO treinamentoDao;
	
	public TreinamentoServiceImpl() {
		this.treinamentoDao = new TreinamentoDaoImpl();
	}
	
	@Override
	public void salvar(Treinamento treinamento) {
		this.treinamentoDao.salvar(treinamento);
	}
	
	@Override
	public void excluir(int id) {
		Treinamento treinamentoParaExclusao = this.buscarPorId(id);
		if(treinamentoParaExclusao == null) {
			throw new TreinamentoInexistenteException("Não foi possível obter o treinamento que você deseja remover!");
		}
		this.treinamentoDao.excluir(id);
	}
	
	@Override
	public List<Treinamento> listarTodos() {
		return this.treinamentoDao.listarTodos();
	}
	
	@Override
	public Treinamento buscarPorId(int id) {
		return this.treinamentoDao.buscarPorId(id);
	}
	
	@Override
	public List<Treinamento> listarNome(String nomeCurso) {
		return this.treinamentoDao.listarNome(nomeCurso);
	}
	
	@Override
	public List<Treinamento> listarVigencia(String dataVigencia) {
		return this.treinamentoDao.listarVigencia(dataVigencia);
	}
	
	@Override
	public List<Treinamento> listarFuncionario(String funcionario) {
		return this.treinamentoDao.listarFuncionario(funcionario);
	}
	
	@Override
	public List<Treinamento> listarDataTermino(String dataTermino) {
		return this.treinamentoDao.listarDataTermino(dataTermino);
	}
	

}

