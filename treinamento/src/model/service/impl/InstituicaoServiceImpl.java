package model.service.impl;

import java.util.List;

import model.dao.api.InstituicaoDAO;
import model.dao.impl.InstituicaoDaoImpl;
import model.entidade.Instituicao;
import model.exception.InstituicaoInexistenteException;
import model.service.api.InstituicaoService;

// É NO SERVICE QUE SÃO IMPLEMENTADAS AS REGRAS DE NEGÓCIO
// É NO SERVICE QUE SÃO FEITAS AS VALIDAÇÕES
// O SERVICE REALIZA A COMUNICAÇÃO COM A CAMADA DAO
// NEM O CONTROLLER NEM A VISÃO PODEM ACESSAR O DAO DIRETAMENTE, SOMENTE ATRAVES DO SERVICE

public class InstituicaoServiceImpl implements InstituicaoService {
	
	private InstituicaoDAO instituicaoDao;
	
	public InstituicaoServiceImpl() {
		this.instituicaoDao = new InstituicaoDaoImpl();
	}
	
	@Override
	public void salvar(Instituicao instituicao) {
		this.instituicaoDao.salvar(instituicao);
	}
	
	@Override
	public void excluir(int id) {
		Instituicao instituicaoParaExclusao = this.buscarPorId(id);
		if(instituicaoParaExclusao == null) {
			throw new InstituicaoInexistenteException("Não foi possível obter a instituição que você deseja remover!");
		}
		this.instituicaoDao.excluir(id);
	}
	
	@Override
	public List<Instituicao> listarTodos() {
		return this.instituicaoDao.listarTodos();
	}
	
	@Override
	public Instituicao buscarPorId(int id) {
		return this.instituicaoDao.buscarPorId(id);
	}
	
	

}

