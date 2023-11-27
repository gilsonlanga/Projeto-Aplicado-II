package model.service.impl;

import java.util.List;

import model.dao.api.AreaAbrangenciaDAO;
import model.dao.impl.AreaAbrangenciaDaoImpl;
import model.entidade.AreaAbrangencia;
import model.exception.AreaAbrangenciaInexistenteException;
import model.service.api.AreaAbrangenciaService;

// É NO SERVICE QUE SÃO IMPLEMENTADAS AS REGRAS DE NEGÓCIO
// É NO SERVICE QUE SÃO FEITAS AS VALIDAÇÕES
// O SERVICE REALIZA A COMUNICAÇÃO COM A CAMADA DAO
// NEM O CONTROLLER NEM A VISÃO PODEM ACESSAR O DAO DIRETAMENTE, SOMENTE ATRAVES DO SERVICE

public class AreaAbrangenciaServiceImpl implements AreaAbrangenciaService {
	
	private AreaAbrangenciaDAO areaAbrangenciaDao;
	
	public AreaAbrangenciaServiceImpl() {
		this.areaAbrangenciaDao = new AreaAbrangenciaDaoImpl();
	}
	
	@Override
	public void salvar(AreaAbrangencia areaAbrangencia) {
		this.areaAbrangenciaDao.salvar(areaAbrangencia);
	}
	
	@Override
	public void excluir(int id) {
		AreaAbrangencia areaAbrangenciaParaExclusao = this.buscarPorId(id);
		if(areaAbrangenciaParaExclusao == null) {
			throw new AreaAbrangenciaInexistenteException("Não foi possível obter a Area de Abrangencia que você deseja remover!");
		}
		this.areaAbrangenciaDao.excluir(id);
	}
	
	@Override
	public List<AreaAbrangencia> listarTodos() {
		return this.areaAbrangenciaDao.listarTodos();
	}
	
	@Override
	public AreaAbrangencia buscarPorId(int id) {
		return this.areaAbrangenciaDao.buscarPorId(id);
	}
	
	

}
