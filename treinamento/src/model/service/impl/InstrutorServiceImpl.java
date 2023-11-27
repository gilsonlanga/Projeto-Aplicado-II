package model.service.impl;

import java.util.List;

import model.dao.api.InstrutorDAO;
import model.dao.impl.InstrutorDaoImpl;
import model.entidade.Instrutor;
import model.exception.InstrutorInexistenteException;
import model.service.api.InstrutorService;

// É NO SERVICE QUE SÃO IMPLEMENTADAS AS REGRAS DE NEGÓCIO
// É NO SERVICE QUE SÃO FEITAS AS VALIDAÇÕES
// O SERVICE REALIZA A COMUNICAÇÃO COM A CAMADA DAO
// NEM O CONTROLLER NEM A VISÃO PODEM ACESSAR O DAO DIRETAMENTE, SOMENTE ATRAVES DO SERVICE

public class InstrutorServiceImpl implements InstrutorService {
	
	private InstrutorDAO instrutorDao;
	
	public InstrutorServiceImpl() {
		this.instrutorDao = new InstrutorDaoImpl();
	}
	
	@Override
	public void salvar(Instrutor instrutor) {
		this.instrutorDao.salvar(instrutor);
	}
	
	@Override
	public void excluir(int id) {
		Instrutor instrutorParaExclusao = this.buscarPorId(id);
		if(instrutorParaExclusao == null) {
			throw new InstrutorInexistenteException("Não foi possível obter o instrutor que você deseja remover!");
		}
		this.instrutorDao.excluir(id);
	}
	
	@Override
	public List<Instrutor> listarTodos() {
		return this.instrutorDao.listarTodos();
	}
	
	@Override
	public Instrutor buscarPorId(int id) {
		return this.instrutorDao.buscarPorId(id);
	}
	
	

}

